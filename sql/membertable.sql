create table member( -- 멤버테이블
mno number(5) not null, 
name varchar2(10)not null  ,
id varchar2(10)primary key ,
pw varchar2(10) not null,
regidate date default sysdate not null
)
create sequence member_seq increment by 1 start with 1 nocycle nocache

drop table member -- 멤버테이블 삭제용

----------더미네이터--------------
insert into member (mno,name,id,pw) values (member_seq.nextval,'홍길동','hong','1111')
insert into member (mno,name,id,pw) values (member_seq.nextval,'안중근','an','2222')
insert into member (mno,name,id,pw) values (member_seq.nextval,'손흥민','son','3333')
insert into member (mno,name,id,pw) values (member_seq.nextval,'세종','sejong','4444')
insert into member (mno,name,id,pw) values (member_seq.nextval,'메시','messi','5555')
insert into member (mno,name,id,pw) values (member_seq.nextval,'김민석','kim','6666')
insert into member (mno,name,id,pw) values (member_seq.nextval,'전우신','jws','7777')

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

insert into BOARD (bno, btitle, bcontent, bwriter) values (board_seq.nextval, '비오내요~', '비오는데 등교하시는냐고 고생 하셨습니다.','hong')
insert into BOARD (bno, btitle, bcontent, bwriter) values (board_seq.nextval, '안녕하세요~', '비오는데 등교하시는냐고 고생 하셨습니다.','an')
insert into BOARD (bno, btitle, bcontent, bwriter) values (board_seq.nextval, '감사합니다.~', '비오는데 등교하시는냐고 고생 하셨습니다.','son')
insert into BOARD (bno, btitle, bcontent, bwriter) values (board_seq.nextval, '수고하셨내요~', '비오는데 등교하시는냐고 고생 하셨습니다.','sejong')
insert into BOARD (bno, btitle, bcontent, bwriter) values (board_seq.nextval, '화이팅하세요~', '비오는데 등교하시는냐고 고생 하셨습니다.','messi')
insert into BOARD (bno, btitle, bcontent, bwriter) values (board_seq.nextval, '방갑습니다.~', '비오는데 등교하시는냐고 고생 하셨습니다.','jws' )
insert into BOARD (bno, btitle, bcontent, bwriter) values (board_seq.nextval, '미안합니다.~', '비오는데 등교하시는냐고 고생 하셨습니다.', 'kim')

create sequence board_seq increment by 1 start with 1 nocycle nocache
select * from BOARD

delete from board 

--유령계정 실행 안함
CREATE TABLE ghost (
  mno NUMBER(5) NOT NULL,
  name VARCHAR2(10) NOT NULL,
  id VARCHAR2(10) PRIMARY KEY,
  pw VARCHAR2(10) NOT NULL,
  regidate DATE DEFAULT SYSDATE NOT NULL
);
drop table ghost


