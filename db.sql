drop database if exists travelmanagement;
create database travelmanagement;
use travelmanagement;

create table `User`
(
	id int auto_increment,
    username varchar(50),
    `password` varchar(30),
    full_name varchar(100),
    `role` varchar(10),
    primary key(id)
);

create table Tour
(
	id int auto_increment,
    title varchar(50),
    price decimal(6,2),
    duration int,
    departure_point varchar(50),
    departure_time datetime,
    overview varchar(200),
    img varchar(200),
    primary key(id)
);

create table Tour_Itinerary
(
	id int auto_increment,
    tour_id int,
    `name` varchar(50),
    `description` varchar(200),
    foreign key (tour_id) references Tour(id),
    primary key(id)
);

create table Tour_Highlight
(
	id int auto_increment,
    tour_id int,
    highlight varchar(100),
    foreign key (tour_id) references Tour(id),
    primary key(id)
);

create table Tour_Review
(
	id int auto_increment,
	user_id int,
	tour_id int,
    rate tinyint,
    `comment` varchar(200),
    foreign key (user_id) references `User`(id),
    foreign key (tour_id) references Tour(id),
    primary key(id)
);

create table Booking
(
	id int auto_increment,
    user_id int,
    tour_id int,
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

create table Ticket
(
	id int auto_increment,
	booking_id int,
    ticket_type bit(1),
    foreign key (booking_id) references Booking(id),
    foreign key (ticket_type) references Ticket_Type(`type`),
    primary key(id)
);

insert into `User`(username, `password`, full_name, role)
values ('adminPhuc', 'phucnguyen', 'Nguyen Tan Phuc', 'Admin'),
('adminDat', 'datnguyen', 'Nguyen Tien Dat', 'Admin'),
('adminKhoe', 'khoengo', 'Ngo Minh Khoe', 'Admin');

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
