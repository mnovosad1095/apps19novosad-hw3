package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    private Object[] arr;
    private ArrayList<Object> dist;

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        removeDuplicates();
    }

    @Override
    public Object[] toArray() {
        removeDuplicates();
        return arr.clone();
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + " removed duplicates";
    }

    @Override
    public int size() {
        return arr.length;
    }

    private void removeDuplicates() {
        arr = Arrays.asList(arr).stream().filter(this::contains).toArray();
        dist.clear();
    }

    private boolean contains(Object obj) {
        if (dist.contains(obj)) return false;
        else dist.add(obj);
        return true;
    }
}
