package pt.iade.myiade.models.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import pt.iade.myiade.models.Student;

public interface StudentRepository extends CrudRepository<Student,Integer> 
{

    Optional<Student> findByEmail(String email);
    
}

