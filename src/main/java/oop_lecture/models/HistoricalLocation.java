package oop_lecture.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HistoricalLocation extends NameIdentifiedObject {
    private Place place;
    private String type;
    private String level;
    private boolean isWorldHeritage;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private HistoricalEvent historicalEvent;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private HistoricalReign historicalReign;

    public HistoricalLocation(String name) {
        super(name);
    }
}
