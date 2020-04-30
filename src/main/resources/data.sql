INSERT INTO especialidad(name) VALUES ('MEDICO GENERAL');
INSERT INTO especialidad(name) VALUES ('ODONTOLOGIA');
INSERT INTO especialidad(name) VALUES ('PEDIATRIA');
INSERT INTO especialidad(name) VALUES ('CARDIOLOGIA');
INSERT INTO especialidad(name) VALUES ('OFTALMOLOGIA');
INSERT INTO especialidad(name) VALUES ('OTORRINOLARINGOLOGIA');
INSERT INTO especialidad(name) VALUES ('NEUMOLOGIA');
INSERT INTO especialidad(name) VALUES ('ONCOLOGIA');

INSERT INTO paciente (firstname,lastname,dni,numberclinicalhistory) 
VALUES('Juan Carlos','Solar Torres','43032393','HI00001');
INSERT INTO paciente (firstname,lastname,dni,numberclinicalhistory) 
VALUES('Erika','Cordova Cordova','47253689','HI00002');
INSERT INTO paciente (firstname,lastname,dni,numberclinicalhistory) 
VALUES('Paul Ernesto','Castillo Gonzales','45638952','HI00003');
INSERT INTO paciente (firstname,lastname,dni,numberclinicalhistory) 
VALUES('Alvaro ','Solar Avila','32541296','HI00004');
INSERT INTO paciente (firstname,lastname,dni,numberclinicalhistory) 
VALUES('Jorge','Suyon Juarez','23145623','HI00005');
INSERT INTO paciente (firstname,lastname,dni,numberclinicalhistory) 
VALUES('Agustina Paula','Juarez Juarez','78412539','HI00006');
INSERT INTO paciente (firstname,lastname,dni,numberclinicalhistory) 
VALUES('Saul Anastacio','Perez Perez','36524189','HI00008');
INSERT INTO paciente (firstname,lastname,dni,numberclinicalhistory) 
VALUES('Maria Paulina','Perez Perez','47251236','HI00009');
INSERT INTO paciente (firstname,lastname,dni,numberclinicalhistory) 
VALUES('Marco Antonio','Perez Perez','58412369','HI00010');

INSERT INTO doctor (firstname,lastname,cmp,dni,especialidad) 
VALUES('Jose Pool','Aristidez Arrunategui','CMP0001','4231585','1');
INSERT INTO doctor (firstname,lastname,cmp,dni,especialidad) 
VALUES('Paul Higor','Arrunategui Silva','CMP0009','12345678','1');
INSERT INTO doctor (firstname,lastname,cmp,dni,especialidad) 
VALUES('Rigoberto André','Vidal Porres','CMP0010','12345678','1');
INSERT INTO doctor (firstname,lastname,cmp,dni,especialidad) 
VALUES('Ana Maria','Torres Flores','CMP0002','4231585','2');
INSERT INTO doctor (firstname,lastname,cmp,dni,especialidad) 
VALUES('Hector Angel Cesar','Accinelli Calderon','CMP0003','4231585','3');
INSERT INTO doctor (firstname,lastname,cmp,dni,especialidad) 
VALUES('Manuel Omar','Acosta Orbegozo','CMP0004','12457896','4');
INSERT INTO doctor (firstname,lastname,cmp,dni,especialidad) 
VALUES('Oscar Manuel','Acosta Tapia','CMP0005','23456987','5');
INSERT INTO doctor (firstname,lastname,cmp,dni,especialidad) 
VALUES('Zozimo Venacio','Pineda Mejia','CMP0006','45126396','6');
INSERT INTO doctor (firstname,lastname,cmp,dni,especialidad) 
VALUES('Wilfredo Martin','Alarcon Lara','CMP0007','7852692','7');
INSERT INTO doctor (firstname,lastname,cmp,dni,especialidad) 
VALUES('Victor Hugo','Chong Garcia','CMP0008','96254154','8');

INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-01','1','1');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-02','2','1');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-03','3','1');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-04','4','1');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-05','5','1');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-06','6','1');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-07','7','1');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-08','8','1');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-09','1','1');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-10','2','1');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-11','3','1');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-12','4','1');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-13','5','1');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-14','6','1');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-15','7','1');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-16','8','1');

INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-01','1','2');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-02','2','2');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-03','3','2');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-04','4','2');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-05','5','2');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-06','6','2');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-07','7','2');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-08','8','2');

INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-01','1','3');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-02','2','3');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-03','3','3');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-04','4','3');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-05','5','3');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-06','6','3');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-07','7','3');
INSERT INTO consulta_medica(create_date,id_doctor,id_paciente) values('2020-04-08','8','3');

