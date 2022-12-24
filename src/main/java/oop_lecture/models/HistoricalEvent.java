package oop_lecture.models;

import java.time.LocalDate;

public class HistoricalEvent extends NameIdentifiedObject{
    private HistoricalReign historicalReign;
    private LocalDate time;
    private String description;
    private HistoricalLocation place;

    public HistoricalEvent(String name) {
        super(name);
    }
    // private Place place;
    // TODO : xem xét sử dụng Place thay cho HLocation 
}
