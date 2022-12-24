package oop_lecture.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistoricalFigure extends NameIdentifiedObject {
    private HistoricalReign historicalReign;
    private List<String> achievements = new ArrayList<>();
    private List<HistoricalFigure> relatedFigures = new ArrayList<>();
    private LocalDate birthDate, dieDate;

    public HistoricalFigure(String name) {
        super(name);
    }
}
