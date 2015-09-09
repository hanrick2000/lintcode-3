public class ImplementQueueByTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Solution() {
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }

    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int element = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return element;
    }

    public int top() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int element = stack2.peek();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return element;
    }
}

