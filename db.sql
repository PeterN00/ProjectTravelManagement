drop database if exists travelmanagement;
create database travelmanagement;
use travelmanagement;

create table `User`
(
	id int auto_increment,
    username varchar(50) unique not null,
    `password` varchar(100) not null,
    full_name varchar(100) not null,
    `role` varchar(10),
    img varchar(255),
    primary key(id)
);

create table Tour
(
	id int auto_increment,
    title varchar(50) not null,
    price float default 0,
    `day` tinyint,
    night tinyint,
    departure_point varchar(50) default 'Unknown',
    departure_time datetime,
    overview varchar(255),
    img varchar(255),
    primary key(id)
);

create table Tour_Itinerary
(
	id int auto_increment,
    tour_id int,
    `name` varchar(50) not null,
    `description` varchar(255),
    foreign key (tour_id) references Tour(id) ON DELETE CASCADE,
    primary key(id)
);

create table Tour_Highlight
(
	id int auto_increment,
    tour_id int,
    highlight varchar(100) not null,
    foreign key (tour_id) references Tour(id) ON DELETE CASCADE,
    primary key(id)
);

create table Tour_Review
(
	id int auto_increment,
	user_id int,
	tour_id int,
    rate tinyint,
    `comment` varchar(255) not null,
    `time` datetime,
    foreign key (user_id) references `User`(id) ON DELETE CASCADE,
    foreign key (tour_id) references Tour(id) ON DELETE CASCADE,
    primary key(id)
);

create table Ticket_Type
(
	`type` bit(1),
    discount int,
    primary key(`type`)
);

create table Booking
(
	id int auto_increment,
    user_id int,
    tour_id int,
    ticket_type bit(1),
    book_date datetime,
    foreign key (user_id) references `User`(id) ON DELETE CASCADE,
    foreign key (tour_id) references Tour(id) ON DELETE CASCADE,
    foreign key (ticket_type) references Ticket_Type(`type`) ON DELETE CASCADE,
    primary key(id)
);

create table News
(
	id int auto_increment,
    title varchar(100) not null,
    `description` varchar(255) not null,
    `date` datetime default now(),
    primary key(id)
);

create table News_Comment
(
	id int auto_increment,
    user_id int,
    news_id int,
    `comment` varchar(100) not null,
    `time` datetime,
    foreign key (user_id) references `User`(id) ON DELETE CASCADE,
    foreign key (news_id) references News(id) ON DELETE CASCADE,
    primary key(id)
);

insert into Tour(title, price, overview, departure_time, img) 
values('Tour 1', 11, 'Tour 1 Overview', '2022-03-04 15:33', 'https://res.cloudinary.com/petern/image/upload/v1647505688/travelmanagementproject_tourimg/img1_knmwxo.jpg'),
('Tour 2', 12, 'Tour 2 Overview', '2022-01-03 03:33', 'https://res.cloudinary.com/petern/image/upload/v1647505689/travelmanagementproject_tourimg/img2_dvtdyh.jpg'),
('Tour 3', 13, 'Tour 3 Overview', '2022-02-04 07:33', 'https://res.cloudinary.com/petern/image/upload/v1647505688/travelmanagementproject_tourimg/img3_bxk0we.jpg'),
('Tour 4', 14, 'Tour 4 Overview', '2022-07-04 09:33', 'https://res.cloudinary.com/petern/image/upload/v1647505688/travelmanagementproject_tourimg/img4_qsmmvd.jpg'),
('Tour 5', 15, 'Tour 5 Overview', '2022-06-04 11:35', 'https://res.cloudinary.com/petern/image/upload/v1647505689/travelmanagementproject_tourimg/img5_cwgw9n.png'),
('Tour 6', 16, 'Tour 6 Overview', '2022-12-04 12:33', 'https://res.cloudinary.com/petern/image/upload/v1647505689/travelmanagementproject_tourimg/img5_cwgw9n.png'),
('Tour 7', 17, 'Tour 7 Overview', '2022-10-04 16:33', 'https://res.cloudinary.com/petern/image/upload/v1647505689/travelmanagementproject_tourimg/img5_cwgw9n.png'),
('Tour 8', 18, 'Tour 8 Overview', '2022-05-04 14:33', 'https://res.cloudinary.com/petern/image/upload/v1647505689/travelmanagementproject_tourimg/img5_cwgw9n.png'),
('Tour 9', 19, 'Tour 9 Overview', '2022-05-04 05:33', 'https://res.cloudinary.com/petern/image/upload/v1647505689/travelmanagementproject_tourimg/img5_cwgw9n.png');

