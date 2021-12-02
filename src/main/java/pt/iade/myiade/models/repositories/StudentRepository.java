package pt.iade.myiade.models.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.myiade.models.Student;
import pt.iade.myiade.models.views.GradesView;

public interface StudentRepository extends CrudRepository<Student,Integer> 
{

    Optional<Student> findByEmailAndPassword(String email, String password);

    String QueryFindUnitsCourse = 
    "select stu_name studentName, enroll_grade studentGrade, unit_name unitName, unit_semester unitSemester "+
    "from clapresches inner join unitcourses on cps_unitcour_id = unitcour_id "+
    "inner join courses on unitcour_cour_id = cour_id "+
    "inner join units on unitcour_unit_id = unit_id  "+
    "inner join enrollments on enroll_cps_id = cps_id "+
    "inner join students on stu_id = enroll_stu_id ";
    
    @Query(value=QueryFindUnitsCourse, nativeQuery=true)
    Iterable<GradesView> findAllStudentsGrades();

    @Query(value = QueryFindUnitsCourse +
    " where stu_id=:id", nativeQuery = true)
    Iterable<GradesView> findStudentsGradesByID(@Param("id") int id);
}

