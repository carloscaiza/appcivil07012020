INSERT INTO personas (id, nombre, apellido, email, create_at) VALUES (1,'CARLOS','CAIZA','krlos_au@yahoo.com','2019-10-04');
INSERT INTO personas (id, nombre, apellido, email, create_at) VALUES (2,'CARLOS','AGUILAR','leo23au@gmail.com','2019-09-04');

INSERT INTO proyectores(id, alta, marca, modelo, serie, color, foto, estatus) VALUES (1,'111','SONY','VAIO','123','NEGRO', '', 'Disponible');
INSERT INTO proyectores(id, alta, marca, modelo, serie, color, foto, estatus) VALUES (2,'222','SANSUNG','LLL','123','BLANCO', '', 'Disponible');
INSERT INTO proyectores(id, alta, marca, modelo, serie, color, foto, estatus) VALUES (3,'333','SONY','VAIO','123','NEGRO', '', 'Disponible');
INSERT INTO proyectores(id, alta, marca, modelo, serie, color, foto, estatus) VALUES (4,'444','SANSUNG','LLL','123','BLANCO', '', 'Disponible');
INSERT INTO proyectores(id, alta, marca, modelo, serie, color, foto, estatus) VALUES (5,'555','SONY','VAIO','123','NEGRO', '', 'Ocupado');
INSERT INTO proyectores(id, alta, marca, modelo, serie, color, foto, estatus) VALUES (6,'666','SANSUNG','LLL','123','BLANCO', '', 'Disponible');
INSERT INTO proyectores(id, alta, marca, modelo, serie, color, foto, estatus) VALUES (7,'777','SONY','VAIO','123','NEGRO', '', 'Disponible');
INSERT INTO proyectores(id, alta, marca, modelo, serie, color, foto, estatus) VALUES (8,'888','SANSUNG','LLL','123','BLANCO', '', 'Disponible');
INSERT INTO proyectores(id, alta, marca, modelo, serie, color, foto, estatus) VALUES (9,'999','SONY','VAIO','123','NEGRO', '', 'Ocupado');
INSERT INTO proyectores(id, alta, marca, modelo, serie, color, foto, estatus) VALUES (10,'101','SANSUNG','LLL','123','BLANCO', '', 'Disponible');
INSERT INTO proyectores(id, alta, marca, modelo, serie, color, foto, estatus) VALUES (11,'102','SONY','VAIO','123','NEGRO', '', 'Disponible');
INSERT INTO proyectores(id, alta, marca, modelo, serie, color, foto, estatus) VALUES (12,'103','SANSUNG','LLL','123','BLANCO', '', 'Disponible');
INSERT INTO proyectores(id, alta, marca, modelo, serie, color, foto, estatus) VALUES (13,'104','SONY','VAIO','123','NEGRO', '', 'Disponible');
INSERT INTO proyectores(id, alta, marca, modelo, serie, color, foto, estatus) VALUES (14,'105','SANSUNG','LLL','123','BLANCO', '', 'Disponible');

INSERT INTO estudiantes(id, nombre, apellido, email, cedula, telefono, foto ) VALUES (1,'Juan','Pérez Soza','krlos_au@yahoo.com','1725383259','0983983478', '');
INSERT INTO estudiantes(id, nombre, apellido, email, cedula, telefono, foto ) VALUES (2,'Carlos Augusto','Az Aguilar','krlos_aug@outlook.com','1723383259','0983983478', '');
INSERT INTO estudiantes(id, nombre, apellido, email, cedula, telefono, foto ) VALUES (3,'Samanta','Pérez Caza','sam_p@yahoo.com','1725383359','0982983478', '');

INSERT INTO profesores(id, nombre, apellido, email, cedula) VALUES (1,'Carlitos','Enzo Ruiz','krlos_au@yahoo.com','1725383259');
INSERT INTO profesores(id, nombre, apellido, email, cedula) VALUES (2,'Augusto','Cantuña','leo23au@gmail.com','1725383259');
INSERT INTO profesores(id, nombre, apellido, email, cedula) VALUES (3,'Saúl Aaron','Caiza Soza','krlos_au@yahoo.com','1725383259');

INSERT INTO materias(id, nombre, codigo, creditos, semestre, paralelo) VALUES (1,'Calculo Diferencial','B.101 CD',6,1,1);
INSERT INTO materias(id, nombre, codigo, creditos, semestre, paralelo) VALUES (2,'Estática','B.102 ET',4,2,2);
INSERT INTO materias(id, nombre, codigo, creditos, semestre, paralelo) VALUES (3,'Hidráulica 2','P.204 H',4,4,3);
/*INSERT INTO materias(id, nombre, codigo, creditos, semestre, paralelo) VALUES (3,'Hidráulica 2','P.204 H',4,'Cuarto',3);*/

