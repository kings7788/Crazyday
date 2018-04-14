use Projectdb
go

drop table member
go

create table member(
IDnumber integer IDENTITY(1,1),
account  varchar(20) primary key,
password varchar(20),
name	 varchar(20),
email	 varchar(30),
address  varchar(50),
photo varbinary(MAX),
phone	 varchar(15),
registerdate datetime,
lastlogin datetime,
ban bit
)