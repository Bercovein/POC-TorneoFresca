create database torneo;
use torneo;

create table ganadores(
	id_ganador int auto_increment,
    nombre_ganador varchar(50),
    nombre_perdedor varchar(50),
    ingerido Integer default 0,
    primary key(id_ganador)
);


