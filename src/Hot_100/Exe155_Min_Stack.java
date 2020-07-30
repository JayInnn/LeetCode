package Hot_100;

import java.util.LinkedList;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2020/7/30
 * @description:
 * @result:
 */
public class Exe155_Min_Stack {

    private LinkedList<Integer> stack = new LinkedList<>();

    public Exe155_Min_Stack(){

    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.addLast(x);
            stack.addLast(x);
        }else {
            int tmp = stack.getLast();
            stack.addLast(x);
            if (tmp < x){
                stack.addLast(tmp);
            }else {
                stack.addLast(x);
            }
        }
    }

    public void pop() {
        stack.removeLast();
        stack.removeLast();
    }

    public int top() {
        return stack.get(stack.size() - 2);
    }

    public int getMin() {
        return stack.getLast();
    }

    public static void main(String[] args){
        Exe155_Min_Stack minStack = new Exe155_Min_Stack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int a = minStack.getMin();
        minStack.pop();
        int b = minStack.top();
        int c = minStack.getMin();
        System.out.println(a + b + c);
    }
}
