package pt.iade.myiade.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.myiade.models.Course;

public interface CourseRepository extends CrudRepository<Course,Integer> 
{
    
}
