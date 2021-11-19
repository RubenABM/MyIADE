-- Visualizar a informação de todos os estudantes
select * from students

-- Visualizar a informação de um estudante consoante o id
select * from students
where stu_id = 1

-- Visualizar as unidades curriculares referentes a um curso específico
select cour_name, unit_name from unitcourses
inner join units on unitcour_unit_id = unit_id
inner join courses on unitcour_cour_id = cour_id
where cour_name = 'Engenharia Informática'