INSERT INTO registros(descripcion, horario, create_re,  estudiante_id, profesor_id, materia_id, estado) values ('Test','Lunes 7-9', NOW(),  1,1,1, 'Activo');
INSERT INTO registros(descripcion, horario, create_re,  estudiante_id, profesor_id, materia_id, estado) values ('Test2','Martes 7-9', NOW(),  1,2,2, 'Inactivo');
INSERT INTO registros(descripcion, horario, create_re,  estudiante_id, profesor_id, materia_id, estado) values ('Test3','Lunes 7-9', NOW(),  2,3,3, 'Activo');
INSERT INTO registros(descripcion, horario, create_re,  estudiante_id, profesor_id, materia_id, estado) values ('Test4','Lunes 7-9', NOW(),  2,3,3, 'Activo');
INSERT INTO registros(descripcion, horario, create_re,  estudiante_id, profesor_id, materia_id, estado) values ('Test5','Lunes 7-9', NOW(),  2,2,1, 'Inactivo');
INSERT INTO registros(descripcion, horario, create_re,  estudiante_id, profesor_id, materia_id, estado) values ('Test6','Lunes 7-9', NOW(),  3,1,2, 'Activo');

INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion, estado) values ('A1', NOW(), NOW(), NOW(),2, 1,'', 'Activo');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A2', NOW(), NOW(), NOW(),1, 2, '','Terminado');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A3', NOW(), NOW(), NOW(),3, 3, '','Activo');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A4', NOW(), NOW(), NOW(),5, 4, '','Terminado');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A5', NOW(), NOW(), NOW(),4, 2, '','Activo');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A6', NOW(), NOW(), NOW(),6, 6, '','Terminado');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A7', NOW(), NOW(), NOW(),3, 7, '','Activo');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A8', NOW(), NOW(), NOW(),5, 8,'', 'Terminado');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A9', NOW(), NOW(), NOW(),1, 8,'', 'Activo');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A10', NOW(), NOW(), NOW(),2, 10,'', 'Terminado');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A11', NOW(), NOW(), NOW(),3, 11, '','Activo');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A12', NOW(), NOW(), NOW(),4, 12,'', 'Terminado');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A13', NOW(), NOW(), NOW(),5, 13,'', 'Activo');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A14', NOW(), NOW(), NOW(),6, 14,'', 'Terminado');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A15', NOW(), NOW(), NOW(),2, 1,'', 'Activo');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A16', NOW(), NOW(), NOW(),3, 12,'', 'Terminado');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A17', NOW(), NOW(), NOW(),2, 1,'', 'Activo');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A18', NOW(), NOW(), NOW(),1, 2,'', 'Terminado');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A19', NOW(), NOW(), NOW(),3, 3,'', 'Activo');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A20', NOW(), NOW(), NOW(),5, 4,'', 'Terminado');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A21', NOW(), NOW(), NOW(),4, 2,'', 'Activo');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A22', NOW(), NOW(), NOW(),6, 6,'', 'Terminado');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A23', NOW(), NOW(), NOW(),3, 7,'', 'Activo');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A24', NOW(), NOW(), NOW(),5, 8, '','Terminado');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A25', NOW(), NOW(), NOW(),1, 8, '','Activo');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A26', NOW(), NOW(), NOW(),2, 10,'', 'Terminado');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A27', NOW(), NOW(), NOW(),3, 11, '','Activo');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A28', NOW(), NOW(), NOW(),4, 12, '','Terminado');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A29', NOW(), NOW(), NOW(),5, 13,'', 'Activo');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A30', NOW(), NOW(), NOW(),6, 14,'', 'Terminado');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion,estado) values ('A31', NOW(), NOW(), NOW(),2, 1, '','Activo');
INSERT INTO prestamos(aula, create_pr, hora_in, hora_fn, registro_id, proyector_id, observacion, estado) values ('A32', NOW(), NOW(), NOW(),3, 12,'Parlantes', 'Terminado');




/* Creamos algunos usuarios con sus roles */
INSERT INTO users (username, password, enabled) VALUES('carlos', '$2a$10$yd2OvuhuZlvLu9u8FHL6pO6xL4lu.Kvk0kUxIdbE64JHKk8T2KUDi', 1);
INSERT INTO users (username, password, enabled) VALUES('admin', '$2a$10$V2CoD3MqJplG45TsRbWweuJg79hmkpNxvBgwaYauYb8SxKF3T42UW', 1);

INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_USER');

