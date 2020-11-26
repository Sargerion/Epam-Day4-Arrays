package edu.epam.task.two.comparator;

import edu.epam.task.one.entity.WrapperArray;
import edu.epam.task.two.service.FindJaggedArrayService;

import java.util.Comparator;

public class MinNumberComparator implements Comparator<WrapperArray> {

    @Override
    public int compare(WrapperArray o1, WrapperArray o2) {
        FindJaggedArrayService service = new FindJaggedArrayService();
        int minItemInO1 = service.findMinRowItem(o1);
        int minItemInO2 = service.findMinRowItem(o2);
        return minItemInO1 - minItemInO2;
    }
}
