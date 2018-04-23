use EEITDB
go

drop table member
go

create table member(
IDnumber integer IDENTITY(1,1),    --會員編號
account  varchar(20) primary key,  --帳號
password varchar(20),				--密碼
nickname varchar(50) NOT NULL,  --會員暱稱
firstname varchar(50) NOT NULL,  --會員姓名  姓
lastname varchar(50) NOT NULL,   --會員姓名  名
gender varchar(10) NOT NULL,	--性別
email	 varchar(30),			--email
address  varchar(50),			--地址
birthday datetime NOT NULL,		--生日
fileNamePath varchar(50) NOT NULL,	--大頭貼路徑(資料夾)
phone	 varchar(15),				--聯絡電話
registerdate datetime,				--註冊日期
lastlogin datetime,					--最後登入日期
subscription bigint NOT NULL,		--訂閱數
ban bit								--??
)