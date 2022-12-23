package oop_lecture.models;

import java.time.LocalDate;

public class HistoricalEvent {
    private String name;
    private HistoricalReign historicalReign;
    private LocalDate time;
    private String description;
    private HistoricalLocation place;
    // private Place place;
    // TODO : xem xét sử dụng Place thay cho HLocation 
}
