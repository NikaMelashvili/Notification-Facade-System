create database notification_system;

use notification_system;

create table user (
    user_id bigint primary key auto_increment,
    address_id bigint,
    first_name varchar(255),
    last_name varchar(255),
    age int,
    email varchar(255),
    password varchar(255),
    role varchar(255),
    preference_id bigint
);

create table preferences (
    preference_id bigint primary key auto_increment,
    user_id bigint,
    opted_email bool,
    opted_sms bool,
    opted_promo_messages bool,
    foreign key preferences(user_id) references user (user_id)
);

create table addresses (
    address_id bigint primary key auto_increment,
    user_id bigint,
    email varchar(255),
    street varchar(255),
    phone_number int,
    postal_address int,
    foreign key (user_id) references user(user_id)
);

create table message_logger (
    log_id bigint primary key auto_increment,
    recipient varchar(255),
    subject varchar(255),
    body varchar(255),
    success bool,
    timestamp datetime(6)
);

alter table user
add constraint foreign key (address_id) references addresses(address_id);

alter table user
add constraint foreign key (preference_id) references preferences(preference_id);