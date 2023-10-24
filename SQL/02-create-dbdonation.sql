
CREATE DATABASE if not exists web_donation_asm01 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
use web_donation_asm01;

create table role(
id int(11) not null auto_increment primary key,
role_name varchar(255) default null
);

create table user(
id int(11) not null auto_increment primary key,
full_name  varchar(255) default null,
address varchar(255) default null,
email  varchar(255) default null,
phone_number  varchar(255) default null,
note  varchar(255) default null,
user_name varchar(255) default null,
password  varchar(255) default null,
status int(11) default 1,
created  varchar(255) default null,
role_id int(11) default null,
foreign key (role_id) references role(id)
);

create table donation(
id int(11) not null auto_increment primary key,
code varchar(255) default null,
name  varchar(255) default null,
start_date  date default null,
end_date  date default null,
organization_name  varchar(255) default null,
phone_number  varchar(255) default null,
description  varchar(255) default null,
money int(11) default 0,
created  varchar(255) default null,
status int(11) default 1
);

create table user_donation(
id int(11) not null auto_increment primary key,
name  varchar(255) default null,
created  varchar(255) default null,
money int(11) default null,
status int(11) default null,
text varchar(255) default null,
donation_id int(11),
user_id int(11),
foreign key (donation_id) references donation(id),
foreign key (user_id) references user(id)
);