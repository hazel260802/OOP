package oop_lecture.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class HistoricalEvent extends NameIdentifiedObject{
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private HistoricalReign historicalReign;
    private LocalDate time;
    private String description;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private HistoricalLocation place;

    public HistoricalEvent(String name) {
        super(name);
    }
    // private Place place;
    // TODO : xem xét sử dụng Place thay cho HLocation 
}
