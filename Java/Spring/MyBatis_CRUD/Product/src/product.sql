select * from productlist;

CREATE TABLE productList(
    code VARCHAR2(50) PRIMARY KEY,
    name VARCHAR2(50),
    qty INT,
    price INT,
    detail VARCHAR2(100)
);

insert into productlist values('A01','�����',10,1500,'������ §��');
insert into productlist values('A02','���ڱ�',15,2500,'������ ����� ��');
insert into productlist values('A03','����Ĩ',8,300,'������ ����');
insert into productlist values('A04','��ҹ�',20,2500,'��ҹ̴� �����');
insert into productlist values('A05','¯��',25,800,'�޴��԰� �����');

commit




