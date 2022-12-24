package oop_lecture.models;

public class HistoricalLocation extends NameIdentifiedObject {
    private Place place;
    private String type;
    private String level;
    private boolean isWorldHeritage;
    private HistoricalEvent historicalEvent;
    private HistoricalReign historicalReign;

    public HistoricalLocation(String name) {
        super(name);
    }
}
