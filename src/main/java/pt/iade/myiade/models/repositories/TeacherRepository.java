package pt.iade.myiade.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.myiade.models.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher,Integer> 
{
    
}
