package oop_lecture.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistoricalFigure {
    private String name;
    private HistoricalReign historicalReign;
    private List<String> achievements = new ArrayList<>();
    private List<HistoricalFigure> relatedFigures = new ArrayList<>();
    private LocalDate birthDate, dieDate;
}
