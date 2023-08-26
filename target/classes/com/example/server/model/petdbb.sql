drop database if exists pet;

create database pet;
use pet;
create table dogLocation
(  Locationid int not null auto_increment,
 la  dec(9,7) not null default 0, 
 lo dec(9,7) not null default 0,
  calle1 varchar(100),
  calle2 varchar(100),
   alturaDeCalle int,
  dateAdded date,primary key(LocationId))engine=innodb;

create table rescuer(rescuerId int,surname varchar(50), mail varchar(200),phoneNumber int, website varchar(100) , primary key(rescuerId));

create table dogModel(
    dogId int not null auto_increment,
    race varchar(50),
    info varchar(200),
    age int,
    positionid int,
    primary key(dogId),
    foreign key(positionid) references dogLocation(Locationid)
)engine=innodb;

    insert into dogModel(race,info,age,positionid) values("Husky","a",12,12);

insert into dogLocation(la,lo,calle1,calle2,alturaDeCalle) values(0.65444,0.99333,"prueba1","prueba2",12);
 
insert into doglocation(la,lo,calle1,calle2,alturaDeCalle) values(-34.591095, -58.446736,"prueba1","prueba2",8);
   insert into dogModel(race,info,age,positionid) values("pomel","a",12,2);