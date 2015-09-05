public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public Solution() {
        // do initialize if necessary
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty() || minStack.peek() >= number) {
            minStack.push(number);
        }
    }

    public int pop() {
        int pop = stack.pop();
        if (minStack.peek() == pop) {
            minStack.pop();
        }
        return pop;
    }

    public int min() {
        return minStack.peek();
    }
}

