USE logistics
GO

CREATE TABLE [dbo].[member](
	[Invoice Date發票日期] [varchar](50) NULL,
	[Invoice Number發票號碼] [varchar](50) NULL,
	[Customer Name客戶名稱][varchar](50) NULL,
	[Goods Number貨品編號] [varchar](50) NULL,
	[Tracking Number追蹤編號] [varchar](50) NULL,
	[Unit單位] [varchar](50) NULL,
	[Price價格] [varchar](50) NULL,
	[Total總額] [varchar](50) NULL,
	[Account帳戶] [varchar](50) NULL,
	[Password密碼] [varchar](50) NULL,
	[Birth Date生日] [datetime] NULL,
	[Phone Number手機號碼] [varchar](50) NULL,
	[Email] [varchar](50) NULL,
	) ON [PRIMARY]
	GO
