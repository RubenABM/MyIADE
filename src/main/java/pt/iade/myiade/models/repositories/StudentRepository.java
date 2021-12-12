package pt.iade.myiade.models.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.myiade.models.Student;
import pt.iade.myiade.models.views.GradesView;
import pt.iade.myiade.models.views.PresenceView;
import pt.iade.myiade.models.views.ResourceView;
import pt.iade.myiade.models.views.ScheduleView;

public interface StudentRepository extends CrudRepository<Student,Integer> 
{

    Optional<Student> findByEmailAndPassword(String email, String password);

    String QueryFindStudentsGrade = 
    "select stu_name studentName, enroll_grade studentGrade, unit_name unitName, unit_semester unitSemester "+
    "from clapresches inner join unitcourses on cps_unitcour_id = unitcour_id "+
    "inner join courses on unitcour_cour_id = cour_id "+
    "inner join units on unitcour_unit_id = unit_id  "+
    "inner join enrollments on enroll_cps_id = cps_id "+
    "inner join students on stu_id = enroll_stu_id ";
    
    @Query(value=QueryFindStudentsGrade, nativeQuery=true)
    Iterable<GradesView> findAllStudentsGrades();

    @Query(value = QueryFindStudentsGrade +
    " where stu_id=:id", nativeQuery = true)
    Iterable<GradesView> findStudentGradesByID(@Param("id") int id);

    String QueryFindStudentsSChedule =
    "select stu_name studentName, unit_name unitName, sche_begin startTime, sche_end endTime, sche_weekday weekday "+
    "from clapresches inner join unitcourses on cps_unitcour_id = unitcour_id "+
    "inner join units on unitcour_unit_id = unit_id "+  
    "inner join enrollments on enroll_cps_id = cps_id "+
    "inner join schedules on sche_cps_id = cps_id "+
    "inner join students on stu_id = enroll_stu_id  ";

    @Query(value = QueryFindStudentsSChedule +
    " where stu_id=:id and unit_semester=:semester", nativeQuery = true)
    Iterable<ScheduleView> findStudentSchedule(@Param("id") int id, @Param("semester") int semester);

    String QueryFindStudentsResource =
    "select distinct stu_name studentName, cour_name courName, cour_url courUrl " +
    "from students " +
    "inner join enrollments on stu_id = enroll_stu_id " +
    "inner join clapresches on cps_id = enroll_cps_id " +
    "inner join unitcourses on cps_unitcour_id = unitcour_id " +
    "inner join courses on cour_id = unitcour_cour_id " +
    "inner join units on unit_id = unitcour_unit_id ";

    @Query(value = QueryFindStudentsResource +
    " where stu_id=:id", nativeQuery = true)
    Iterable<ResourceView> findStudentResource(@Param("id") int id);

    String QueryFindStudentsPresence =
    "select pre_date presenceDate, stu_name studentName, unit_name unitName " +
    "from presences " +
    "inner join students on pre_stu_id = stu_id " +
    "inner join schedules on pre_sche_id = sche_id " +
    "inner join clapresches on sche_cps_id = cps_id " +
    "inner join unitcourses on cps_unitcour_id = unitcour_id " +
    "inner join courses on unitcour_cour_id = cour_id " +
    "inner join units on unitcour_unit_id = unit_id ";
      
    @Query(value = QueryFindStudentsPresence +
    " where stu_id=:id", nativeQuery = true)
    Iterable<PresenceView> findStudentPresence(@Param("id") int id);

    

}

