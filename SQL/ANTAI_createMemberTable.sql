use EEITDB
go

drop table member
go

create table member(
IDnumber integer IDENTITY(1,1),    --�|���s��
account  varchar(20) primary key,  --�b��
password varchar(20),				--�K�X
nickname varchar(50) NOT NULL,  --�|���ʺ�
firstname varchar(50) NOT NULL,  --�|���m�W  �m
lastname varchar(50) NOT NULL,   --�|���m�W  �W
gender varchar(10) NOT NULL,	--�ʧO
email	 varchar(30),			--email
address  varchar(50),			--�a�}
birthday datetime NOT NULL,		--�ͤ�
fileNamePath varchar(50) NOT NULL,	--�j�Y�K���|(��Ƨ�)
phone	 varchar(15),				--�p���q��
registerdate datetime,				--���U���
lastlogin datetime,					--�̫�n�J���
subscription bigint NOT NULL,		--�q�\��
ban bit								--??
)