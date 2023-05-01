select * from productlist;

CREATE TABLE productList(
    code VARCHAR2(50) PRIMARY KEY,
    name VARCHAR2(50),
    qty INT,
    price INT,
    detail VARCHAR2(100)
);

insert into productlist values('A01','새우깡',10,1500,'새우의 짠맛');
insert into productlist values('A02','감자깡',15,2500,'감자의 고소한 맛');
insert into productlist values('A03','새우칩',8,300,'새우의 참맛');
insert into productlist values('A04','고소미',20,2500,'고소미는 고소해');
insert into productlist values('A05','짱구',25,800,'달달함과 고소함');

commit




