package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{
    MyPredicate predicate;
    private Object[] arr;
    int size;

    public FilterDecorator(SmartArray smartArray, MyPredicate pred){
        super(smartArray);
        predicate = pred;
        arr = filter(smartArray.toArray());
        size = arr.length;
    }

    private Object[] filter(Object[] arr) {
        int filteredObjects = 0;
        int j = 0;
        int len = smartArray.size();

        for (int i = 0; i < len; i++) {
            if (predicate.test(arr[i])) {
                filteredObjects++;
            } else {
                arr[i] = null;
            }
        }

        Object[] newArray = new Object[filteredObjects];
        
        for (int i = 0; i < len; i++) {
            if (arr[i] != null) {
                newArray[j] = arr[i];
                j++;
            }
        }

        return newArray;
    }

    @Override
    public Object[] toArray() {
        return arr;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + " fileterd with predicate" + predicate.operationDescription();
    }
   
}
