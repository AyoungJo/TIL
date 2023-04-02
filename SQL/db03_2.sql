SELECT * FROM ACCOUNT;
SELECT * FROM USERS;

--1. 계좌 ( account ) 테이블을 조회하되, 고객명 ( name ) 도 함께 조회한다. ( 단, ANSI JOIN 을 사용 )
SELECT ACCOUNT.*, USERS.NAME
FROM ACCOUNT LEFT OUTER JOIN USERS
ON ACCOUNT.USER_SEQ = USERS.USER_SEQ;

--2. 위 1번 query 를 table alias 를 사용하고, 오라클 Join 표기법을 사용한다.
SELECT A.*, U.NAME
FROM ACCOUNT A LEFT OUTER JOIN USERS U
ON A.USER_SEQ = U.USER_SEQ;

--3. 고객번호 ( user_seq ) 가 111 인 고객의 계좌 중 잔고 ( balance ) 가 2000 이상 계좌 ( account ) 테이블을 조회하되,
--고객번호, 고객명, 계좌번호, 잔고 순으로 조회한다.
SELECT A.USER_SEQ, U.NAME, A.ACCOUNT_NUMBER, A.BALANCE
FROM ACCOUNT A JOIN USERS U
ON A.USER_SEQ = U.USER_SEQ
WHERE  A.USER_SEQ = 111 AND A.BALANCE >=2000;

--4. 계좌 ( account ) 테이블의 잔고 ( balance ) 가 5000 이상인 
--고객의 고객번호 ( user_seq ), 고객명 ( name ), 잔고 ( balance ) 를 조회한다. ( 단 Subquery 를 사용하지 않고 join 으로만 작성 )
SELECT A.USER_SEQ, U.NAME, A.BALANCE
FROM ACCOUNT A JOIN USERS U
ON A.USER_SEQ = U.USER_SEQ
WHERE A.BALANCE >= 5000;

--5. 위 4번 문제를 Subquery 를 이용해서 작성한다.
SELECT DISTINCT U.USER_SEQ, U.NAME, A.BALANCE
FROM ACCOUNT A, USERS U
WHERE A.USER_SEQ = U.USER_SEQ
AND A.ACCOUNT_NUMBER  = ANY 
(SELECT ACCOUNT_NUMBER
FROM ACCOUNT WHERE BALANCE >= 5000);

--6. 고객 ( users ) 테이블에서 고객번호 ( user_seq ), 고객명 ( name ) 조회하되, 
--고객명 뒤에 계좌의 수도 account_cnt 로 함께 조회한다. ( 단, 계좌가 없는 고객은 제외한다. )
SELECT U.USER_SEQ, NAME, COUNT(A.ACCOUNT_NUMBER) AS account_cnt
FROM ACCOUNT A JOIN USERS U
ON A.USER_SEQ = U.USER_SEQ
WHERE ACCOUNT_NUMBER IS NOT NULL
GROUP BY U.USER_SEQ, U.NAME;

--7. 위 6번 문제를 조회하되 계좌가 없는 고객도 함께 조회하고 계좌의 수에 0 으로 표시한다.
SELECT U.USER_SEQ, NAME, COUNT(A.ACCOUNT_NUMBER) AS account_cnt
FROM ACCOUNT A RIGHT OUTER JOIN USERS U
ON A.USER_SEQ = U.USER_SEQ
GROUP BY U.USER_SEQ, U.NAME;

--8. 각 계좌별 잔고 ( balance ) 가 전체 평균 잔고보다 적은 고객의 고객번호 ( user_seq ), 고객명 ( name ) 을 조회한다.
SELECT DISTINCT A.USER_SEQ, U.NAME
FROM ACCOUNT A JOIN USERS U
ON  A.USER_SEQ = U.USER_SEQ
WHERE BALANCE < (SELECT AVG(BALANCE)
FROM ACCOUNT);

--9. 고객의 잔고의 합이 전체 평균 잔고 + 5000 이하인 고객의 고객번호 ( user_seq ), 고객명 ( name ) 을 조회한다.
SELECT DISTINCT A.USER_SEQ, NAME
FROM ACCOUNT A LEFT OUTER JOIN USERS U
ON A.USER_SEQ = U.USER_SEQ
GROUP BY A.USER_SEQ, U.NAME
HAVING SUM(BALANCE) <= 
(SELECT AVG(BALANCE)+5000
FROM ACCOUNT);

--10. 계좌 ( account ) 테이블에서 balance 기준 내림차순으로 정렬하되, 상위 5 건만 조회한다.
SELECT *
FROM ACCOUNT
WHERE BALANCE IS NOT NULL
AND ROWNUM <= 5
ORDER BY BALANCE DESC;

--11. salary 가 10000 이상인 사원의
--employee_id, first_name, last_name, salary, job_title, department_name 을 조회한다.
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME, E.SALARY, J.JOB_TITLE, D.DEPARTMENT_NAME
FROM EMPLOYEES E JOIN DEPARTMENTS D 
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
JOIN JOBS J
ON E.JOB_ID = J.JOB_ID
WHERE E.SALARY > 10000;

--12. job_id 가 IT_PROG 인 사원의 평균 salary 보다 salary 가 더 많은 사원의 총 수를 구한다.
SELECT COUNT(*)
FROM EMPLOYEES
WHERE SALARY >= (SELECT AVG(SALARY)
FROM EMPLOYEES
WHERE JOB_ID = 'IT_PROG');

--13. 입사일자가 '97/06/25' 이후 입사한 사원 중 부서의 최소 salary 가 8000 이상이고
--부서의 최대 salary 가 20000 이하 인 부서에 해당하는 사원 전체를 조회한다.

SELECT * FROM EMPLOYEES
WHERE DEPARTMENT_ID IN
(SELECT DEPARTMENT_ID
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING MIN(SALARY)>=8000 AND MAX(SALARY)<=20000)
AND TO_CHAR(HIRE_DATE) < '97/06/25';

--14. manager_id 가 108 인 department 소속 사원들의 평균 salary 를 구하여, 
--department_id, department_avg_salary 로 조회한다.
SELECT DEPARTMENT_ID , AVG(SALARY) AS DEPARTMENT_AVG_SALARY
FROM EMPLOYEES
WHERE MANAGER_ID = 108
GROUP BY DEPARTMENT_ID;

--15. manager_id 가 없는 사원이 manager 로 등록되어 있는 사원의 employee_id, first_name, last_name, salary, job_title 조회한다.
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, JOB_TITLE 
FROM EMPLOYEES E JOIN JOBS J
ON E.JOB_ID = J.JOB_ID
WHERE MANAGER_ID 
= (SELECT EMPLOYEE_ID FROM EMPLOYEES
WHERE MANAGER_ID IS NULL);


SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
SELECT * FROM JOBS;

