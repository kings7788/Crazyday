use EEITDB
go



---  安泰的table
create table Member(
memberSeqNo integer IDENTITY (10000,1),    --會員編號
account  varchar(20)  primary key,  --帳號
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
ban bit,								--會員違規凍結 BOOLEAN

)



create table Manager  --新增管理員帳號
(
  managerSeqNo int identity(20000,1),
  managerId varchar(500) primary key ,
  managerPwd varchar (500),
  managerName varchar (1000),
  managerStatus varchar(10),
) 
go


--Jerry的table

CREATE TABLE [dbo].[LiveStream](
 [liveStreamSeqNo] [int] IDENTITY(1,1) NOT NULL,
 [startLiveTime] [datetime] NOT NULL,
 [endLiveTime] [datetime] NOT NULL,
 [userAccount] [varchar](500) NOT NULL,
 [videoSeqNo] [int] NOT NULL,
 [liveStreamTitle] [varchar](500) NOT NULL,
 [liveStreamDescription] [varchar](max) NOT NULL,
 [liveStreamTotalViews] [int] NOT NULL,
 [liveStreamStatus] [varchar](50) NOT NULL,
 CONSTRAINT [PK_LiveStream] PRIMARY KEY CLUSTERED 
(
 [liveStreamSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]



-- Vic 的table
CREATE TABLE [dbo].[Product](
	productSeqNo integer IDENTITY(1,1)  primary key NOT NULL,  --產品編號
	proName varchar(30)  NOT NULL,                      --產品名稱
	proPicPath varchar(max) NOT NULL,				--產品大頭照路徑
	price decimal(20,2) NOT NULL,                     --產品價格
	probrand varchar(30) NULL,                         --品牌
	proSpeicNo1 varchar(max),						--產品敘述	1
	proSpeicNo2 varchar(max),						--產品敘述	2
	proPicFile varchar(max) NOT NULL,				--產品圖片路徑(資料夾)
	prostock decimal(10,2) NULL,						--庫存										
	prodiscount decimal(10,2) NULL,						--折扣
	proCategory varchar(100),                           --商品類別
	proaccount  varchar(20),							    --賣家帳號
	proDate datetime,                                       --上架時間
	prostatus varchar(1),                                --商品狀態
)
GO


CREATE TABLE [dbo].[Cart](
	cartSeqNo int iDENTITY(1,1) primary key, --購物車編號
	orderNo int ,
	pro_id varchar(30) NULL,
	[orderDate] [varchar](20) NULL,
	[shoppingDate] [varchar](20) NULL
) ON [PRIMARY]
GO


CREATE TABLE [dbo].[Order](
	orderSeqNo integer iDENTITY(1,1) primary key,--訂單編號
	productSeqNo integer NOT NULL,  --產品編號
	account  varchar(20) ,			 --帳號  外部鍵
	orderDate [datetime] NULL ,	     --訂單日期
	totalPrice decimal(20,2) NULL,	 --總額
	payStatus varchar(50),           --付款狀態
	logisticStatus varchar(50)       --配送狀態
	
	)
	GO


create table OrderList (
	orderSeqNo integer, 							 --訂單編號	外部鍵	
	orderlistSeqNo integer iDENTITY(1,1) primary key,--訂單項目編號;
	proId varchar(max),								 --產品名稱				

	quantity integer,                                --數量
	unitPrice decimal(20,2),                         --單價
	discount decimal(10,1),                          --折扣
	)

	
	
	--Bob的table 

	--影片的回應
	CREATE TABLE [dbo].[CommentVideo](
	[commentVideoSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[userAccount] [varchar](500) NOT NULL,
	[videoSeqNo] [int] NOT NULL,
	[commentArticle] [varchar](max) NOT NULL,
	[commentDate] [datetime] NOT NULL,
	[commentLike] [int] NOT NULL,
	[commentUnLike] [int] NOT NULL,
	[commentVideoStatus] [varchar](50) NOT NULL,
 CONSTRAINT [PK_CommentsVideo] PRIMARY KEY CLUSTERED 
(
	[commentVideoSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CommentVideoLikeUnlike]    Script Date: 2018/4/21 下午 03:44:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--回應的讚 或是 不喜歡
CREATE TABLE [dbo].[CommentVideoLikeUnlike](
	[commentLikeUnlikeSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[userAccount] [varchar](500) NOT NULL,
	[commentVideoSeqNo] [int] NOT NULL,
	[commentLikeUnlikeStatus] [varchar](50) NOT NULL,
	[commentLikeUnLikeDate] [datetime] NOT NULL,
	[commentLikeUnLikeScore] [int] NOT NULL,
 CONSTRAINT [PK_CommentsVideoLikeUnlike] PRIMARY KEY CLUSTERED 
(
	[commentLikeUnlikeSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LikeUnlikeVideos]    Script Date: 2018/4/21 下午 03:44:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--影片的喜歡不喜歡
CREATE TABLE [dbo].[LikeUnlikeVideos](
	[likeUnlikeVideosSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[userAccount] [varchar](500) NOT NULL,
	[videoSeqNo] [int] NOT NULL,
	[LikeUnlikeVideosStatus] [varchar](50) NOT NULL,
	[likeUnLikeVideosDate] [datetime] NOT NULL,
	[likeUnlikeVideosScore] [int] NOT NULL,
 CONSTRAINT [PK_LikeUnlikeVideos] PRIMARY KEY CLUSTERED 
(
	[likeUnlikeVideosSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LiveStream]    Script Date: 2018/4/21 下午 03:44:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--網站聊天室
CREATE TABLE [dbo].[Message](
	[messageSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[messageArticle] [varchar](max) NOT NULL,
	[userAccount] [varchar](500) NOT NULL,
	[receiverAccount] [varchar](500) NOT NULL,
	[messageDate] [datetime] NOT NULL,
	[messageStatus] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Message] PRIMARY KEY CLUSTERED 
(
	[messageSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Notification]    Script Date: 2018/4/21 下午 03:44:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--訊息彈出通知
CREATE TABLE [dbo].[Notification](
	[notificationSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[notificationArticle] [varchar](max) NOT NULL,
	[notificationType] [varchar](50) NOT NULL,
	[notificationDate] [datetime] NOT NULL,
	[notificationStatus] [varchar](50) NOT NULL,
	[userAccount] [varchar](500) NOT NULL,
 CONSTRAINT [PK_Notification_1] PRIMARY KEY CLUSTERED 
(
	[notificationSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ReplyCommentVideo]    Script Date: 2018/4/21 下午 03:44:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--影片回覆留言
CREATE TABLE [dbo].[ReplyCommentVideo](
	[replyCommentVideoSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[userAccount] [varchar](500) NOT NULL,
	[commentVideoSeqNo] [int] NOT NULL,
	[replyCommentArticle] [varchar](max) NOT NULL,
	[replyCommentDate] [datetime] NOT NULL,
	[replyCommentLike] [int] NOT NULL,
	[replyCommentUnLike] [int] NOT NULL,
	[replyCommentVideoStatus] [varchar](50) NOT NULL,
 CONSTRAINT [PK_ReplyCommentVideo] PRIMARY KEY CLUSTERED 
(
	[replyCommentVideoSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ReplyCommentVideoLikeUnlike]    Script Date: 2018/4/21 下午 03:44:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--影片下方回覆留言的讚或不贊
CREATE TABLE [dbo].[ReplyCommentVideoLikeUnlike](
	[replyCommentVideoLikeUnlikeSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[userAccount] [varchar](500) NOT NULL,
	[replyCommentVideoVideoSeqNo] [int] NOT NULL,
	[replyCommentVideoLikeUnlikeStatus] [varchar](50) NOT NULL,
	[replyCommentVideoLikeUnlikeDate] [datetime] NOT NULL,
	[replyCommentVideoLikeUnLikeScore] [int] NOT NULL,
	[replyCommentVideoSeqNo] [int] NOT NULL,
 CONSTRAINT [PK_ReplyCommentLikeUnlike] PRIMARY KEY CLUSTERED 
(
	[replyCommentVideoLikeUnlikeSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SubscriptionUploader]    Script Date: 2018/4/21 下午 03:44:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--是否訂閱影片上傳者
CREATE TABLE [dbo].[SubscriptionUploader](
	[subscriptionUploaderSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[userAccount] [varchar](500) NOT NULL,
	[uploaderAccount] [varchar](500) NOT NULL,
	[subscriptionUploaderStatus] [varchar](50) NOT NULL,
	[subscriptionUploaderDate] [datetime] NOT NULL,
	[subscriptionUploaderScore] [int] NOT NULL,
 CONSTRAINT [PK_SubscriptionUploader_1] PRIMARY KEY CLUSTERED 
(
	[subscriptionUploaderSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserReports]    Script Date: 2018/4/21 下午 03:44:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--週報表(圖形分析)
CREATE TABLE [dbo].[UserReports](
	[userReportsSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[userAccount] [varchar](500) NOT NULL,
 CONSTRAINT [PK_Table_1UserReports] PRIMARY KEY CLUSTERED 
(
	[userReportsSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Video]    Script Date: 2018/4/21 下午 03:44:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--影片的新增
CREATE TABLE [dbo].[Video](
	[videoSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[videoTitle] [varchar](500) NOT NULL,
	[userAccount] [varchar](500) NOT NULL,
	[videoDescription] [varchar](max) NOT NULL,
	[videoType] [varchar](50) NOT NULL,
	[videoUplodaerListType] [varchar](500) NOT NULL,
	[videoUploadDate] [datetime] NOT NULL,
	[videoLikes] [int] NOT NULL,
	[videoUnlikes] [int] NOT NULL,
	[videoViews] [int] NOT NULL,
	[videoStatus] [varchar](50) NOT NULL,
	[videoFilePath] [varchar](500) NOT NULL,
	[VideoFileName] [varchar](500) NOT NULL,
	[videoImageFilePath] [varchar](500) NOT NULL,
	[videoImageFileName] [varchar](500) NOT NULL,
 CONSTRAINT [PK_Video] PRIMARY KEY CLUSTERED 
(
	[videoSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VideoType]    Script Date: 2018/4/21 下午 03:44:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--影片的種類
CREATE TABLE [dbo].[VideoType](
	[sortedVideosSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[videoType] [varchar](50) NOT NULL,
	[sortedVideosScore] [int] NOT NULL,
	[sortedVideosStatus] [varchar](50) NOT NULL,
 CONSTRAINT [PK_SortedVideos] PRIMARY KEY CLUSTERED 
(
	[videoType] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[WatchHistory]    Script Date: 2018/4/21 下午 03:44:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--觀看紀錄
CREATE TABLE [dbo].[WatchHistory](
	[watchHistorySeqNo] [int] IDENTITY(1,1) NOT NULL,
	[userAccount] [varchar](500) NOT NULL,
	[videoSeqNo] [int] NOT NULL,
	[watchVideoDate] [datetime] NOT NULL,
	[watchHistoryScore] [int] NOT NULL,
	[watchHistoryStatus] [varchar](50) NOT NULL,
 CONSTRAINT [PK_WatchHistory] PRIMARY KEY CLUSTERED 
(
	[watchHistorySeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[WatchLaterVideos]    Script Date: 2018/4/21 下午 03:44:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--稍後觀看的影片
CREATE TABLE [dbo].[WatchLaterVideos](
	[watchLaterVideosSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[userAccount] [varchar](500) NOT NULL,
	[videoSeqNo] [int] NOT NULL,
	[watchLaterVideoDate] [datetime] NOT NULL,
	[watchLaterVideosScore] [int] NOT NULL,
	[watchLaterVideosStatus] [varchar](50) NOT NULL,
 CONSTRAINT [PK_WatchLaterVideos] PRIMARY KEY CLUSTERED 
(
	[watchLaterVideosSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]



	--Boen的Table

	create table MemberQues
( 
  memberQuesSeqNo  int  primary key identity(10000,1), --會員編號 外部鍵
  account  varchar(20) ,  --帳號
  memTopic  varchar(1000),  --項目
  memTitle varchar(1000),   --問題主旨
  memAsk   varchar(3000),       --會員問題  
  memQuesTime datetime,         --問題時間  
  memFileName varchar(1000),   --圖片名 
  memQuespic varbinary(max),    --圖片截圖       
);   
GO




create table ServiceAns(  --新增管理員回答問題的表格

	memberQuesSeqNo  int ,			 --客戶的問題編號
	managerSeqNo int ,				 --管理員的編號		
	
	
	manageResponse varchar(max),	 --管理員的回應
	responseDay datetime,	         --管理員回應的時間,
  )



