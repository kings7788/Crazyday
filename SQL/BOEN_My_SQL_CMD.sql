--������ scripts �إ߬������---------------------
 
USE EEITDB   --�Ψ䥦 DB
GO

drop table member43;
-- : playlist



drop table member_question  ;
--q&a :  member_question

create table member_question
( 
  memberQuesNum  int  primary key identity(10000,1), --�|���s�� �~����
  memId   varchar(200) , --�b��  �D��
  memTopic  varchar(1000),  --����
  memMail varchar(100),
  memName varchar(100),  --�|���m�W
  memTel  int ,            --�|���q��
  memAddr varchar(1000),
  memTitle varchar(1000),   --���D�D��
  memAsk   varchar(3000),       --�|�����D  
  memQuesTime datetime,         --���D�ɶ�  
  memFileName varchar(1000),   --�Ϥ��W 
  memQuespic varbinary(max),    --�Ϥ��I��       
);   
GO

drop table manager  ;
create table manager  --�s�W�޲z���b��
(
  manageNum int identity(20000,1),
  manageId varchar(500) primary key ,
  managePwd varchar (500),
  manageName varchar (1000),
 
) 
go

drop table service_ans  ;


create table service_ans  --�s�W�޲z���^�����D�����
(
	memberQuesNum int primary key ,  --�Ȥ᪺���D�s��
	manageNum int , --�޲z�����s��		
	memTitle varchar(1000),          --�Ȥ���D�D��
    memAsk   varchar(3000),          --�Ȥ���D�����e 
	memQuesTime datetime,            --���D�ɶ�  
	memQuespic varbinary(max),       --�Ϥ��I��  
	manageResponse varchar(max),	 --�޲z�����^��
	responseDay datetime,	         --�޲z���^�����ɶ�,
  )

