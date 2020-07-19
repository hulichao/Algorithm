package practice;

import java.util.Stack;

/**
 * Created by hulichao on 2018/9/15
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println(2 + ((3-1) >> 1)); //移位优先级比+优先级低
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        stack.pop();
        System.out.println(stack.peek());

    }
}
