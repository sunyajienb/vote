drop database if exists `db_wxvote`;
create database `db_wxvote`;
use `db_wxvote`;

#΢���û���Ϣ
create table `user_info`(
	`user_id` int(11) NOT NULL auto_increment,
	`user_username` varchar(15) default NULL,
	`user_password` varchar(15) default NULL,
	PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=gb2312;

#����ѡ����Ϣ
create table `competitor_info`(
	`competitor_id` int(11) NOT NULL auto_increment,
	`competitor_name` varchar(15) default NULL,
	`competitor_age` int(5) default NULL,
	`competitor_sex` varchar(5) default "woman",
	`photo_path` varchar(100) default NULL,
	`ticket_num`  int(11) default 0,
	PRIMARY KEY (`competitor_id`),
	KEY `ticket_num` (`ticket_num`)
)ENGINE=innoDB AUTO_INCREMENT=1 DEFAULT CHARSET=gb2312;

#ͶƱ�û���Ϣ
create table `vote_info`(
	`vote_id` int(11) NOT NULL auto_increment,
	`user_name` varchar(15) default NULL,
	PRIMARY KEY (`vote_id`)
)ENGINE=innoDB AUTO_INCREMENT=1 DEFAULT CHARSET=gb2312;