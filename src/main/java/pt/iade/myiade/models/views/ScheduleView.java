package pt.iade.myiade.models.views;

import java.sql.Time;

public interface ScheduleView {
    
    String getStudentName();
    String getUnitName();
    Time getStartTime();
    Time getEndTime();
    String getWeekDay();
    
}
