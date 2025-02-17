package org.example.utils;

import org.example.application.PlannerEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

class JsonParserTest {
    JsonParser jsonParser;
    String DESERIALIZE = "{\"localDateTimeStart\":\"2030-02-04T06:08:10\",\"localDateTimeEnd\":\"2030-02-04T07:08:10\",\"eventNameString\":\"Test Event\",\"eventDetailString\":\"Example detail\",\"uuid\":\"b30e60a2-f00f-49d0-bb2f-4df8de271f1d\"}";

    @BeforeEach
    void initializeJsonParser(){
        jsonParser = new JsonParser();
    }

    @Test
    void serializePlannerEvent() {
        PlannerEvent plannerEvent = new PlannerEvent(LocalDateTime.of(2030,2,4,6,8,10),"Test Event","Example detail");
        System.out.println(jsonParser.serializePlannerEvent(plannerEvent));
    }

    @Test
    void serializePlannerEventArray() {
    }

    @Test
    void deserializePlannerEvent() {
        PlannerEvent plannerEvent = jsonParser.deserializePlannerEvent(DESERIALIZE);
        System.out.println(plannerEvent);
    }

    @Test
    void deserializePlannerEventArray() {
    }

    @Test
    void writeToFile() {
        PlannerEvent plannerEvent1 = new PlannerEvent(LocalDateTime.of(2026,2,4,6,8,10),"Test Event","Example detail");
        PlannerEvent plannerEvent2 = new PlannerEvent(LocalDateTime.of(2030,2,4,6,8,10),"Test Event","Example detail");
        PlannerEvent plannerEvent3 = new PlannerEvent(LocalDateTime.of(2033,2,4,6,8,10),"Test Event","Example detail");
        PlannerEvent plannerEvent4 = new PlannerEvent(LocalDateTime.of(2031,2,4,6,8,10),"Test Event","Example detail");
        PlannerEvent[] plannerEvents = {plannerEvent1,plannerEvent2,plannerEvent3,plannerEvent4};
        jsonParser.writeToFile(plannerEvents);
    }

    @Test
    void readFromFile() {
        PlannerEvent[] plannerEvents = jsonParser.readFromFile();
        Arrays.stream(plannerEvents).forEach(System.out::println);
    }


}