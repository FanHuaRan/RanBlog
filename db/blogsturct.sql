/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/6/7 11:05:39                            */
/*==============================================================*/


drop table if exists Authority;

drop table if exists Blog;

drop table if exists BlogComment;

drop table if exists BlogRole;

drop table if exists BlogType;

drop table if exists BlogUser;

drop table if exists LanguageType;

drop table if exists Script;

/*==============================================================*/
/* Table: Authority                                             */
/*==============================================================*/
create table Authority
(
   AuthorityId          bigint not null,
   BlogUserId           int not null,
   BlogRoleId           smallint not null,
   primary key (AuthorityId)
);

/*==============================================================*/
/* Table: Blog                                                  */
/*==============================================================*/
create table Blog
(
   BlogId               int not null auto_increment,
   Title                varchar(40) not null,
   Digest               varchar(100) not null,
   Content              varchar(5000) not null,
   PublishTime          datetime not null,
   PageView             bigint not null,
   CommentCount         bigint not null default 0,
   keywords             varchar(50) not null,
   primary key (BlogId)
);

alter table Blog comment '评论数：用数据库触发器实现
关键字格式：key1,key2,';

/*==============================================================*/
/* Table: BlogComment                                           */
/*==============================================================*/
create table BlogComment
(
   BlogCommentId        bigint not null auto_increment,
   BlogUserId           int not null,
   BlogId               int not null,
   BlogComment          varchar(200) not null,
   CommentTime          datetime not null,
   primary key (BlogCommentId)
);

/*==============================================================*/
/* Table: BlogRole                                              */
/*==============================================================*/
create table BlogRole
(
   BlogRoleId           smallint not null auto_increment,
   BlogRoleName         varchar(15) not null,
   primary key (BlogRoleId)
);

/*==============================================================*/
/* Table: BlogType                                              */
/*==============================================================*/
create table BlogType
(
   BlogTypeId           smallint not null auto_increment,
   BlogTypeName         varchar(30) not null,
   BlogCount            bigint not null default 0,
   primary key (BlogTypeId)
);

alter table BlogType comment '博客数:用触发器实现';

/*==============================================================*/
/* Table: BlogUser                                              */
/*==============================================================*/
create table BlogUser
(
   BlogUserId           int not null auto_increment,
   UserName             varchar(30) not null,
   Password             varchar(40) not null,
   RegisteTime          datetime not null,
   Email                varchar(50) not null,
   primary key (BlogUserId)
);

/*==============================================================*/
/* Table: LanguageType                                          */
/*==============================================================*/
create table LanguageType
(
   LanguageTypeId       bigint not null auto_increment,
   LanguageName         varchar(15) not null,
   primary key (LanguageTypeId)
);

/*==============================================================*/
/* Table: Script                                                */
/*==============================================================*/
create table Script
(
   ScriptId             bigint not null auto_increment,
   LanguageTypeId       bigint not null,
   ScriptName           varchar(30) not null,
   ScriptContent        varchar(10000) not null,
   EditTime             datetime not null,
   primary key (ScriptId)
);

