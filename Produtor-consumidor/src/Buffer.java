import java.nio.BufferUnderflowException;
import java.util.LinkedList;
import java.util.Queue;

public class Buffer{
    private Queue<Integer> buffer = new LinkedList<Integer>();
    private int size = 0;

    public Buffer(int size) {
        this.size = size;
    }
    public void add(Integer element) throws BufferOverflow{
        if (this.buffer.size()< this.size) {
            this.buffer.add(element);
        }else{
            throw new BufferOverflow();
        }
    }
    
    public Integer extract() throws BufferUnderflowException{
        if (!this.buffer.isEmpty()) {
            return this.buffer.poll();
        }else{
            throw new BufferUnderflowException();                                                                                 
        }
    }
    
    public boolean isEmpty () {
        return this.buffer.isEmpty();
    }
    
    public  boolean isFull(){
        return (this.buffer.size() == this.size);
    }
}