 --EMP테이블에서 평균 급여보다 더 많이 받는 사원 검색
  --1) 먼저, 평균 급여를 구한다
  SELECT AVG(SAL) FROM EMP; --2073
  
  --2) 1의 결과를 조건으로 사용한다.
  SELECT *  FROM EMP
  WHERE SAL> ANY (SELECT AVG(SAL) FROM EMP);
      
-- JOB에 'A'문자열이 들어간 사원의 부서와 같은 곳에서 근무하는 사원의 부서이름 검색하고 싶다. 
  SELECT * FROM DEPT;
  SELECT * FROM EMP;
  
  SELECT DISTINCT DEPTNO FROM EMP
  WHERE JOB LIKE '%A%';
  
  SELECT DEPTNO, DNAME
  FROM DEPT
  WHERE DEPTNO 
  = ANY ( SELECT DISTINCT DEPTNO 
                 FROM EMP
                WHERE JOB LIKE '%A%');
  --서브쿼리 결과 레코드행이 여러개일 때 IN, ANY, ALL 사용
  
     
 -- 부서번호가 30인 사원들이 급여중에서 가장 많이 받는 사원보다 더 많이 받는 사원정보를 검색하고 싶다. 
SELECT MAX(SAL)
                FROM EMP
                WHERE DEPTNO = 30; --하위질의의 최대값보다 크면

SELECT * FROM EMP
WHERE SAL > (SELECT MAX(SAL)
                        FROM EMP
                        WHERE DEPTNO = 30); --하위 결과 1행이므로 비교연산자 사용가능

SELECT * FROM EMP
WHERE SAL > ALL (SELECT SAL
FROM EMP
WHERE DEPTNO = 30);

SELECT * FROM COPY_EMP;
DELETE FROM COPY_EMP;

COMMIT;
-- SUBQUERY를 INSERT
INSERT INTO COPY_EMP (SELECT * FROM EMP WHERE SAL >2000);

--특정한 컬럼만 다른 테이블로부터 가져와서 INSERT 한다.
INSERT INTO COPY_EMP(EMPNO, ENAME, JOB, SAL)
(SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO=20);


--SUBQUERY를 UPDATE
   --EX) EMP테이블에서 EMPNO 7900인 사원의 JOB, MGR, DEPTNO로 COPY_EMP테이블의 7566의 사원의 정보로 수정해보자.
UPDATE COPY_EMP
SET JOB = (SELECT JOB FROM EMP WHERE EMPNO=7900),
MGR = (SELECT MGR FROM EMP WHERE EMPNO=7900),
DEPT = (SELECT MGR FROM EMP WHERE EMPNO=7900)
WHERE EMPNO=7566;

UPDATE COPY_EMP
SET (JOB, MGR, DEPTNO)
= (SELECT JOB, MGR, DEPTNO FROM EMP WHERE EMPNO=7900)
WHERE EMPNO=7566; 

SELECT * FROM COPY_EMP;

--SUBQUERY를 DELETE
   --EX) EMP테이블이 평균 급여를 조건으로 사용해서 평균급여보다 적게 받는 사원들을 삭제한다. 
DELETE 
FROM COPY_EMP
WHERE SAL< (SELECT AVG(SAL) FROM EMP);

--상호관계 서브쿼리
SELECT EMPNO, ENAME, JOB, SAL, DEPTNO
FROM EMP E
WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO)
ORDER BY DEPTNO;

--------------------------------------------------------------
/*
  SUBQUERY 종류중의 하나인 인라인뷰
   : FROM절 뒤에 서브쿼리가 오는 것.
*/

-- 급여를 기준으로 정렬해서 ROWNUM을 함께 출력하고 싶다.
SELECT ROWNUM, EMPNO, ENAME, JOB, SAL 
FROM EMP 
ORDER BY SAL DESC; -- 정렬을 한 결과를 테이블처럼 사용하면서 ROWNUM 이용해야한다.

--1) 먼저 정렬한다.
SELECT * FROM EMP ORDER BY SAL DESC;

SELECT ROWNUM, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL DESC) ;--인라인뷰

-- ROWNUM을 대상으로 조건을 만들어보자 .
--1. ROWUM이 3보다 작은 레코드 검색
SELECT ROWNUM, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL DESC) 
WHERE ROWNUM < 3;

--2. ROWUM이 3보다 큰 레코드 검색
SELECT ROWNUM, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL DESC) 
WHERE ROWNUM > 3; --X, 새롭게 부여되는 ROWNUM. 1,2가 안만들어졌기 때문

--3. ROWUM이 5 ~ 7 사이 레코드 검색
SELECT ROWNUM, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL DESC) 
WHERE ROWNUM BETWEEN 5 AND 7 ; --X

/*
  ROWNUM은 레코드가 만들어지면서 번호가 순차적으로 부여되는 것을 ROWNUM 1 이 없으면 2를 실행할수 없다. 
  그래서 ROWNUM를 조건으로  ~ 크다  또는 중간범위를 직접 조건으로 사용할수없다.
  ROWNUM을 미리 다 부여된 결과를 조건으로 사용해야한다. 
*/
SELECT * FROM 
    (SELECT ROWNUM NO, ENAME, JOB, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL DESC) )
WHERE NO >3 ; 
SELECT * FROM 
    (SELECT ROWNUM NO, ENAME, JOB, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL DESC) )
WHERE NO BETWEEN 5 AND 7 ;
