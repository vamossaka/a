// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import synthesizer.AbstractBoundedQueue;

import java.util.ArrayDeque;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>{
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so//       you'll need to use this.capacity to set the capacity.
       this.first=0;
       this.last=0;
       this.fillCount=0;
       this.rb=(T[]) new Object[capacity];
       this.capacity=capacity;


    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
       if(isFull())
       {
           throw new RuntimeException("Ring Buffer Overflow");
       }
        rb[last]=x;
       fillCount++;
       last=(last+1)%capacity;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update 
      if(isEmpty())
          throw new RuntimeException("Ring Buffer Underflow");
      T ret=rb[first];
      fillCount--;
      first=(first+1)%capacity;
      return ret;

    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if(isEmpty())
            throw new RuntimeException("Ring Buffer Underflow");
        T tar=rb[first];
        return tar;
    }
    private class ArrayRingBufferiterator implements Iterator<T>{
        private int pos;
        private int curnum;
        public ArrayRingBufferiterator(){
            pos=first;
            curnum=0;
        }
        public boolean hasNext(){
           return curnum<fillCount;
        }
        public T next(){
            T ret=rb[pos];
            pos=(pos+1)%capacity;
            curnum++;
            return ret;
        }
    }
    @Override
    public Iterator<T> iterator(){
        return new ArrayRingBufferiterator();
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
}
