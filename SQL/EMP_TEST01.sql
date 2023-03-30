--emp 테이블 생성
Create Table emp(
	emp_id NUMBER,                   --사원번호
	emp_name Varchar2(20) Not Null,  --사원이름
	job Varchar2(20) Not Null,       --직업
	dept_id NUMBER,                  --부서번호
	sal NUMBER Not Null,             --급여
	bonus NUMBER,                    --보너스
	mgr_id NUMBER,                   --관리자번호
	hiredate date Not Null,          --입사일
	constraint emp_id_pk Primary Key(emp_id) --제약조건
);

--데이터삽입
INSERT INTO EMP VALUES (6200,'박철수','대표이사',200,  5000,NULL,NULL, '1997-12-17');

INSERT INTO EMP VALUES (6311,'김대정','부장',100, 3500,Null,6200, '1998-12-17');

INSERT INTO EMP VALUES (7489,'민동규','세일즈',400,  1850,200,6321, '1999-02-27') ;

INSERT INTO EMP VALUES (7522,'정종철','세일즈',400, 1850,300,6321,'1998-02-28') ;

INSERT INTO EMP VALUES (6321,'이종길','부장',400, 3800,500,6200,'1999-04-20') ;

INSERT INTO EMP VALUES (6351,'진대준','부장',300,   2850,NULL,6200,'2000-05-31'); 

INSERT INTO EMP VALUES (7910,'이영희','경리',300, 1000,NULL,6351,'2001-05-01');

INSERT INTO EMP VALUES (6361,'김철수','부장',200, 3200,NULL,6200,'2000-06-09') ;

INSERT INTO EMP VALUES (7878,'백기수','연구직',200, 3000,NULL,6361,'2001-06-05') ;

INSERT INTO EMP VALUES (7854,'진영진','세일즈',400, 1500,0,6321,'2001-09-08') ;

INSERT INTO EMP VALUES (7872,'이문정','사무직',100, 1500,NULL,6311,'2001-02-12') ;

INSERT INTO EMP VALUES (7920,'김마리아','사무직',300, 1050,NULL,6351,'2001-03-18');

INSERT INTO EMP VALUES (7901,'정동길','연구직',NULL, 3000,NULL,NULL,'2001-12-03'); 

INSERT INTO EMP VALUES (7933,'김철수','사무직',200,  1050,NULL,6361,'2002-01-02');

SELECT * FROM EMP;
