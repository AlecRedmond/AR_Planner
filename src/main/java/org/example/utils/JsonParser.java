package org.example.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import org.example.application.PlannerEvent;
import org.example.configs.Configs;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import static org.example.configs.Configs.SAVE_LOCATION;

@Data
public class JsonParser {
    private Gson gson;

    public JsonParser() {
        gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
        try {
            File saveFile = new File(SAVE_LOCATION);
            saveFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Warning, could not create a file at" + SAVE_LOCATION);
            throw new RuntimeException(e);
        }
    }

    public void writeToFile(PlannerEvent[] plannerEvents) {
        try (FileWriter fileWriter = new FileWriter(SAVE_LOCATION)) {
            clearTheFile(SAVE_LOCATION);
            fileWriter.write(serialisePlannerEventArray(plannerEvents));
        } catch (IOException e) {
            System.out.println("Warning, could not write to the file at" + SAVE_LOCATION);
            throw new RuntimeException(e);
        }
    }

    public PlannerEvent[] readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_LOCATION))) {
            String json = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
            return deserializePlannerEventArray(json);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Warning, could not read from the file at" + SAVE_LOCATION);
            throw new RuntimeException(e);
        }
    }

    private static void clearTheFile(String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath, false);
        PrintWriter pw = new PrintWriter(fw, false);
        pw.flush();
        pw.close();
        fw.close();
    }

    //Serialize
    public String serializePlannerEvent(PlannerEvent plannerEvent) {
        return gson.toJson(plannerEvent);
    }

    public String serialisePlannerEventArray(PlannerEvent[] plannerEvents) {
        return gson.toJson(plannerEvents);
    }

    //Deserialize
    public PlannerEvent deserializePlannerEvent(String json) {
        return gson.fromJson(json, PlannerEvent.class);
    }

    public PlannerEvent[] deserializePlannerEventArray(String json) {
        return gson.fromJson(json, PlannerEvent[].class);
    }
}
