USE [EEITDB]
GO
ALTER TABLE [dbo].[WatchLaterVideos] DROP CONSTRAINT [FK_WatchLaterVideos_Video]
GO
ALTER TABLE [dbo].[WatchLaterVideos] DROP CONSTRAINT [FK_WatchLaterVideos_Member]
GO
ALTER TABLE [dbo].[WatchHistory] DROP CONSTRAINT [FK_WatchHistory_Video]
GO
ALTER TABLE [dbo].[WatchHistory] DROP CONSTRAINT [FK_WatchHistory_Member]
GO
ALTER TABLE [dbo].[Video] DROP CONSTRAINT [FK_Video_VideoType]
GO
ALTER TABLE [dbo].[UserReports] DROP CONSTRAINT [FK_UserReports_Member]
GO
ALTER TABLE [dbo].[SubscriptionUploader] DROP CONSTRAINT [FK_SubscriptionUploader_Member1]
GO
ALTER TABLE [dbo].[SubscriptionUploader] DROP CONSTRAINT [FK_SubscriptionUploader_Member]
GO
ALTER TABLE [dbo].[ServiceAns] DROP CONSTRAINT [FK_ServiceAns_MemberQues]
GO
ALTER TABLE [dbo].[ServiceAns] DROP CONSTRAINT [FK_ServiceAns_Manager]
GO
ALTER TABLE [dbo].[ReplyCommentVideoLikeUnlike] DROP CONSTRAINT [FK_ReplyCommentVideoLikeUnlike_ReplyCommentVideo]
GO
ALTER TABLE [dbo].[ReplyCommentVideoLikeUnlike] DROP CONSTRAINT [FK_ReplyCommentVideoLikeUnlike_Member]
GO
ALTER TABLE [dbo].[ReplyCommentVideo] DROP CONSTRAINT [FK_ReplyCommentVideo_Member]
GO
ALTER TABLE [dbo].[ReplyCommentVideo] DROP CONSTRAINT [FK_ReplyCommentVideo_CommentVideo]
GO
ALTER TABLE [dbo].[Product] DROP CONSTRAINT [FK_Product_Member]
GO
ALTER TABLE [dbo].[OrderList] DROP CONSTRAINT [FK_OrderList_Order]
GO
ALTER TABLE [dbo].[Order] DROP CONSTRAINT [FK_Order_Product]
GO
ALTER TABLE [dbo].[Notification] DROP CONSTRAINT [FK_Notification_Member]
GO
ALTER TABLE [dbo].[Message] DROP CONSTRAINT [FK_Message_Member1]
GO
ALTER TABLE [dbo].[Message] DROP CONSTRAINT [FK_Message_Member]
GO
ALTER TABLE [dbo].[MemberQues] DROP CONSTRAINT [FK_MemberQues_Member]
GO
ALTER TABLE [dbo].[LiveStream] DROP CONSTRAINT [FK_LiveStream_Video]
GO
ALTER TABLE [dbo].[LiveStream] DROP CONSTRAINT [FK_LiveStream_Member]
GO
ALTER TABLE [dbo].[LikeUnlikeVideos] DROP CONSTRAINT [FK_LikeUnlikeVideos_Video]
GO
ALTER TABLE [dbo].[LikeUnlikeVideos] DROP CONSTRAINT [FK_LikeUnlikeVideos_Member]
GO
ALTER TABLE [dbo].[CommentVideoLikeUnlike] DROP CONSTRAINT [FK_CommentVideoLikeUnlike_Member]
GO
ALTER TABLE [dbo].[CommentVideoLikeUnlike] DROP CONSTRAINT [FK_CommentVideoLikeUnlike_CommentVideo]
GO
ALTER TABLE [dbo].[CommentVideo] DROP CONSTRAINT [FK_CommentVideo_Video]
GO
ALTER TABLE [dbo].[CommentVideo] DROP CONSTRAINT [FK_CommentVideo_Member]
GO
ALTER TABLE [dbo].[Cart] DROP CONSTRAINT [FK_Cart_Product]
GO
ALTER TABLE [dbo].[Cart] DROP CONSTRAINT [FK_Cart_Order]
GO
/****** Object:  Table [dbo].[WatchLaterVideos]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[WatchLaterVideos]
GO
/****** Object:  Table [dbo].[WatchHistory]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[WatchHistory]
GO
/****** Object:  Table [dbo].[VideoType]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[VideoType]
GO
/****** Object:  Table [dbo].[Video]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[Video]
GO
/****** Object:  Table [dbo].[UserReports]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[UserReports]
GO
/****** Object:  Table [dbo].[SubscriptionUploader]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[SubscriptionUploader]
GO
/****** Object:  Table [dbo].[ServiceAns]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[ServiceAns]
GO
/****** Object:  Table [dbo].[ReplyCommentVideoLikeUnlike]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[ReplyCommentVideoLikeUnlike]
GO
/****** Object:  Table [dbo].[ReplyCommentVideo]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[ReplyCommentVideo]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[Product]
GO
/****** Object:  Table [dbo].[OrderList]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[OrderList]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[Order]
GO
/****** Object:  Table [dbo].[Notification]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[Notification]
GO
/****** Object:  Table [dbo].[Message]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[Message]
GO
/****** Object:  Table [dbo].[MemberQues]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[MemberQues]
GO
/****** Object:  Table [dbo].[Member]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[Member]
GO
/****** Object:  Table [dbo].[Manager]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[Manager]
GO
/****** Object:  Table [dbo].[LiveStream]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[LiveStream]
GO
/****** Object:  Table [dbo].[LikeUnlikeVideos]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[LikeUnlikeVideos]
GO
/****** Object:  Table [dbo].[CommentVideoLikeUnlike]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[CommentVideoLikeUnlike]
GO
/****** Object:  Table [dbo].[CommentVideo]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[CommentVideo]
GO
/****** Object:  Table [dbo].[Cart]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP TABLE [dbo].[Cart]
GO
USE [master]
GO
/****** Object:  Database [EEITDB]    Script Date: 2018/4/21 下午 05:03:41 ******/
DROP DATABASE [EEITDB]
GO
/****** Object:  Database [EEITDB]    Script Date: 2018/4/21 下午 05:03:41 ******/
CREATE DATABASE [EEITDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'EEITDB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\EEITDB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'EEITDB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\EEITDB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [EEITDB] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [EEITDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [EEITDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [EEITDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [EEITDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [EEITDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [EEITDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [EEITDB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [EEITDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [EEITDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [EEITDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [EEITDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [EEITDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [EEITDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [EEITDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [EEITDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [EEITDB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [EEITDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [EEITDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [EEITDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [EEITDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [EEITDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [EEITDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [EEITDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [EEITDB] SET RECOVERY FULL 
GO
ALTER DATABASE [EEITDB] SET  MULTI_USER 
GO
ALTER DATABASE [EEITDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [EEITDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [EEITDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [EEITDB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [EEITDB] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'EEITDB', N'ON'
GO
ALTER DATABASE [EEITDB] SET QUERY_STORE = OFF
GO
USE [EEITDB]
GO
ALTER DATABASE SCOPED CONFIGURATION SET IDENTITY_CACHE = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [EEITDB]
GO
/****** Object:  Table [dbo].[Cart]    Script Date: 2018/4/21 下午 05:03:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart](
	[cartSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[orderSeqNo] [int] NULL,
	[productSeqNo] [int] NULL,
	[orderDate] [varchar](20) NULL,
	[shoppingDate] [varchar](20) NULL,
 CONSTRAINT [PK__Cart__7F2BC980D311E8B6] PRIMARY KEY CLUSTERED 
(
	[cartSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CommentVideo]    Script Date: 2018/4/21 下午 05:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CommentVideo](
	[commentVideoSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[account] [varchar](20) NOT NULL,
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
/****** Object:  Table [dbo].[CommentVideoLikeUnlike]    Script Date: 2018/4/21 下午 05:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CommentVideoLikeUnlike](
	[commentLikeUnlikeSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[account] [varchar](20) NOT NULL,
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
/****** Object:  Table [dbo].[LikeUnlikeVideos]    Script Date: 2018/4/21 下午 05:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LikeUnlikeVideos](
	[likeUnlikeVideosSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[account] [varchar](20) NOT NULL,
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
/****** Object:  Table [dbo].[LiveStream]    Script Date: 2018/4/21 下午 05:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LiveStream](
	[liveStreamSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[startLiveTime] [datetime] NOT NULL,
	[endLiveTime] [datetime] NOT NULL,
	[account] [varchar](20) NOT NULL,
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
GO
/****** Object:  Table [dbo].[Manager]    Script Date: 2018/4/21 下午 05:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Manager](
	[managerSeqNo] [int] IDENTITY(20000,1) NOT NULL,
	[managerId] [varchar](500) NOT NULL,
	[managerPwd] [varchar](500) NULL,
	[managerName] [varchar](1000) NULL,
	[managerStatus] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[managerId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Member]    Script Date: 2018/4/21 下午 05:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Member](
	[memberSeqNo] [int] IDENTITY(10000,1) NOT NULL,
	[account] [varchar](20) NOT NULL,
	[password] [varchar](20) NOT NULL,
	[nickname] [varchar](50) NOT NULL,
	[firstname] [varchar](50) NOT NULL,
	[lastname] [varchar](50) NOT NULL,
	[gender] [varchar](10) NOT NULL,
	[email] [varchar](30) NULL,
	[address] [varchar](50) NULL,
	[birthday] [datetime] NOT NULL,
	[fileNamePath] [varchar](50) NOT NULL,
	[phone] [varchar](15) NULL,
	[registerdate] [datetime] NULL,
	[lastlogin] [datetime] NULL,
	[subscription] [bigint] NULL,
	[ban] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[account] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MemberQues]    Script Date: 2018/4/21 下午 05:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MemberQues](
	[memberQuesSeqNo] [int] IDENTITY(10000,1) NOT NULL,
	[account] [varchar](20) NULL,
	[memTopic] [varchar](1000) NULL,
	[memTitle] [varchar](1000) NULL,
	[memAsk] [varchar](3000) NULL,
	[memQuesTime] [datetime] NULL,
	[memFileName] [varchar](1000) NULL,
	[memQuespic] [varbinary](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[memberQuesSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Message]    Script Date: 2018/4/21 下午 05:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Message](
	[messageSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[messageArticle] [varchar](max) NOT NULL,
	[account] [varchar](20) NOT NULL,
	[receiverAccount] [varchar](20) NOT NULL,
	[messageDate] [datetime] NOT NULL,
	[messageStatus] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Message] PRIMARY KEY CLUSTERED 
(
	[messageSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Notification]    Script Date: 2018/4/21 下午 05:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Notification](
	[notificationSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[notificationArticle] [varchar](max) NOT NULL,
	[notificationType] [varchar](50) NOT NULL,
	[notificationDate] [datetime] NOT NULL,
	[notificationStatus] [varchar](50) NOT NULL,
	[account] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Notification_1] PRIMARY KEY CLUSTERED 
(
	[notificationSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 2018/4/21 下午 05:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[orderSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[productSeqNo] [int] NOT NULL,
	[account] [varchar](20) NULL,
	[orderDate] [datetime] NULL,
	[totalPrice] [decimal](20, 2) NULL,
	[payStatus] [varchar](50) NULL,
	[logisticStatus] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[orderSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderList]    Script Date: 2018/4/21 下午 05:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderList](
	[orderSeqNo] [int] NULL,
	[orderlistSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[proId] [varchar](max) NULL,
	[quantity] [int] NULL,
	[unitPrice] [decimal](20, 2) NULL,
	[discount] [decimal](10, 1) NULL,
PRIMARY KEY CLUSTERED 
(
	[orderlistSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 2018/4/21 下午 05:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[productSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[proName] [varchar](30) NOT NULL,
	[proPicPath] [varchar](max) NOT NULL,
	[price] [decimal](20, 2) NOT NULL,
	[probrand] [varchar](30) NULL,
	[proSpeicNo1] [varchar](max) NULL,
	[proSpeicNo2] [varchar](max) NULL,
	[proPicFile] [varchar](max) NOT NULL,
	[prostock] [decimal](10, 2) NULL,
	[prodiscount] [decimal](10, 2) NULL,
	[proCategory] [varchar](100) NULL,
	[account] [varchar](20) NULL,
	[proDate] [datetime] NULL,
	[prostatus] [varchar](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[productSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ReplyCommentVideo]    Script Date: 2018/4/21 下午 05:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ReplyCommentVideo](
	[replyCommentVideoSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[account] [varchar](20) NOT NULL,
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
/****** Object:  Table [dbo].[ReplyCommentVideoLikeUnlike]    Script Date: 2018/4/21 下午 05:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ReplyCommentVideoLikeUnlike](
	[replyCommentVideoLikeUnlikeSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[account] [varchar](20) NOT NULL,
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
/****** Object:  Table [dbo].[ServiceAns]    Script Date: 2018/4/21 下午 05:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ServiceAns](
	[serviceAnsSeqNo] [nchar](10) NOT NULL,
	[memberQuesSeqNo] [int] NULL,
	[managerId] [varchar](500) NULL,
	[manageResponse] [varchar](max) NULL,
	[responseDay] [datetime] NULL,
 CONSTRAINT [PK_ServiceAns] PRIMARY KEY CLUSTERED 
(
	[serviceAnsSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SubscriptionUploader]    Script Date: 2018/4/21 下午 05:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SubscriptionUploader](
	[subscriptionUploaderSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[account] [varchar](20) NOT NULL,
	[uploaderAccount] [varchar](20) NOT NULL,
	[subscriptionUploaderStatus] [varchar](50) NOT NULL,
	[subscriptionUploaderDate] [datetime] NOT NULL,
	[subscriptionUploaderScore] [int] NOT NULL,
 CONSTRAINT [PK_SubscriptionUploader_1] PRIMARY KEY CLUSTERED 
(
	[subscriptionUploaderSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserReports]    Script Date: 2018/4/21 下午 05:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserReports](
	[userReportsSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[account] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Table_1UserReports] PRIMARY KEY CLUSTERED 
(
	[userReportsSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Video]    Script Date: 2018/4/21 下午 05:03:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
/****** Object:  Table [dbo].[VideoType]    Script Date: 2018/4/21 下午 05:03:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
/****** Object:  Table [dbo].[WatchHistory]    Script Date: 2018/4/21 下午 05:03:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[WatchHistory](
	[watchHistorySeqNo] [int] IDENTITY(1,1) NOT NULL,
	[account] [varchar](20) NOT NULL,
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
/****** Object:  Table [dbo].[WatchLaterVideos]    Script Date: 2018/4/21 下午 05:03:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[WatchLaterVideos](
	[watchLaterVideosSeqNo] [int] IDENTITY(1,1) NOT NULL,
	[account] [varchar](20) NOT NULL,
	[videoSeqNo] [int] NOT NULL,
	[watchLaterVideoDate] [datetime] NOT NULL,
	[watchLaterVideosScore] [int] NOT NULL,
	[watchLaterVideosStatus] [varchar](50) NOT NULL,
 CONSTRAINT [PK_WatchLaterVideos] PRIMARY KEY CLUSTERED 
(
	[watchLaterVideosSeqNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD  CONSTRAINT [FK_Cart_Order] FOREIGN KEY([orderSeqNo])
REFERENCES [dbo].[Order] ([orderSeqNo])
GO
ALTER TABLE [dbo].[Cart] CHECK CONSTRAINT [FK_Cart_Order]
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD  CONSTRAINT [FK_Cart_Product] FOREIGN KEY([productSeqNo])
REFERENCES [dbo].[Product] ([productSeqNo])
GO
ALTER TABLE [dbo].[Cart] CHECK CONSTRAINT [FK_Cart_Product]
GO
ALTER TABLE [dbo].[CommentVideo]  WITH CHECK ADD  CONSTRAINT [FK_CommentVideo_Member] FOREIGN KEY([account])
REFERENCES [dbo].[Member] ([account])
GO
ALTER TABLE [dbo].[CommentVideo] CHECK CONSTRAINT [FK_CommentVideo_Member]
GO
ALTER TABLE [dbo].[CommentVideo]  WITH CHECK ADD  CONSTRAINT [FK_CommentVideo_Video] FOREIGN KEY([videoSeqNo])
REFERENCES [dbo].[Video] ([videoSeqNo])
GO
ALTER TABLE [dbo].[CommentVideo] CHECK CONSTRAINT [FK_CommentVideo_Video]
GO
ALTER TABLE [dbo].[CommentVideoLikeUnlike]  WITH CHECK ADD  CONSTRAINT [FK_CommentVideoLikeUnlike_CommentVideo] FOREIGN KEY([commentVideoSeqNo])
REFERENCES [dbo].[CommentVideo] ([commentVideoSeqNo])
GO
ALTER TABLE [dbo].[CommentVideoLikeUnlike] CHECK CONSTRAINT [FK_CommentVideoLikeUnlike_CommentVideo]
GO
ALTER TABLE [dbo].[CommentVideoLikeUnlike]  WITH CHECK ADD  CONSTRAINT [FK_CommentVideoLikeUnlike_Member] FOREIGN KEY([account])
REFERENCES [dbo].[Member] ([account])
GO
ALTER TABLE [dbo].[CommentVideoLikeUnlike] CHECK CONSTRAINT [FK_CommentVideoLikeUnlike_Member]
GO
ALTER TABLE [dbo].[LikeUnlikeVideos]  WITH CHECK ADD  CONSTRAINT [FK_LikeUnlikeVideos_Member] FOREIGN KEY([account])
REFERENCES [dbo].[Member] ([account])
GO
ALTER TABLE [dbo].[LikeUnlikeVideos] CHECK CONSTRAINT [FK_LikeUnlikeVideos_Member]
GO
ALTER TABLE [dbo].[LikeUnlikeVideos]  WITH CHECK ADD  CONSTRAINT [FK_LikeUnlikeVideos_Video] FOREIGN KEY([videoSeqNo])
REFERENCES [dbo].[Video] ([videoSeqNo])
GO
ALTER TABLE [dbo].[LikeUnlikeVideos] CHECK CONSTRAINT [FK_LikeUnlikeVideos_Video]
GO
ALTER TABLE [dbo].[LiveStream]  WITH CHECK ADD  CONSTRAINT [FK_LiveStream_Member] FOREIGN KEY([account])
REFERENCES [dbo].[Member] ([account])
GO
ALTER TABLE [dbo].[LiveStream] CHECK CONSTRAINT [FK_LiveStream_Member]
GO
ALTER TABLE [dbo].[LiveStream]  WITH CHECK ADD  CONSTRAINT [FK_LiveStream_Video] FOREIGN KEY([videoSeqNo])
REFERENCES [dbo].[Video] ([videoSeqNo])
GO
ALTER TABLE [dbo].[LiveStream] CHECK CONSTRAINT [FK_LiveStream_Video]
GO
ALTER TABLE [dbo].[MemberQues]  WITH CHECK ADD  CONSTRAINT [FK_MemberQues_Member] FOREIGN KEY([account])
REFERENCES [dbo].[Member] ([account])
GO
ALTER TABLE [dbo].[MemberQues] CHECK CONSTRAINT [FK_MemberQues_Member]
GO
ALTER TABLE [dbo].[Message]  WITH CHECK ADD  CONSTRAINT [FK_Message_Member] FOREIGN KEY([account])
REFERENCES [dbo].[Member] ([account])
GO
ALTER TABLE [dbo].[Message] CHECK CONSTRAINT [FK_Message_Member]
GO
ALTER TABLE [dbo].[Message]  WITH CHECK ADD  CONSTRAINT [FK_Message_Member1] FOREIGN KEY([receiverAccount])
REFERENCES [dbo].[Member] ([account])
GO
ALTER TABLE [dbo].[Message] CHECK CONSTRAINT [FK_Message_Member1]
GO
ALTER TABLE [dbo].[Notification]  WITH CHECK ADD  CONSTRAINT [FK_Notification_Member] FOREIGN KEY([account])
REFERENCES [dbo].[Member] ([account])
GO
ALTER TABLE [dbo].[Notification] CHECK CONSTRAINT [FK_Notification_Member]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Product] FOREIGN KEY([productSeqNo])
REFERENCES [dbo].[Product] ([productSeqNo])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Product]
GO
ALTER TABLE [dbo].[OrderList]  WITH CHECK ADD  CONSTRAINT [FK_OrderList_Order] FOREIGN KEY([orderSeqNo])
REFERENCES [dbo].[Order] ([orderSeqNo])
GO
ALTER TABLE [dbo].[OrderList] CHECK CONSTRAINT [FK_OrderList_Order]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Member] FOREIGN KEY([account])
REFERENCES [dbo].[Member] ([account])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Member]
GO
ALTER TABLE [dbo].[ReplyCommentVideo]  WITH CHECK ADD  CONSTRAINT [FK_ReplyCommentVideo_CommentVideo] FOREIGN KEY([commentVideoSeqNo])
REFERENCES [dbo].[CommentVideo] ([commentVideoSeqNo])
GO
ALTER TABLE [dbo].[ReplyCommentVideo] CHECK CONSTRAINT [FK_ReplyCommentVideo_CommentVideo]
GO
ALTER TABLE [dbo].[ReplyCommentVideo]  WITH CHECK ADD  CONSTRAINT [FK_ReplyCommentVideo_Member] FOREIGN KEY([account])
REFERENCES [dbo].[Member] ([account])
GO
ALTER TABLE [dbo].[ReplyCommentVideo] CHECK CONSTRAINT [FK_ReplyCommentVideo_Member]
GO
ALTER TABLE [dbo].[ReplyCommentVideoLikeUnlike]  WITH CHECK ADD  CONSTRAINT [FK_ReplyCommentVideoLikeUnlike_Member] FOREIGN KEY([account])
REFERENCES [dbo].[Member] ([account])
GO
ALTER TABLE [dbo].[ReplyCommentVideoLikeUnlike] CHECK CONSTRAINT [FK_ReplyCommentVideoLikeUnlike_Member]
GO
ALTER TABLE [dbo].[ReplyCommentVideoLikeUnlike]  WITH CHECK ADD  CONSTRAINT [FK_ReplyCommentVideoLikeUnlike_ReplyCommentVideo] FOREIGN KEY([replyCommentVideoSeqNo])
REFERENCES [dbo].[ReplyCommentVideo] ([replyCommentVideoSeqNo])
GO
ALTER TABLE [dbo].[ReplyCommentVideoLikeUnlike] CHECK CONSTRAINT [FK_ReplyCommentVideoLikeUnlike_ReplyCommentVideo]
GO
ALTER TABLE [dbo].[ServiceAns]  WITH CHECK ADD  CONSTRAINT [FK_ServiceAns_Manager] FOREIGN KEY([managerId])
REFERENCES [dbo].[Manager] ([managerId])
GO
ALTER TABLE [dbo].[ServiceAns] CHECK CONSTRAINT [FK_ServiceAns_Manager]
GO
ALTER TABLE [dbo].[ServiceAns]  WITH CHECK ADD  CONSTRAINT [FK_ServiceAns_MemberQues] FOREIGN KEY([memberQuesSeqNo])
REFERENCES [dbo].[MemberQues] ([memberQuesSeqNo])
GO
ALTER TABLE [dbo].[ServiceAns] CHECK CONSTRAINT [FK_ServiceAns_MemberQues]
GO
ALTER TABLE [dbo].[SubscriptionUploader]  WITH CHECK ADD  CONSTRAINT [FK_SubscriptionUploader_Member] FOREIGN KEY([account])
REFERENCES [dbo].[Member] ([account])
GO
ALTER TABLE [dbo].[SubscriptionUploader] CHECK CONSTRAINT [FK_SubscriptionUploader_Member]
GO
ALTER TABLE [dbo].[SubscriptionUploader]  WITH CHECK ADD  CONSTRAINT [FK_SubscriptionUploader_Member1] FOREIGN KEY([uploaderAccount])
REFERENCES [dbo].[Member] ([account])
GO
ALTER TABLE [dbo].[SubscriptionUploader] CHECK CONSTRAINT [FK_SubscriptionUploader_Member1]
GO
ALTER TABLE [dbo].[UserReports]  WITH CHECK ADD  CONSTRAINT [FK_UserReports_Member] FOREIGN KEY([account])
REFERENCES [dbo].[Member] ([account])
GO
ALTER TABLE [dbo].[UserReports] CHECK CONSTRAINT [FK_UserReports_Member]
GO
ALTER TABLE [dbo].[Video]  WITH CHECK ADD  CONSTRAINT [FK_Video_VideoType] FOREIGN KEY([videoType])
REFERENCES [dbo].[VideoType] ([videoType])
GO
ALTER TABLE [dbo].[Video] CHECK CONSTRAINT [FK_Video_VideoType]
GO
ALTER TABLE [dbo].[WatchHistory]  WITH CHECK ADD  CONSTRAINT [FK_WatchHistory_Member] FOREIGN KEY([account])
REFERENCES [dbo].[Member] ([account])
GO
ALTER TABLE [dbo].[WatchHistory] CHECK CONSTRAINT [FK_WatchHistory_Member]
GO
ALTER TABLE [dbo].[WatchHistory]  WITH CHECK ADD  CONSTRAINT [FK_WatchHistory_Video] FOREIGN KEY([videoSeqNo])
REFERENCES [dbo].[Video] ([videoSeqNo])
GO
ALTER TABLE [dbo].[WatchHistory] CHECK CONSTRAINT [FK_WatchHistory_Video]
GO
ALTER TABLE [dbo].[WatchLaterVideos]  WITH CHECK ADD  CONSTRAINT [FK_WatchLaterVideos_Member] FOREIGN KEY([account])
REFERENCES [dbo].[Member] ([account])
GO
ALTER TABLE [dbo].[WatchLaterVideos] CHECK CONSTRAINT [FK_WatchLaterVideos_Member]
GO
ALTER TABLE [dbo].[WatchLaterVideos]  WITH CHECK ADD  CONSTRAINT [FK_WatchLaterVideos_Video] FOREIGN KEY([videoSeqNo])
REFERENCES [dbo].[Video] ([videoSeqNo])
GO
ALTER TABLE [dbo].[WatchLaterVideos] CHECK CONSTRAINT [FK_WatchLaterVideos_Video]
GO
USE [master]
GO
ALTER DATABASE [EEITDB] SET  READ_WRITE 
GO
