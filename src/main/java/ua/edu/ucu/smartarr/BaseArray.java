package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] elements;
    private int size;

    public BaseArray(Object[] els) {
        elements = els.clone();
        size = els.length;
    }

    @Override
    public Object[] toArray() {
        return elements.clone();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String operationDescription() {
        return "Base Array";
    }
}
