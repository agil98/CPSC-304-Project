
drop table attraction1;
drop table eventattractions;
drop table willAttend;
drop table verifiedTicket;
drop table Books;
drop table Sponsor;
drop table SponsorsSportingEvent;
drop table SponsorsConcertEvent;
drop table Sport;
drop table Facilitates;

drop table concert;
drop view nextmonthconcert;
drop table Attendee;
drop table attraction;
drop table Employee;
drop view nextmonthevent;

create table Concert(
eventID  integer,
eventName    char(50),
performanceDate date,
primary key (eventID));

insert into concert values (789456, 'Drake', '2018-09-12');
insert into concert values (526489, 'The Beatles', '2016-04-14');
insert into concert values (513697, 'Queen', '2013-09-19');
insert into concert values (987523, 'Harry Styles', '2018-07-16');
insert into concert values (923014, 'Ariana Grande', '2018-12-23');
insert into concert values (748156, 'Imagine Dragons', '2018-09-16');
insert into concert values (520169, 'Swae Lee', '2019-11-16');
insert into concert values (014589, 'Lil Yachty', '2020-11-28');
insert into concert values (896339, 'Fitz', '2017-12-02');
insert into concert values (745123, 'Victoria', '2018-12-08');
insert into concert values (503698, 'Nicki Minaj', '2018-12-06');
insert into concert values (215896, 'Passion Pit', '2018-12-07');
commit;

CREATE TABLE Attraction1(
attractionID         INTEGER,
 	groupPhone        INTEGER   NOT NULL,
PRIMARY KEY (attractionID));

create view nextmonthconcert as select eventName, eventID from
concert where performancedate>'2018-11-11' and performancedate<'2018-12-18';

CREATE TABLE Attendee(
name               CHAR(50),
email               CHAR(50),
totalPoints       INTEGER,
creditCard#     INTEGER   NOT NULL,
ticketAmount   INTEGER,
age		  INTEGER,
gender            CHAR(20),
PRIMARY KEY (name, email));

insert into Attendee values ('Victoria', 'spam@gmail.com', 0, 555555555, 0, 20, 'female');
insert into Attendee values ('Joe', 'spam1@gmail.com', 0, 987654321, 0, 19, 'male');
insert into Attendee values ('Clare', 'spam2@gmail.com', 0, 123456789, 0, 18, 'female');
insert into Attendee values ('James', 'spam3@gmail.com', 0, 987654321, 0, 30, 'male');
insert into Attendee values ('Julia', 'spam4@gmail.com', 0, 123456789, 0, 48, 'female');

CREATE TABLE attraction(
  attractionID integer,  
  attractionName char(50),
  genre char(50),
  primary key (attractionID)
);

insert into attraction values (456,'Drake', 'Pop');
insert into attraction values (598,'The Beatles', 'Retro');
insert into attraction values (487,'Queen', 'Retro');
insert into attraction values (963,'Harry Styles','Pop');
insert into attraction values (859,'Ariana Grande', 'Pop');
insert into attraction values (326,'Imagine Dragons', 'Indie');
insert into attraction values (687,'Swae Lee', 'Rap');
insert into attraction values (156,'Lil Yachty', 'Rap');
insert into attraction values (857,'Fitz', 'Indie');
insert into attraction values (526,'Nicki Minaj', 'Pop');
insert into attraction values (008,'Victoria', 'Pop');
insert into attraction values (015,'Passion Pit', 'Indie');

CREATE TABLE eventattractions (
  eventID integer, 
  attractionID integer,
  primary key (eventID),
  foreign key (eventID) references Concert,
  foreign key (attractionID) references Attraction
);

insert into eventattractions values (789456, 456);
insert into eventattractions values (526489, 598);
insert into eventattractions values (513697, 487);
insert into eventattractions values (987523, 963);
insert into eventattractions values (923014, 859);
insert into eventattractions values (748156, 326);
insert into eventattractions values (520169, 687);
insert into eventattractions values (014589, 156);
insert into eventattractions values (896339, 857);
insert into eventattractions values (745123, 526);
insert into eventattractions values (503698, 008);
insert into eventattractions values (215896, 015);



