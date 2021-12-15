package pt.iade.myiade.models.repositories;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.myiade.models.Presence;
import pt.iade.myiade.models.views.ScheduleIDView;

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

    String QueryFindScheduleIDByQRCOde = 
    "select sche_id scheduleID, stu_name studentName " + 
    "from schedules " +
    "inner join clapresches on sche_cps_id = cps_id " +
    "inner join unitcourses on cps_unitcour_id = unitcour_id " +
    "inner join courses on unitcour_cour_id = cour_id " +
    "inner join units on unitcour_unit_id = unit_id " +
    "inner join enrollments on cps_id = enroll_cps_id " +
    "inner join students on enroll_stu_id = stu_id ";

    @Query(value = QueryFindScheduleIDByQRCOde +
    " where sche_qr=:qr", nativeQuery = true)
    Iterable<ScheduleIDView> findScheduleIDByQRCode(@Param("qr") int QRCode);
}
