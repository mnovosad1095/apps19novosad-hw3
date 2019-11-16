package ua.edu.ucu.smartarr;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    protected MyComparator comparator;
    private Object[] arr;

    public SortDecorator(SmartArray smartArray, MyComparator comp) {
        super(smartArray);
        comparator = comp;
        arr = smartArray.toArray();
        Arrays.sort(arr, comparator);
    }

    @Override
    public Object[] toArray() {
        return arr.clone();
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
