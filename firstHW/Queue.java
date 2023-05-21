package org.moskalev.AaDS.HW.firstHW;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    private T first;
    private T last;
    private List queueValues;
    public Queue (){
        this.first = null;
        this.last = null;
        this.queueValues = new ArrayList<T>();
    }
    private void firstandLastidentifier(){
        first = (T) queueValues.get(0);
        last = (T) queueValues.get(queueValues.size()-1);
    }
    public boolean isEmpty (){
         return queueValues.isEmpty();
    }
    public void offer(T elem){
        queueValues.add(elem);
        firstandLastidentifier();
    }
    public T poll(){
       T elem = first;
       queueValues.remove(0);
       firstandLastidentifier();
       return elem;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }
    @Override
    public String toString() {
        if (!isEmpty()) {
            String outstr = "[";
            for (int i = 0; i < queueValues.size()-1; i++) {
                outstr += queueValues.get(i) + ",";
            }
            outstr += queueValues.get(queueValues.size()-1);
            outstr += "]";
            return outstr;
        }
        else{
            return "Queue is empty";
        }
    }
}
