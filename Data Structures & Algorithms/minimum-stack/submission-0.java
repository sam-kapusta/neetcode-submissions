class MinStack {

    Stack<int[]> stack;

    public MinStack() {
    
        //deque or stack for push/pop

        //the top element of queue will always tell u the min value at that time, bc u can only push/pop

        this.stack = new Stack<int[]>();
    }
    
    public void push(int val) {
        


        int min = stack.isEmpty() ? val : Math.min(val, stack.peek()[1]);

        this.stack.push(new int[]{val, min});
    }
    
    public void pop() {
        
        this.stack.pop();
    }
    
    public int top() {
        if(stack.isEmpty()) return -1;
        return this.stack.peek()[0];
    }
    
    public int getMin() {
        return this.stack.peek()[1];
    }
}
