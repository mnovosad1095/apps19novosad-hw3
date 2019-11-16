package ua.edu.ucu.smartarr;

import java.util.ArrayList;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predicate;
    private Object[] arr;
    private int size;

    public FilterDecorator(SmartArray smartArray, MyPredicate pred) {
        super(smartArray);
        predicate = pred;
        arr = filter(smartArray.toArray());
        size = arr.length;
    }

    private Object[] filter(Object[] array) {
        int len = array.length;
        ArrayList<Object> newArray = new ArrayList<Object>();

        for (int i = 0; i < len; i++) {
            if (predicate.test(array[i])) {
                newArray.add(array[i]);
            }
        }

        return newArray.toArray();
    }

    @Override
    public Object[] toArray() {
        return arr.clone();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() +
         " fileterd with predicate" + 
         predicate.operationDescription();
    }
   
}
