package dataStructures;

public class CircularFixedArrayQueue {
    int[] queue;
    int head;
    int tail;
    int size;
    int maxLength;

    public CircularFixedArrayQueue(int k) {
        queue = new int[k];
        head = 0;
        tail = -1;
        size = 0;
        maxLength = k;
    }

    public boolean enQueue(int value) {
        if (size == maxLength){
            return false;
        }

        tail++;

        if (tail == maxLength){
            tail = 0;
        }

        queue[tail] = value;
        size++;

        return true;
    }

    public boolean deQueue() {
        if (size == 0){
            return false;
        }

        head++;

        if (head == maxLength){
            head = 0;
        }

        size--;

        return true;
    }

    public int Front() {
        if (size==0){
            return -1;
        }
        return queue[head];
    }

    public int Rear() {
        if (size==0){
            return -1;
        }
        return queue[tail];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size == maxLength;
    }



    public static void main(String[] args) {
        CircularFixedArrayQueue circularQueue = new CircularFixedArrayQueue(3);
        System.out.println(circularQueue.enQueue(1)); // return True
        System.out.println(circularQueue.enQueue(2)); // return True
        System.out.println(circularQueue.enQueue(3)); // return True
        System.out.println(circularQueue.enQueue(4)); // return False
        System.out.println(circularQueue.Rear());     // return 3
        System.out.println(circularQueue.isFull());   // return True
        System.out.println(circularQueue.deQueue());  // return True
        System.out.println(circularQueue.enQueue(4)); // return True
        System.out.println(circularQueue.Rear());     // return 4
        System.out.println(circularQueue.Front());    // return 2
        System.out.println(circularQueue.isEmpty());    // return false
    }
}
