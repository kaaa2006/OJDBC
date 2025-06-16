create table member( -- ������̺�
mno number(5) not null, 
name varchar2(10)not null  ,
id varchar2(10)primary key ,
pw varchar2(10) not null,
regidate date default sysdate not null
)
create sequence member_seq increment by 1 start with 1 nocycle nocache

drop table member -- ������̺� ������

----------���̳�����--------------
insert into member (mno,name,id,pw) values (member_seq.nextval,'ȫ�浿','hong','1111')
insert into member (mno,name,id,pw) values (member_seq.nextval,'���߱�','an','2222')
insert into member (mno,name,id,pw) values (member_seq.nextval,'�����','son','3333')
insert into member (mno,name,id,pw) values (member_seq.nextval,'����','sejong','4444')
insert into member (mno,name,id,pw) values (member_seq.nextval,'�޽�','messi','5555')
insert into member (mno,name,id,pw) values (member_seq.nextval,'��μ�','kim','6666')
insert into member (mno,name,id,pw) values (member_seq.nextval,'�����','jws','7777')

select * from member


CREATE TABLE board (
  bno      NUMBER(5) PRIMARY KEY,
  btitle   VARCHAR2(30) NOT NULL,
  bcontent VARCHAR2(1000) NOT NULL,
  bwriter  VARCHAR2(10) NOT NULL,
  bdate    DATE DEFAULT SYSDATE NOT NULL,
  CONSTRAINT fk_writer FOREIGN KEY (bwriter) REFERENCES member(id)
)
drop table board

insert into BOARD (bno, btitle, bcontent, bwriter) values (board_seq.nextval, '�������~', '����µ� ��Ͻô³İ� ��� �ϼ̽��ϴ�.','hong')
insert into BOARD (bno, btitle, bcontent, bwriter) values (board_seq.nextval, '�ȳ��ϼ���~', '����µ� ��Ͻô³İ� ��� �ϼ̽��ϴ�.','an')
insert into BOARD (bno, btitle, bcontent, bwriter) values (board_seq.nextval, '�����մϴ�.~', '����µ� ��Ͻô³İ� ��� �ϼ̽��ϴ�.','son')
insert into BOARD (bno, btitle, bcontent, bwriter) values (board_seq.nextval, '�����ϼ̳���~', '����µ� ��Ͻô³İ� ��� �ϼ̽��ϴ�.','sejong')
insert into BOARD (bno, btitle, bcontent, bwriter) values (board_seq.nextval, 'ȭ�����ϼ���~', '����µ� ��Ͻô³İ� ��� �ϼ̽��ϴ�.','messi')
insert into BOARD (bno, btitle, bcontent, bwriter) values (board_seq.nextval, '�氩���ϴ�.~', '����µ� ��Ͻô³İ� ��� �ϼ̽��ϴ�.','jws' )
insert into BOARD (bno, btitle, bcontent, bwriter) values (board_seq.nextval, '�̾��մϴ�.~', '����µ� ��Ͻô³İ� ��� �ϼ̽��ϴ�.', 'kim')

create sequence board_seq increment by 1 start with 1 nocycle nocache
select * from BOARD

delete from board 

--���ɰ��� ���� ����
CREATE TABLE ghost (
  mno NUMBER(5) NOT NULL,
  name VARCHAR2(10) NOT NULL,
  id VARCHAR2(10) PRIMARY KEY,
  pw VARCHAR2(10) NOT NULL,
  regidate DATE DEFAULT SYSDATE NOT NULL
);
drop table ghost


