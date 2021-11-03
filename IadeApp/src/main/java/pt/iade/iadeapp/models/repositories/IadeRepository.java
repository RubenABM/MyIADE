package pt.iade.iadeapp.models.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.iadeapp.models.Iade;

public interface IadeRepository extends CrudRepository<Iade,Integer>
{
    
}
