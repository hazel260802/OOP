package oop_lecture.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistoricalFigure extends NameIdentifiedObject {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private HistoricalReign historicalReign;
    private List<String> achievements = new ArrayList<>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<HistoricalFigure> relatedFigures = new ArrayList<>();
    private LocalDate birthDate, dieDate;

    public HistoricalFigure(String name) {
        super(name);
    }
}
