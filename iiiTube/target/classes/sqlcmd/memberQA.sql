--������ scripts �إ߬������---------------------
 --
USE DBcustom   --�Ψ䥦 DB
GO

drop table member43;
-- : playlist

create table member43     --�Ȯɤ���
(
  member_id   varchar(200)    PRIMARY KEY ,  --�b��  �D��
  pword      varchar(20),      --�K�X
  member_name  varchar(100),  --�|���m�W
  member_email  varchar(100),
  member_num     int  identity(1,1)   --�|���s��  �~���� ����
                
);  
GO

drop table member_question  ;
--q&a :  member_question

create table member_question
( 
  memberQuesNum  int  identity(1,1), --�|���s�� �~����
  memId   varchar(200) primary key, --�b��  �D��
  memMail varchar(100),
  memName varchar(100),  --�|���m�W
  memTel  int ,            --�|���q��
  memAsk   varchar(3000),       --�|�����D  
  memQuesTime datetime,         --���D�ɶ�         
);   
GO

create table service_ans  --�s�W�^�����D�����
(
  response_number int identity(1,1),
  response varchar(max),		--�ȪA�^��
  response_day datetime,		--�ȪA�^���ɶ�
) 


go