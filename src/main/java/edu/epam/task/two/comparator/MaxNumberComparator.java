package edu.epam.task.two.comparator;

import edu.epam.task.one.entity.WrapperArray;
import edu.epam.task.two.service.FindJaggedArrayService;

import java.util.Comparator;

public class MaxNumberComparator implements Comparator<WrapperArray> {

    @Override
    public int compare(WrapperArray o1, WrapperArray o2) {
        FindJaggedArrayService service = new FindJaggedArrayService();
        int maxItemInO1 = service.findMaxRowItem(o1);
        int maxItemInO2 = service.findMaxRowItem(o2);
        return maxItemInO1 - maxItemInO2;
    }
}
