package pt.iade.myiade.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.myiade.models.Student;

public interface StudentRepository extends CrudRepository<Student,Integer> 
{
    
}

