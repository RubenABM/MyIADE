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

create table teacher (
					teach_id SERIAL not null,
					teach_name VARCHAR(100) not null,
					teach_bdate date not null, 
					teach_phone INT not null,
					teach_email VARCHAR(30), 
					teach_address VARCHAR(250),					
					teach_password VARCHAR(64),				
					teach_gender CHAR(1) not null,
					teach_civilnum INT not null, 						
					primary key (teach_id)	
);
		     		     
create table course (
					cour_id SERIAL not null,
					cour_name VARCHAR(40) not null, 
					primary key (cour_id)
);

create table unit (
					unit_id SERIAL not null,
					unit_name VARCHAR(40) not null, 
					unit_semester INT not null,
					primary key (unit_id)
);

create table unitcourse (
					unitcourse_id SERIAL not null,
					unit_id INT not null,
					cour_id INT not null,
					primary key (unitcourse_id)
);

create table class (
					class_id SERIAL not null,
					class_name VARCHAR(15) not null,
					class_unitcourse_id INT not null,
					primary key (class_id)
);

create table enrollment (
					enroll_id SERIAL not null,
					enroll_stu_id INT not null,
					enroll_class_id INT not null,
					enroll_grade INT,
					enroll_date date not null,
					primary key (enroll_id) 
);

create table schedule (
					sche_id SERIAL not null,
					sche_class_id INT not null,
					sche_begin date not null,
					sche_end date not null,
					sche_date date not null,
					primary key (sche_id)
);

create table presence (
					pre_id SERIAL not null,
					pre_date date not null,
					pre_presence INT not null,
					pre_enroll_id INT not null,
					pre_sche_id INT not null,
					primary key (pre_id)
);

create table uniteacher (
					unitte_id SERIAL not null,
					unitte_unitcourse_id INT not null,
					unitte_teacher_id INT not null,
					unitte_year date not null,
					primary key (unitte_id)
);

alter table enrollment 
add constraint students_fk_enrollment
foreign key (enroll_stu_id) references students(stu_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table enrollment 
add constraint class_fk_enrollment
foreign key (enroll_class_id) references class(class_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table unitcourse 
add constraint unitcourse_fk_unit
foreign key (unit_id) references unit(unit_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table unitcourse 
add constraint unitcourse_fk_course
foreign key (cour_id) references course(cour_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table class 
add constraint class_fk_unitcourse
foreign key (class_unitcourse_id) references unitcourse(unitcourse_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table schedule 
add constraint schedule_fk_class
foreign key (sche_class_id) references class(class_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table presence 
add constraint presence_fk_enrollment
foreign key (pre_enroll_id) references enrollment(enroll_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table presence 
add constraint presence_fk_schedule
foreign key (pre_sche_id) references schedule(sche_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table uniteacher 
add constraint uniteacher_fk_unitcourse
foreign key (unitte_unitcourse_id) references unitcourse(unitcourse_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table uniteacher 
add constraint uniteacher_fk_teacher
foreign key (unitte_teacher_id) references teacher(teach_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;
