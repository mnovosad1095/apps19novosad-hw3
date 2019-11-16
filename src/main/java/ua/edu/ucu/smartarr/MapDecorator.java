package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction myFunction;
    private Object[] arr;
    private int size;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        size = smartArray.size();
        myFunction = func;
        arr = smartArray.toArray();
        map(arr);
    }

    private void map(Object[] array) {
        for (int i = 0; i < size; i++) {
            array[i] = myFunction.apply(array[i]);
        }
    }

    @Override
    public Object[] toArray() {
        return arr.clone();
    }
    
    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + 
        " applied function" + 
        myFunction.operationDescription();
    }

    @Override
    public int size() {
        return size;
    }
}
