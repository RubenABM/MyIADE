package pt.iade.myiade.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.myiade.models.Course;
import pt.iade.myiade.models.views.StudentCourseView;

public interface CourseRepository extends CrudRepository<Course,Integer> 
{
    String QueryFindStudentsCourse = 
    "select stu_name studentName, cour_name courseName "+
    "from clapresches inner join unitcourses on cps_unitcour_id = unitcour_id "+
    "inner join courses on unitcour_cour_id = cour_id "+
    "inner join units on unitcour_unit_id = unit_id  "+
    "inner join enrollments on enroll_cps_id = cps_id "+
    "inner join students on stu_id = enroll_stu_id ";

    @Query(value=QueryFindStudentsCourse, nativeQuery=true)
    Iterable<StudentCourseView> findAllStudentsCourses();

    @Query(value = QueryFindStudentsCourse +
    " where stu_id=:id group by stu_name, cour_name", nativeQuery = true)
    Iterable<StudentCourseView> findStudentCourseByID(@Param("id") int id);

}
