package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] elements;

    public BaseArray(Object[] els) {
        elements = els.clone();
    }

    @Override
    public Object[] toArray() {
        return elements.clone();
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public String operationDescription() {
        return "Base Array";
    }

    public void setValue(int index){elements[index] = 0;};
}
