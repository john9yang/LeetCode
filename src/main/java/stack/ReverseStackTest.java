package stack;

import java.util.Stack;

public class ReverseStackTest {
    /**
     * 方法功能: 把栈底元素移动到栈顶
     */
    private static void moveBottomToTop(Stack<Integer> s){
        if ( s.empty() )
            return;

        int top1 = s.peek();
        s.pop(); //弹出栈顶元素
        if ( !s.empty() ){
            //递归处理不包含栈顶元素的子栈
            moveBottomToTop(s);
            int top2 = s.peek();
            s.pop();
            //交换栈顶元素与子栈栈顶元素
            s.push(top1);
            s.push(top2);
        }
        else{
            s.push(top1);
        }
    }

    public static void reverseStack(Stack<Integer> s){
        if ( s.empty() )
            return;
        //把栈底元素
        moveBottomToTop(s);
        int top = s.peek();
        s.pop();
        //递归处理子栈
        reverseStack(s);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);

        reverseStack(s);
        printStack(s);
    }

    private static void printStack(Stack<Integer> s){
        while( !s.empty() ){
            System.out.print(s.peek()+ " ");
            s.pop();
        }
    }
}
