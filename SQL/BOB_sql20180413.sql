USE [iiiPro]
GO
/****** Object:  Table [dbo].[comments]    Script Date: 2018/4/13 下午 09:18:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[comments](
	[seqNo] [bigint] IDENTITY(1,1) NOT NULL,
	[userAccount] [varchar](50) NOT NULL,
	[videoSeqNo] [bigint] NOT NULL,
	[comments] [varchar](max) NOT NULL,
	[commentDate] [datetime] NOT NULL,
	[commentLike] [bigint] NOT NULL,
	[commentUnLike] [bigint] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[commentsLikeUnlike]    Script Date: 2018/4/13 下午 09:18:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[commentsLikeUnlike](
	[seqNo] [bigint] IDENTITY(1,1) NOT NULL,
	[userAccount] [varchar](max) NOT NULL,
	[commentsSeqNo] [bigint] NOT NULL,
	[status] [varchar](10) NOT NULL,
	[likeUnLikeCommentsDate] [datetime] NOT NULL,
	[score] [int] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[member]    Script Date: 2018/4/13 下午 09:19:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[member](
	[seqNo] [bigint] IDENTITY(1,1) NOT NULL,
	[account] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[nickname] [varchar](50) NOT NULL,
	[firstname] [varchar](50) NOT NULL,
	[lastname] [varchar](50) NOT NULL,
	[cellphone] [varchar](50) NOT NULL,
	[address] [varchar](200) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[birthday] [datetime] NOT NULL,
	[gender] [varchar](10) NOT NULL,
	[registerTime] [datetime] NOT NULL,
	[memberImage] [varbinary](max) NOT NULL,
	[fileName] [varchar](50) NOT NULL,
	[subscription] [bigint] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[subscriptionUploader]    Script Date: 2018/4/13 下午 09:19:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[subscriptionUploader](
	[seqNo] [bigint] IDENTITY(1,1) NOT NULL,
	[userAccount] [varchar](max) NOT NULL,
	[uploaderAccount] [varchar](max) NOT NULL,
	[status] [varchar](50) NOT NULL,
	[subscriptionUploaderDate] [datetime] NOT NULL,
	[score] [bigint] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[videoLikeUnlike]    Script Date: 2018/4/13 下午 09:19:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[videoLikeUnlike](
	[seqNo] [bigint] IDENTITY(1,1) NOT NULL,
	[userAccount] [varchar](max) NOT NULL,
	[videoSeqNo] [bigint] NOT NULL,
	[status] [varchar](10) NOT NULL,
	[likeUnLikeVideoDate] [datetime] NOT NULL,
	[score] [int] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[videos]    Script Date: 2018/4/13 下午 09:19:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[videos](
	[seqNo] [bigint] IDENTITY(1,1) NOT NULL,
	[videoTitle] [varchar](max) NOT NULL,
	[videoUploaderAccount] [varchar](max) NOT NULL,
	[videoFile] [varchar](max) NOT NULL,
	[videoDescription] [varchar](max) NOT NULL,
	[videoType] [varchar](max) NOT NULL,
	[videoUploaderType] [varchar](max) NOT NULL,
	[videoUploadDate] [datetime] NOT NULL,
	[videoLikes] [bigint] NOT NULL,
	[videoUnlikes] [bigint] NOT NULL,
	[videoViews] [bigint] NOT NULL,
	[videoStatus] [varchar](max) NOT NULL,
	[videoImage] [varbinary](max) NULL,
	[videoImageFileName] [varchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[videoTypes]    Script Date: 2018/4/13 下午 09:19:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[videoTypes](
	[seqNo] [bigint] IDENTITY(1,1) NOT NULL,
	[videoType] [varchar](50) NOT NULL,
	[score] [bigint] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[videoWatchLater]    Script Date: 2018/4/13 下午 09:19:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[videoWatchLater](
	[seqNo] [bigint] IDENTITY(1,1) NOT NULL,
	[userAccount] [varchar](max) NOT NULL,
	[videoSeqNo] [bigint] NOT NULL,
	[status] [varchar](50) NOT NULL,
	[watchLaterVideoDate] [datetime] NOT NULL,
	[score] [bigint] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[watchHistory]    Script Date: 2018/4/13 下午 09:19:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[watchHistory](
	[seqNo] [bigint] IDENTITY(1,1) NOT NULL,
	[userAccount] [varchar](max) NOT NULL,
	[videoSeqNo] [bigint] NOT NULL,
	[watchVideoDate] [datetime] NOT NULL,
	[score] [bigint] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
