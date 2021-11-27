package pt.iade.myiade.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.myiade.models.Unit;
import pt.iade.myiade.models.views.UnitCoursesView;

public interface UnitRepository extends CrudRepository<Unit,Integer> 
{
    String QueryFindUnitsCourse = 
    "select cour_name courseName, unit_name unitName from unitcourses "+
    "inner join units on unitcour_unit_id = unit_id "+
    "inner join courses on unitcour_cour_id = cour_id";

    @Query(value=QueryFindUnitsCourse, nativeQuery=true)
    Iterable<UnitCoursesView> findAllUnitsCourse();

    @Query(value = QueryFindUnitsCourse +
    " where cour_name=:course", nativeQuery = true)
    Iterable<UnitCoursesView> findUnitsByCourse(
    @Param("course") String course);

}
