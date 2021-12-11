package pt.iade.myiade.models.views;

import java.time.LocalDate;

public interface PresenceView {
    
    LocalDate getPresenceDate();
    String getStudentName();
    String getUnitName();

}
