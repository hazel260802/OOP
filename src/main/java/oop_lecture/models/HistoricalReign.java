package oop_lecture.models;

import java.time.LocalDate;

public class HistoricalReign extends NameIdentifiedObject {
    private String nationName;
    private LocalDate startTime, corruptedTime;
    private Place capital;

    public HistoricalReign(String name) {
        super(name);
    }
}
