--先執行 scripts 建立相關表格---------------------
 
USE EEITDB   --或其它 DB
GO

drop table member43;
-- : playlist



drop table member_question  ;
--q&a :  member_question

create table member_question
( 
  memberQuesNum  int  primary key identity(10000,1), --會員編號 外部鍵
  memId   varchar(200) , --帳號  主鍵
  memTopic  varchar(1000),  --項目
  memMail varchar(100),
  memName varchar(100),  --會員姓名
  memTel  int ,            --會員電話
  memAddr varchar(1000),
  memTitle varchar(1000),   --問題主旨
  memAsk   varchar(3000),       --會員問題  
  memQuesTime datetime,         --問題時間  
  memFileName varchar(1000),   --圖片名 
  memQuespic varbinary(max),    --圖片截圖       
);   
GO

drop table manager  ;
create table manager  --新增管理員帳號
(
  manageNum int identity(20000,1),
  manageId varchar(500) primary key ,
  managePwd varchar (500),
  manageName varchar (1000),
 
) 
go

drop table service_ans  ;


create table service_ans  --新增管理員回答問題的表格
(
	memberQuesNum int primary key ,  --客戶的問題編號
	manageNum int , --管理員的編號		
	memTitle varchar(1000),          --客戶問題主旨
    memAsk   varchar(3000),          --客戶問題的內容 
	memQuesTime datetime,            --問題時間  
	memQuespic varbinary(max),       --圖片截圖  
	manageResponse varchar(max),	 --管理員的回應
	responseDay datetime,	         --管理員回應的時間,
  )

