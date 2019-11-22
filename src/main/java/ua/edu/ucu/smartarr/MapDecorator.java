package ua.edu.ucu.smartarr;

import java.util.Arrays;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction myFunction;
    private Object[] arr;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        myFunction = func;
        arr = Arrays.stream(smartArray.toArray()).map(func::apply).toArray();
    }

    @Override
    public Object[] toArray() {
        return Arrays.stream(smartArray.toArray()).map(myFunction::apply).toArray().clone();
    }
    
    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + 
        " applied function" + 
        myFunction.operationDescription();
    }

    @Override
    public int size() {
        return arr.length;
    }
}
