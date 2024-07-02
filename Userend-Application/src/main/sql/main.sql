create database notification_system;

use notification_system;

create table customers (
    customer_id bigint primary key auto_increment,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255),
    phone_number int,
    address varchar(255)
);

create table user (
    user_id bigint primary key auto_increment,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255),
    password varchar(255),
    role varchar(255)
);

create table preferences (
    preference_id bigint primary key auto_increment,
    notification_type varchar(255),
    opted_in bool,
    customer_id bigint,
    foreign key preferences(customer_id) references customers (customer_id)
)