insert into Tour_Highlight(tour_id, highlight)
values(1, 'Highlight 1-1'),
(1, 'Highlight 1-2'),
(2, 'Highlight 2-1'),
(2, 'Highlight 2-2'),
(3, 'Highlight 3-1'),
(3, 'Highlight 3-2'),
(4, 'Highlight 4-1'),
(4, 'Highlight 4-2'),
(5, 'Highlight 5-1'),
(5, 'Highlight 5-2'),
(6, 'Highlight 6-1'),
(6, 'Highlight 6-2'),
(7, 'Highlight 7-1'),
(7, 'Highlight 7-2'),
(8, 'Highlight 8-1'),
(8, 'Highlight 8-2'),
(9, 'Highlight 9-1'),
(9, 'Highlight 9-2');

insert into Tour_Itinerary(tour_id, name, description)
values(1, 'Day 1: Go to...', 'Day 1 description'),
(1, 'Day 2: Go to...', 'Day 2 description'),
(1, 'Day 3: Go to...', 'Day 3 description'),
(2, 'Day 1: Go to...', 'Day 1 description'),
(2, 'Day 2: Go to...', 'Day 2 description'),
(2, 'Day 3: Go to...', 'Day 3 description'),
(3, 'Day 1: Go to...', 'Day 1 description'),
(3, 'Day 2: Go to...', 'Day 2 description'),
(3, 'Day 3: Go to...', 'Day 3 description'),
(4, 'Day 1: Go to...', 'Day 1 description'),
(4, 'Day 2: Go to...', 'Day 2 description'),
(4, 'Day 3: Go to...', 'Day 3 description');

insert into Ticket_Type(type, discount)
values(0, 0), (1, 25);

insert into News(title, `description`, `date`)
values('News 1', 'This is news 1 description', now()),
('News 2', 'This is news 2 description', now()),
('News 3', 'This is news 3 description', now());

insert into `User`(username, `password`, full_name, `role`, img)
values("admin","$2a$10$Dt6CQu8D9bKZHr5g1gJLnO4MNlD2uAgEjO2dPJTYJqjzSA/gA.m7C","admin","Admin",
	"https://res.cloudinary.com/petern/image/upload/v1649237698/travelmanagementproject_userimg/icon1.png.png"),
	
    ("employee","$2a$10$JIZl2S6UhDpwzSybGU7khO.XXeQUx2L9upIikHbCjO4w1HcTNsR8G","employee","Employee",
	"https://res.cloudinary.com/petern/image/upload/v1649237720/travelmanagementproject_userimg/icon2.jpg.jpg"),
	
    ("customer","$2a$10$PCOrH7OxbYX.oxC0Mnj1qO0LVn0xLrGOiIjWTyB7nnrKYj2eWDBSe","customer","Customer",
	"https://res.cloudinary.com/petern/image/upload/v1649237734/travelmanagementproject_userimg/icon3.jpg.jpg");

insert into Booking(user_id, tour_id, ticket_type, book_date)
values(3, 1, 0, '2022-03-12 12:54'),
(3, 1, 0, '2022-01-12 12:54'),
(3, 1, 1, '2022-01-12 12:54'),
(3, 1, 1, '2022-07-12 12:54'),
(3, 3, 0, '2022-05-12 8:54'),
(3, 3, 0, '2022-06-12 8:54'),
(3, 2, 0, '2022-06-12 5:54'),
(3, 2, 0, '2022-06-12 5:54'),
(3, 4, 0, '2022-06-12 1:33'),
(3, 5, 0, '2022-04-12 7:54');

insert into Tour_Review(user_id, tour_id, rate, `comment`, `time`)
values(3, 1, 4, 'Review comment', '2022-04-05 6:35'),
(3, 1, 4, 'Review comment 2', '2022-04-05 8:44'),
(3, 1, 4, 'Review comment 3', '2022-04-05 9:22'),
(3, 2, 3, 'Review comment 1', '2022-04-05 8:34'),
(3, 2, 3, 'Review comment 2', '2022-04-05 15:30');