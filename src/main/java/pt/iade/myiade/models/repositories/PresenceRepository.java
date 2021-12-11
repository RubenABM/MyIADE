package pt.iade.myiade.models.repositories;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.myiade.models.Presence;

public interface PresenceRepository extends CrudRepository<Presence,Integer> 
{
    @Modifying @Transactional
    @Query(value="insert into presences "+
    "(pre_sche_id, pre_stu_id, pre_date) "+ 
    "values (:pre_sche_id, :pre_stu_id, "+
    ":pre_date)", nativeQuery=true)
    Integer registerPresence(@Param("pre_sche_id") int presenceScheduleId,
    @Param("pre_stu_id") int presenceStudentId,
    @Param("pre_date") LocalDate presenceDate);

}
