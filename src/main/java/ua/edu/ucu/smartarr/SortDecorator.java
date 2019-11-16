package ua.edu.ucu.smartarr;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    protected MyComparator comparator;
    private Object[] arr;
    int size;

    public SortDecorator(SmartArray smartArray, MyComparator comp) {
        super(smartArray);
        comparator = comp;
        arr = smartArray.toArray();
        Arrays.sort(smartArray.toArray(), comparator);
    }

    @Override
    public Object[] toArray() {
        return arr;
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + " Sorted";
    }

    @Override
    public int size() {
        return smartArray.size();
    }

}
