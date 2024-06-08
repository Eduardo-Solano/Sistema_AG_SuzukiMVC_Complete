use Suzuki;

insert into usuario (nombre,apellido,usuario,telefono,contraseña,tipoUsuario) values('User','Name','admin','1234567890','admin1','Administrador');
insert into categoria (descripcion)values('Naked');
insert into categoria (descripcion)values('Deportivas');
insert into categoria (descripcion)values('Scooter');
insert into categoria (descripcion)values('Trabajo');
insert into categoria (descripcion)values('Doble Proposito');

select *from categoria;
select *from usuario;