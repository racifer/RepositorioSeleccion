----EJERCICIOS
-- SOLO ES REQUERIDO REALIZAR LOS EJERCICIOS DE COMPLEJIDAD BAJA, realizar los demas ejercicios serán puntos extras para la evaluación del examen.


--- EJERCICIO 1 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todos los alumnos existentes, mostrar: TipoDoc, Documento, Nombre, Apellido, Legajo.
SELECT pers.tipodoc as TipoDoc,
       pers.documento as Documento,
       pers.nombre as Nombre,
       pers.apellido as Apellido,
       al.legajo as Legajo FROM alumno al 
				inner join persona pers on  al.idpersona=pers.identificador 
				

--- EJERCICIO 2 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todas las carreras a la que un alumno esta inscripto, mostrar: Legajo, nombre, apellido, nombre carrera,
-- fechainscripcioncarrera
--ordenado por legajo descendiente
SELECT al.legajo as Legajo, pers.nombre,pers.apellido,car.nombre as "nombre carrera",incar.fechainscripcion as fechainscripcioncarrera from alumno al
		inner join persona pers on pers.identificador=al.idpersona
		inner join inscripciones_carrera incar on al.identificador = incar.idalumno
		inner join carrera car on car.identificador=incar.idcarrera
order by al.legajo DESC
		

--- EJERCICIO 3 - COMPLEJIDAD MEDIA: 
--Realizar una consulta para consultar la cantidad de inscriptos por curso, mostrando: nombre carrera, 
--											nombre curso, cantidad inscriptos, cupo máximo por curso
SELECT car.nombre as "nombre carrera",cur.nombre as "nombre curso", count(inscur.idalumno) as "cantidad inscriptos",cur.cupomaximo as "cupo máximo por curso"
		from inscripciones_curso inscur
		inner join curso cur on cur.identificador=inscur.idcurso
		inner join carrera car on car.identificador=cur.idcarrera
group by inscur.idcurso,car.nombre,cur.nombre,cur.cupomaximo	
--- EJERCICIO 4 - COMPLEJIDAD ALTA: 
--Sobre la consulta anterior (copiar y pegarla y modificarla) modificar la sql para que la consulta retorne solo los cursos cuya cantidad de inscripciones 
--supera su cupo maximo
SELECT car.nombre as "nombre carrera",cur.nombre as "nombre curso", count(inscur.idalumno) as "cantidad inscriptos",
	cur.cupomaximo as "cupo máximo por curso"
		from inscripciones_curso inscur
		inner join curso cur on cur.identificador=inscur.idcurso
		inner join carrera car on car.identificador=cur.idcarrera
group by inscur.idcurso,car.nombre,cur.nombre,cur.cupomaximo having count(inscur.idalumno) > cur.cupomaximo	

--- EJERCICIO 5 -  COMPLEJIDAD BAJA: 
-- actualizar todos las cursos que posean anio 2018 y cuyo cupo sea menor a 5, y actualizar el cupo de todos ellos a 10.

update curso
set 
	cupomaximo=10
where anio = 2018 and cupomaximo<5

--- EJERCICIO 6 -  COMPLEJIDAD ALTA: 
-- actualizar todas las fechas de inscripcion a cursados que posean el siguiente error: la fecha de inscripcion al cursado de un 
-- alumno es menor a la fecha de inscripcion a la carrera. La nueva fecha que debe tener es la fecha del dia. Se puede hacer en dos pasos, primero
-- realizando la consulta y luego realizando el update manual

SElect inscur.idcurso,inscur.idalumno into tabla
	from inscripciones_curso inscur inner join inscripciones_carrera inscar on inscur.idalumno=inscar.idalumno
	where inscur.fechainscripcion<inscar.fechainscripcion;
update inscripciones_curso inscur
set
  fechainscripcion= CURRENT_DATE
where exists(SELECT * from tabla t where t.idcurso=inscur.idcurso and t.idalumno=inscur.idalumno );
drop table tabla
--- EJERCICIO 7 - COMPLEJIDAD BAJA:  
--INSERTAR un nuevo registro de alumno con tus datos personales, (hacer todos inserts que considera necesario)
insert into persona (identificador,
  tipodoc,
  documento,
  nombre,
  apellido,
  fechanac)
 values(6,'DNI',39342985,'Raul','Ubillos','1995-11-20')
insert into alumno (identificador,
			legajo,
			idpersona)
values
(
	6,41948,6
)
insert into inscripciones_carrera (
	idalumno,
	idcarrera,
	fechainscripcion
)
values
(
	6,1,'2013-12-4'
)


insert into curso(
	identificador,
	idcarrera,
	nombre,
	descripcion,
	cupomaximo,
	anio
)
select	7,1,'Legislacion','Curso para obtener un marco sobre leyes y regulaciones',50,2018 union all

select	8,1,'Gestion Ingenieril','Curso para aprender acerca de gestion de procesos',50,2018 union all


SELECT	9,1,'Probabilidad y estadistica','Curso para aprender acerca de tecnicas para estudio de poblaciones',50,2018 union all

SELECT	10,1,'Comunicaciones','Curso para aprender acerca de gestion de procesos',50,2018

insert into inscripciones_curso
(idalumno,idcurso,fechainscripcion)
select 6,3,to_date('2018-02-15','YYYY-MM-DD') union all
select 6,7,to_date('2018-02-15','YYYY-MM-DD') union all
select 6,8,to_date('2018-02-15','YYYY-MM-DD') union all
select 6,9,to_date('2018-02-15','YYYY-MM-DD') union all
select 6,10,to_date('2018-02-15','YYYY-MM-DD')
--- EJERCICIO 8 -  COMPLEJIDAD BAJA: 
-- si se desea comenzar a persistir de ahora en mas el dato de direccion de un alumno y considerando que este es un único cambio string de 200 caracteres.
-- Determine sobre que tabla seria mas conveniente persistir esta información y realizar la modificación de estructuras correspondientes.
alter table persona
	add Direccion character varying(200) null
