import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack;
    private Stack<Integer> tempStack;

    public MyQueue() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }
    public int pop() {
        if(tempStack.isEmpty()) {
            while(!stack.isEmpty()) {
                tempStack.push(stack.pop());
            }
        }
        return tempStack.pop();
    }
    public int peek() {
        if(!tempStack.isEmpty()) {
            return tempStack.peek();
        }
        return stack.elementAt(0);
    }
    public int size() {
        return stack.size() + tempStack.size();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.size());
        System.out.println(myQueue.pop());
    }
}
