package org.example.application;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Data
public class PlannerEvent {
    private LocalDateTime localDateTimeStart;
    private LocalDateTime localDateTimeEnd;
    private String eventNameString;
    private String eventDetailString;
    private String uuid;

    public PlannerEvent(LocalDateTime localDateTimeStart,String eventNameString, String eventDetailString) {
        this.eventNameString = eventNameString;
        this.eventDetailString = eventDetailString;
        this.localDateTimeStart = localDateTimeStart;
        this.localDateTimeEnd = localDateTimeStart.plusHours(1);
        uuid = UUID.randomUUID().toString();
    }

    public long secondsUntilEventStart(){
        return LocalDateTime.now().until(localDateTimeStart, ChronoUnit.SECONDS);
    }

    public long secondsUntilEventEnd(){
        return LocalDateTime.now().until(localDateTimeEnd, ChronoUnit.SECONDS);
    }
}
