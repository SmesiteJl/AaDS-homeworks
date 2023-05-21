package org.moskalev.AaDS.HW.firstHW;

public class QueueByTwoStacks<T> {
    private Stack<T> in;
    private Stack<T> out;
    private T top;
    private long size;
    public QueueByTwoStacks (){
        this.in = new Stack<>();
        this.out = new Stack<>();
        this.size = 0;
    }
    public void offer (T elem){
        size++;
        in.push(elem);
        if (size == 1) {
            top = elem;
        }
    }
    public T poll(){

        size--;
        if(out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        T toUser = out.pop();
        top = out.getTop();
        return toUser;
    }

    public T getTop() {
        return top;
    }

    public long getSize(){
        return size;
    }
    @Override
    public String toString (){
        if (!in.isEmpty()){
            return in.toString();
        }
        else {
            return out.toString();
        }
    }

}
