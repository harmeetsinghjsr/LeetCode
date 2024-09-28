//Leetcode Problem 641. Design Circular Deque
public class DesignCircularDeque {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public DesignCircularDeque(int k) {
        arr = new int[k];
        front = 0;
        rear = 0;
        size = 0;
        capacity = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(size == capacity){
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size == capacity){
            return false;
        }
        arr[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size == 0){
            return false;
        }
        front = (front + 1) % capacity;
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size == 0){
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(size == 0){
            return -1;
        }
        return arr[front];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(size == 0){
            return -1;
        }
        return arr[(rear - 1 + capacity) % capacity];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        DesignCircularDeque obj = new DesignCircularDeque(3);
        System.out.println(obj.insertFront(1));
        System.out.println(obj.insertLast(2));
        System.out.println(obj.insertFront(3));
        System.out.println(obj.insertLast(4));
        System.out.println(obj.getFront());
        System.out.println(obj.getRear());
        System.out.println(obj.deleteFront());
        System.out.println(obj.deleteLast());
        System.out.println(obj.isEmpty());
        System.out.println(obj.isFull());
    }
}