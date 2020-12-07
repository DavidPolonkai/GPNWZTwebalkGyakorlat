create table FACTORY(
 id long auto_increment primary key,
 fname varchar(200) not null,
 size int not null,
 city varchar(200) not null
);

create table Product(
    id long auto_increment primary key,
    pname varchar(200) not null,
    prodprice long not null,
    sizeclass int not null
);

