package oop_lecture.models;

import java.util.Comparator;

public abstract class NameIdentifiedObject implements Comparable<NameIdentifiedObject> {
    public static Comparator<NameIdentifiedObject> COMPARE_BY_NAME = (t0, t1) -> Comparator.comparing(NameIdentifiedObject::getName).compare(t0,t1);

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
        return COMPARE_BY_NAME.compare(this, o);
    }
}
