package org.moskalev.AaDS.HW.firstHW;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private long size;
    private List<T> values;
    private T top;

    //constructor
    public Stack() {
        this.size = 0;
        this.top = null;
        values = new ArrayList<>();
    }

    public void push(T elem) {
        values.add(elem);
        top = elem;
        size++;
    }

    public T pop() throws IndexOutOfBoundsException {
        try {
            size--;
            if (size == 0) {
                var lastTop = values.get(0);
                values.remove(0);
                return lastTop;
            } else {
                var lastTop = values.get(values.size() - 1);
                values.remove(values.size() - 1);
                top = values.get(values.size() - 1);
                return lastTop;
            }
        } catch (IndexOutOfBoundsException e) {
            return (T) "Stack is empty, you cannot pop elem from it\n";
        }
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public long getSize() {
        return size;
    }

    public T getTop() {
        return top;
    }

    @Override
    public String toString() {
        if (!isEmpty()) {
            String outStr = "";
            for (int i = values.size() - 1; i >= 0; i--) {
                outStr += "[" + values.get(i) + "]\n";
            }
            return outStr;
        } else {
            return "Stack is empty\n";
        }
    }
}
