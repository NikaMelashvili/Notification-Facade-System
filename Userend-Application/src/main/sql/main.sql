create database notification_system;

use notification_system;

create table user (
    user_id bigint primary key auto_increment,
    first_name varchar(255),
    last_name varchar(255),
    phone_number int,
    email varchar(255),
    password varchar(255),
    role varchar(255)
);

create table preferences (
    preference_id bigint primary key auto_increment,
    notification_type varchar(255),
    opted_in bool,
    customer_id bigint,
    foreign key preferences(customer_id) references user (user_id)
);

create table user_preferences (
    preference_for_user_id bigint primary key auto_increment,
    user_id bigint,
    preference_id bigint,
    foreign key (user_id) references user(user_id),
    foreign key (preference_id) references preferences(preference_id)
);