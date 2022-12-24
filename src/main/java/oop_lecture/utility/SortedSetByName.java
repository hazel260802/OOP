package oop_lecture.utility;

import oop_lecture.models.HistoricalEvent;
import oop_lecture.models.HistoricalFigure;
import oop_lecture.models.NameIdentifiedObject;

import java.util.*;

public class SortedSetByName<T extends NameIdentifiedObject> extends TreeSet<NameIdentifiedObject> {
    @Override
    public Comparator<? super NameIdentifiedObject> comparator() {
        return Comparator.comparing(NameIdentifiedObject::getName);
    }

    /**
     * This class is for local test purpose only
     * @param args cli args
     */
    public static void main(String[] args) {
        Set<NameIdentifiedObject> s = new SortedSetByName<>();
        s.add(new HistoricalFigure("sthg"));
        s.add(new HistoricalEvent("sthg"));
        System.out.println(s);

        // this part is used in get_data
        SortedSetByName<HistoricalFigure> historicalFigureSet = new SortedSetByName<>();
        while (true){
            // found an HF from internet
            var tmphf = new HistoricalFigure("name");
            historicalFigureSet.add(tmphf);
            if (/*not found anything else*/ false) break;
        }

    }
}
