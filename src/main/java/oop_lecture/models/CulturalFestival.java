package oop_lecture.models;

import java.time.LocalDate;

public class CulturalFestival extends NameIdentifiedObject {
    private String level;
    private boolean isNationalHeritage;
    private HistoricalLocation place;
    // TODO : xem xét dùng Place thay cho HL
    private LocalDate time;
    private String firstHeld;

    public CulturalFestival(String name) {
        super(name);
    }
}