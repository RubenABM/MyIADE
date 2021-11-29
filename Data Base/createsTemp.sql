create table students (
					stu_id SERIAL not null,
					stu_name VARCHAR(100) not null,
					stu_bdate date not null, 
					stu_phone INT not null,
					stu_email VARCHAR(30), 
					stu_address VARCHAR(250),					
					stu_password VARCHAR(64),				
					stu_gender CHAR(1) not null,
					stu_civilnum INT not null,  						
					primary key (stu_id)	
);

create table teachers (
					teach_id SERIAL not null,
					teach_name VARCHAR(100) not null, 
					teach_phone INT not null,
					teach_email VARCHAR(30), 														
					primary key (teach_id)	
);
		     		     
create table courses (
					cour_id SERIAL not null,
					cour_name VARCHAR(40) not null, 
					primary key (cour_id)
);

create table units (
					unit_id SERIAL not null,
					unit_name VARCHAR(60) not null, 
					unit_semester INT not null,
					primary key (unit_id)
);

create table unitcourses (
					unitcour_id SERIAL not null,
					unitcour_unit_id INT not null,
					unitcour_cour_id INT not null,
					primary key (unitcour_id)
);

create table classes (
					cla_id SERIAL not null,
					cla_name VARCHAR(15) not null,
					primary key (cla_id)
);

create table enrollments (
					enroll_id SERIAL not null,
					enroll_stu_id INT not null,
					enroll_cla_id INT not null,
					enroll_grade INT,
					enroll_date date not null,
					primary key (enroll_id) 
);

create table schedules (
					sche_id SERIAL not null,
					sche_begin date not null,
					sche_end date not null,
					sche_cps_id INT not null,
					primary key (sche_id)
);

create table presences (
					pre_id SERIAL not null,
					pre_date date not null,
					pre_cps_id INT not null,
					primary key (pre_id)
);

create table uniteachers (
					unitte_id SERIAL not null,
					unitte_unitcour_id INT not null,
					unitte_teach_id INT not null,
					unitte_year date not null,
					primary key (unitte_id)
);

create table clapresches (
					cps_id SERIAL not null,
					cps_cla_id INT not null,
					cps_unitcour_id INT not null,
					primary key (cps_id)
);

create table resources (
					res_id SERIAL not null,
					res_unitcour_id INT not null,
          res_url VARCHAR(200) not null,
					primary key (res_id)
);

alter table enrollments
add constraint students_fk_enrollments
foreign key (enroll_stu_id) references students(stu_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table enrollments
add constraint class_fk_enrollments
foreign key (enroll_cla_id) references classes(cla_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table unitcourses 
add constraint unitcourse_fk_units
foreign key (unitcour_unit_id) references units(unit_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table unitcourses 
add constraint unitcourse_fk_courses
foreign key (unitcour_cour_id) references courses(cour_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table schedules 
add constraint schedule_fk_clapresches
foreign key (sche_cps_id) references clapresches(cps_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table presences 
add constraint presence_fk_clapresches
foreign key (pre_cps_id) references clapresches(cps_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table uniteachers 
add constraint uniteachers_fk_unitcourses
foreign key (unitte_unitcour_id) references unitcourses(unitcour_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table uniteachers 
add constraint uniteachers_fk_teachers
foreign key (unitte_teach_id) references teachers(teach_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table clapresches 
add constraint clapresches_fk_unitcourses
foreign key (cps_unitcour_id) references unitcourses(unitcour_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table clapresches
add constraint clapresches_fk_classes
foreign key (cps_cla_id) references classes(cla_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table resources
add constraint resources_fk_unitcourses
foreign key (res_unitcour_id) references unitcourses(unitcour_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;
