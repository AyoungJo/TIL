--1-1. create 문을 만들어 실행한다.
--1-2. user_seq 컬럼에 PK Constraint 를 적용한다.
--1-3. email 컬럼에 not null, unique 속성을 부여한다.
--1-4. is_sleep 컬럼에 default 값으로 'N' 을 설정한다.

CREATE TABLE USERS 
(user_seq NUMBER(5) PRIMARY KEY,
name VARCHAR2(12), 
email VARCHAR2(20) NOT NULL UNIQUE, 
phone VARCHAR2(14),
isSleep char(1) DEFAULT 'N'
);

--1-5. users 테이블의 기본 설정을 확인한다 .
DESC USERS;

--2. ws_07 의 ServiceImpl 에서 테스트한 사용자 데이터를 이용해서 3개의 insert 를 실행한
--다. ( 단, is_sleep 컬럼은 제외하고 default 값을 확인한다. )
INSERT INTO USERS(user_seq, name, email, phone) VALUES (111, '조아영', 'joa@gmail.com', '010-1111-1111');
INSERT INTO USERS(user_seq, name, email, phone) VALUES (222, '예삐', 'yeahbbi@naver.com', '010-2222-2222');
INSERT INTO USERS(user_seq, name, email, phone) VALUES (333, '미니', 'mini@naver.com', '010-3333-3333');

--3. users 테이블에 등록된 3 개의 고객 정보를 select 문으로 확인한다. 이 때, is_sleep 컬럼
--의 값을 확인한다.
SELECT * FROM USERS;

ALTER TABLE USERS RENAME COLUMN isSleep TO is_sleep;

SELECT * FROM USERS;


--4. user_seq 가 222 인 고객의 is_sleep 값을 ‘Y’ 로 변경하고 그 결과를 select 로 확인한다.
UPDATE USERS SET is_sleep='Y' WHERE user_seq = 222;

SELECT * FROM USERS;

--5. 아래의 값으로 새로운 1건의 데이터를 insert 해 보고 오류를 확인한다.
--user_seq : 222,
--name : ‘이길동2’
--email : ‘lee2@gildong.com’
--phone : ‘010-2222-2222’

INSERT INTO USERS(user_seq, name, email, phone) VALUES (222, '이길동2', 'lee2@gildong.com', '010-2222-2222');
-- ORA-00001: 무결성 제약 조건(EXAM.SYS_C0017418)에 위배됩니다

--6. 아래의 값으로 새로운 1건의 데이터를 insert 해 보고 오류를 확인한다.
--user_seq : 2222,
--name : ‘이길동2’
--email : ‘lee@gildong.com’
--phone : ‘010-2222-2222’

INSERT INTO USERS(user_seq, name, email, phone) VALUES (2222, '이길동2', 'lee@gildong.com', '010-2222-2222');

SELECT * FROM USERS;

--7. 아래의 값으로 새로운 1건의 데이터를 insert 해 보고 오류를 확인한다.
--user_seq : 2222,
--name : ‘이길동2’
--phone : ‘010-2222-2222’

INSERT INTO USERS(user_seq, name, phone) VALUES (2222, '이길동2', '010-2222-2222');
--ORA-01400: NULL을 ("EXAM"."USERS"."EMAIL") 안에 삽입할 수 없습니다

--8.
--아래의 값으로 새로운 1 건의 데이터를 insert 한다
--user_seq : 2222,
--name : ‘이길동2’
--email : ‘lee2@gildong.com’
--phone : ‘010-2222-2222’

INSERT INTO USERS(user_seq, name, email, phone) VALUES (2222, '이길동2', 'lee2@gildong.com', '010-2222-2222');
--ORA-00001: 무결성 제약 조건(EXAM.SYS_C0017418)에 위배됩니다

--9.위 8 번 등록 건을 확인하고 삭제한다
SELECT * FROM USERS;

DELETE FROM USERS WHERE user_seq = 2222;

SELECT * FROM USERS;

--10. users 테이블을 삭제하고 workshop 1 4 번까지 다시 실행한다
DROP TABLE USERS;
