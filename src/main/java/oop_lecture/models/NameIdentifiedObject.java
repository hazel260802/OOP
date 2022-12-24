package oop_lecture.models;

import java.util.Comparator;

public abstract class NameIdentifiedObject implements Comparable<NameIdentifiedObject> {
    private String name;

    public String getName() {return this.name;}

    public NameIdentifiedObject (String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof NameIdentifiedObject)
            return this.compareTo((NameIdentifiedObject) o) == 0;
        return false;
    }

    @Override
    public int compareTo(NameIdentifiedObject o) {
        return Comparator.comparing(NameIdentifiedObject::getName).compare(this, o);
    }
}
