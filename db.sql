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
    price decimal(6,2) default 0,
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
    foreign key (tour_id) references Tour(id),
    primary key(id)
);

create table Tour_Highlight
(
	id int auto_increment,
    tour_id int,
    highlight varchar(100) not null,
    foreign key (tour_id) references Tour(id),
    primary key(id)
);

create table Tour_Review
(
	id int auto_increment,
	user_id int,
	tour_id int,
    rate tinyint,
    `comment` varchar(255) not null,
    foreign key (user_id) references `User`(id),
    foreign key (tour_id) references Tour(id),
    primary key(id)
);

create table Ticket_Type
(
	`type` bit(1),
    discount tinyint,
    primary key(`type`)
);

create table Booking
(
	id int auto_increment,
    user_id int,
    tour_id int,
    ticketType bit(1),
    foreign key (user_id) references `User`(id),
    foreign key (tour_id) references Tour(id),
    foreign key (ticketType) references Ticket_Type(`type`),
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

insert into Tour(title, overview, img) 
values('Tour 1', 'Tour 1 Overview', 'https://res.cloudinary.com/petern/image/upload/v1647505688/travelmanagementproject_tourimg/img1_knmwxo.jpg'),
('Tour 2', 'Tour 2 Overview', 'https://res.cloudinary.com/petern/image/upload/v1647505689/travelmanagementproject_tourimg/img2_dvtdyh.jpg'),
('Tour 3', 'Tour 3 Overview', 'https://res.cloudinary.com/petern/image/upload/v1647505688/travelmanagementproject_tourimg/img3_bxk0we.jpg'),
('Tour 4', 'Tour 4 Overview', 'https://res.cloudinary.com/petern/image/upload/v1647505688/travelmanagementproject_tourimg/img4_qsmmvd.jpg'),
('Tour 5', 'Tour 5 Overview', 'https://res.cloudinary.com/petern/image/upload/v1647505689/travelmanagementproject_tourimg/img5_cwgw9n.png'),
('Tour 6', 'Tour 6 Overview', 'https://res.cloudinary.com/petern/image/upload/v1647505689/travelmanagementproject_tourimg/img5_cwgw9n.png'),
('Tour 7', 'Tour 7 Overview', 'https://res.cloudinary.com/petern/image/upload/v1647505689/travelmanagementproject_tourimg/img5_cwgw9n.png'),
('Tour 8', 'Tour 8 Overview', 'https://res.cloudinary.com/petern/image/upload/v1647505689/travelmanagementproject_tourimg/img5_cwgw9n.png'),
('Tour 9', 'Tour 9 Overview', 'https://res.cloudinary.com/petern/image/upload/v1647505689/travelmanagementproject_tourimg/img5_cwgw9n.png');

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