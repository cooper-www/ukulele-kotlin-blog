#基础配置
CREATE TABLE config_base(
  blogName VARCHAR(50) NOT NULL UNIQUE comment '博客名称',
  openDate DATETIME NOT NULL comment '开放时间'
) ENGINE = INNODB COMMENT = '基本配置'

#banner
CREATE TABLE blog_banner(
  bannerId INT(11) unsigned not null KEY auto_increment,
  img VARCHAR(1024) NOT NULL comment '图片',
  linkUrl VARCHAR(1024) DEFAULT NULL comment '链接地址',
  showIn VARCHAR(50) not NULL DEFAULT 'BLOG_INDEX' comment '展示在哪里，BLOG_INDEX博客首页',
  startTime INT(11) unsigned NOT NULL DEFAULT 0 comment '起始时间 0不限',
  endTime INT(12) unsigned NOT NULL DEFAULT 0 comment '结束时间 0不限',
  addTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIME COMMENT '添加时间'
)ENGINE = INNODB COMMENT = 'banner配置'

#MODULE
CREATE TABLE blog_module(
  moduleId int(11) unsigned KEY auto_increment,
  uriRoute varchar(30) not NULL comment '模块路由',
  moduleName VARCHAR(50) NOT NULL comment '模块名',
  img VARCHAR(1024) NOT NULL comment '图片',
  sort INT(11) unsigned NOT NULL DEFAULT 0 comment '排序权重',
  pid INT(11) unsigned not NULL DEFAULT 0 comment '父模块',
  addTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE = INNODB COMMENT = '模块'

#帖子表
CREATE TABLE blog_article(
  articleId INT(11) unsigned KEY auto_increment,
  uid INT(11) unsigned NOT NULL comment '用户ID',
  moduleId INT(11) unsigned not null comment '模块ID',
  title VARCHAR(255) not NULL comment '标题',
  content VARCHAR(2048) NOT NULL comment '内容',
  tag VARCHAR(512) not NULL comment '标签，使用逗号分隔',
  addTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  status TINYINT(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态 1有效 0用户删除 99管理员删除'
)ENGINE = INNODB COMMENT = '博客帖子表'

#帖子回复评论表
CREATE TABLE blog_article_comment(
  commentId INT(11) UNSIGNED KEY auto_increment,
  uid INT(11) unsigned NOT NULL COMMENT '用户ID',
  toArticleId INT(11) unsigned not null comment '回复的文章ID',
  toCommentId INT(11) unsigned NOT NULL DEFAULT 0 comment '回复的评论ID,0直接对帖子的回复',
  content VARCHAR(512) comment '回复的文字内容',
  imgs VARCHAR(2048) COMMENT '回复的图片，多个用逗号隔开',
  addTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  status TINYINT(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态 1有效 0用户删除 99管理员删除'
)ENGINE = INNODB COMMENT = '帖子评论回复表'












