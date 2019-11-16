package ua.edu.ucu.smartarr;

import java.util.ArrayList;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    private Object[] arr;

    public DistinctDecorator(SmartArray smartArray){
        super(smartArray);
        arr = removeDuplicates(smartArray.toArray());
    }

    @Override
    public Object[] toArray() {
        return arr;
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + " removed duplicates";
    }

    @Override
    public int size() {
        return arr.length;
    }

    private Object[] removeDuplicates(Object[] array) {
        int len = smartArray.size();
        ArrayList<Object> tempArray = new ArrayList<Object>();
        ArrayList<Object> newArray = new ArrayList<Object>();

        for (int i = 0; i < len; i++) {
            if (!tempArray.contains(array[i])) {
                newArray.add(array[i]);
                tempArray.add(array[i]);
            }
        }

        return newArray.toArray();
    }
}
