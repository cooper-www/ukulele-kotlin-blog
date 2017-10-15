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
