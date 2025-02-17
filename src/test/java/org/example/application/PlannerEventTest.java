package org.example.application;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PlannerEventTest {

    @Test
    void secondsUntilEventStart() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.plusHours(1);
        PlannerEvent plannerEvent = new PlannerEvent(localDateTime,"test name","test event");
        assertEquals(3599,plannerEvent.secondsUntilEventStart());
    }

    @Test
    void secondsUntilEventEnd() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.plusHours(1);
        PlannerEvent plannerEvent = new PlannerEvent(localDateTime,"test name","test event");
        assertEquals((3600+3600),plannerEvent.secondsUntilEventEnd());
    }
}