CREATE TABLE verifiedTicket(
section#               INTEGER,
seat#                    INTEGER,
price                     INTEGER,
datePurchased    DATE,
wasVerified          CHAR(10),
pointValue            INTEGER,
purchaserEmail    CHAR(40),
purchaserName   CHAR(40),
attractionID    CHAR(40),
PRIMARY KEY (section#, seat#));

insert into verifiedTicket values(88, 78, 100, '18-11-11', 0 , 100, 'spam@gmail.com', 'Victoria', 456);
insert into verifiedTicket values(77, 78, 100, '19-12-12', 0 , 100, 'spam1@gmail.com', 'Joe', 598);
insert into verifiedTicket values(29, 20, 100, '18-10-13', 0 , 100, 'spam2@gmail.com', 'Clare', 487);
insert into verifiedTicket values(89, 32, 100, '17-09-14', 0 , 100, 'spam3@gmail.com', 'James', 456);

CREATE TABLE willAttend(
name      CHAR(30),
email      CHAR(50),
section#   INTEGER,
seat#      INTEGER,
eventID    INTEGER,
PRIMARY KEY (name, email, section#, seat#, eventID),
FOREIGN KEY (section#, seat#) REFERENCES verifiedticket,
FOREIGN KEY (eventID) REFERENCES Concert);

insert into willattend values ('Victoria', 'spam@gmail.com', 88, 78, 789456);
insert into willattend values ('Joe', 'spam1@gmail.com', 77, 78, 526489);


create table Books(
AttractionID  integer,
EventID integer,
Price integer,
PRIMARY KEY (attractionID, eventID),
FOREIGN KEY (attractionID) REFERENCES Attraction,
FOREIGN KEY (eventID) REFERENCES Concert);

insert into books values (456, 789456, 3000);
insert into books values (598, 526489, 4000);
insert into books values (487, 513697, 3500);

create table Sport(
eventID integer,
eventName char(50),
homeTeamID integer,
awayTeamID integer,
matchDate date,
primary key (eventID));

create table Sponsor(
sponsorID      integer,
primary key (sponsorID) ON DELETE CASCADE);

insert into sponsor values (302819);
insert into sponsor values (654716);
insert into sponsor values (512354);
insert into sponsor values (897456);
insert into sponsor values (456123);
insert into sponsor values (145878);
insert into sponsor values (215896);

insert into sport values (946284, 'Canucks vs. Canadiens', 1849, 0928, '2018-12-17');
insert into sport values (973920, 'Canucks vs. Predators', 1849, 0378, '2018-12-20');
insert into sport values (984939, 'Canucks vs. Bruins', 1849, 0748, '2019-01-03');
insert into sport values (986251, 'Canucks vs. Canadiens', 1849, 0928, '2018-11-30');
insert into sport values (940275, 'Canucks vs. Stars', 1849, 0835, '2018-12-01');
insert into sport values (936211, ‘Stars vs. Canadiens’, 0835, 0928, ‘2019-01-22’);

create table SponsorsSportingEvent(
sponsorID  integer,
eventID    integer,
primary key (sponsorID, eventID),
FOREIGN KEY (sponsorID) REFERENCES Sponsor,
FOREIGN KEY (eventID) REFERENCES Sport);

insert into sponsorssportingevent values (654716, 946284);
insert into sponsorssportingevent values (512354, 973920);
insert into sponsorssportingevent values (897456, 984939);

insert into sponsorssportingevent values (302819, 946284);
insert into sponsorssportingevent values (302819, 973920);
insert into sponsorssportingevent values (302819, 984939);
insert into sponsorssportingevent values (302819, 986251);
insert into sponsorssportingevent values (302819, 940275);


create table SponsorsConcertEvent(
sponsorID  integer,
eventID    integer,
primary key (sponsorID, eventID),
FOREIGN KEY (sponsorID) REFERENCES Sponsor,
FOREIGN KEY (eventID) REFERENCES Concert);

insert into sponsorsconcertevent values (456123, 789456);
insert into sponsorsconcertevent values (145878, 526489);
insert into sponsorsconcertevent values (215896, 520169);


CREATE TABLE Employee(
employeeID       INTEGER,
name                 CHAR(60),
hourlyWage       INTEGER,
startDate           DATE,
PRIMARY KEY (employeeID));


insert into Employee values
(1, 'Ryan Taylor', 20, '2015-07-11');
insert into Employee values
(2, 'Laura Coleman', 20, '2014-01-24');
insert into Employee values
(3, 'Miranda Garcia', 35, '2008-12-21');
insert into Employee values
(4, 'Chris Hall', 15, '2018-01-09');
insert into Employee values
(5, 'Evangeline Raymonds', 20, '2013-04-01');

CREATE TABLE Facilitates(
employeeID      INTEGER,
eventID         INTEGER,
role		    CHAR(20),
PRIMARY KEY (employeeID, eventID),
FOREIGN KEY (employeeID) REFERENCES Employee);

insert into Facilitates values
(1, 520169, 'ticket sale');
insert into Facilitates values
(1, 896339, 'concession');
insert into Facilitates values 
(3, 923014, 'usher');
insert into Facilitates values 
(4, 789456, 'concession');
insert into Facilitates values 
(5, 520169, 'usher');
insert into Facilitates values
(5, 215896, 'ticket sale');
insert into Facilitates values 
(3, 745123, 'usher');
insert into Facilitates values 
(2, 503698, 'concession');
insert into Facilitates values 
(5, 014589, 'usher');
