drop table weather;
drop table inhabitant_type;
drop table region;

create database Weather;
use Weather;
create table inhabitant_type
(
	id_type int identity(1,1) primary key ,
    name nvarchar(50),
    language nvarchar(50)
);

create table weather
(
	weather_id int identity(1,1) primary key,
    date date,
    temperature int,
	precipitation int
);

create table region
(
	id_region int identity(1,1) primary key,
    name nvarchar(100),
    area decimal,
    weather_id int references weather(weather_id),
    id_type int references  inhabitant_type(id_type)
);
