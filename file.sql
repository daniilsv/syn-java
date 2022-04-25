create table IF NOT EXISTS "Users" (
  id INT GENERATED ALWAYS AS IDENTITY,
  name varchar(20) not null,
  PRIMARY KEY(id)
);

create table "Contacts"(
   id INT generated always as identity,
   "customerId" INT,
   "contactName" VARCHAR(255) not null,
   phone VARCHAR(15),
   email VARCHAR(100),
   primary key(id),
   constraint fk_customer
      foreign key("customerId")
	  references "Users"(id)
);

insert into Users (name, phone) values
('Petya', '125453'),
('Vasya', '654321'),
('Katya', null);



update Users
  set name = 'Ne Petya', phone = '+79991112233'
  where id=1;


select * from public."Users";
select id,name,phone from Users;
select id,name,phone from Users where name like '%Petya%';
select id,name,phone
  from Users
  where
    name not like '%Petya%'
    and
    phone is not null;


delete from Users where id < 5;
