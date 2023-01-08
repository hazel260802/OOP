package oop_lecture.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class CulturalFestival extends NameIdentifiedObject {
    private String level;
    private boolean isNationalHeritage;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private HistoricalLocation place;
    // TODO : xem xét dùng Place thay cho HL
    private LocalDate time;
    private String firstHeld;

    public CulturalFestival(String name) {
        super(name);
    }
}