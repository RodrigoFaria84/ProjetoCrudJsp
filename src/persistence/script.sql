drop database  crudjsp;
 create database crudjsp;
 use crudjsp;
 
 create table cliente (
 	idCliente int primary key auto_increment,
  	nome varchar (50),
  	email varchar (50) unique
);
 
 insert into cliente values (null,'Rodrigo','rodrigo@gmail.com');

 commit;
 
select * from cliente;