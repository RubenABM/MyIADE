package pt.iade.myiade.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.myiade.models.Unit;

public interface UnitRepository extends CrudRepository<Unit,Integer> 
{
    String QueryFindUnitsCourse = 
    "select cour_name courseName, unit_name unitName from unitcourses "+
    "inner join units on unitcour_unit_id = unit_id "+
    "inner join courses on unitcour_cour_id = cour_id";
    
}
