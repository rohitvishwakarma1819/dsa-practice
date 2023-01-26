public class Queue {

    int[] arr;
    int left = 0;
    int right = 0;
    Queue() {
        // Implement the Constructor
        arr = new int[5001];
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        // Implement the isEmpty() function
        return left == 0 && right == 0;
    }

    void enqueue(int data) {
        // Implement the enqueue() function
        arr[right++] = data;
    }

    int dequeue() {
        // Implement the dequeue() function
        if(isEmpty()) return -1;
        int data = arr[left++];
        if(left == right)
            left = right = 0;
        return data;
    }

    int front() {
        // Implement the front() function
        if(isEmpty()) return -1;
        return arr[left];
    }

}
