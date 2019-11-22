package ua.edu.ucu.smartarr;

import java.util.Arrays;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predicate;
    private Object[] arr;

    public FilterDecorator(SmartArray smartArray, MyPredicate pred) {
        super(smartArray);
        predicate = pred;
        filter();
    }

    private void filter() {
        arr = Arrays.asList(arr).stream().filter(predicate::test).toArray();
    }

    @Override
    public Object[] toArray() {
        filter();
        return arr.clone();
    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() +
         " fileterd with predicate" + 
         predicate.operationDescription();
    }
   
}
