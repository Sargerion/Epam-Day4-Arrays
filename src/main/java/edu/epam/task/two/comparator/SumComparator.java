package edu.epam.task.two.comparator;

import edu.epam.task.one.entity.WrapperArray;
import edu.epam.task.two.service.FindJaggedArrayService;

import java.util.Comparator;

public class SumComparator implements Comparator<WrapperArray> {

    @Override
    public int compare(WrapperArray o1, WrapperArray o2) {
        FindJaggedArrayService service = new FindJaggedArrayService();
        int rowSumO1 = service.findSumOfRow(o1);
        int rowSumO2 = service.findSumOfRow(o2);
        return rowSumO1 - rowSumO2;
    }
}
