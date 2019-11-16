package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    MyFunction myFunction;
    private Object[] arr;
    int size;

    public MapDecorator(SmartArray smartArray, MyFunction func){
        super(smartArray);
        size = smartArray.size();
        myFunction = func;
        arr = map(smartArray.toArray());
    }

    private Object[] map(Object[] array) {
        for (int i = 0; i < size; i++) {
            array[i] = myFunction.apply(array[i]);
        }

        return array;
    }

    @Override
    public Object[] toArray() {
        return arr;
    }
    
    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + " applied function" + myFunction.operationDescription();
    }

    @Override
    public int size() {
        return size;
    }
}
