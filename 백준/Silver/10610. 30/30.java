import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack0 = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();
        Stack<Integer> stack5 = new Stack<>();
        Stack<Integer> stack6 = new Stack<>();
        Stack<Integer> stack7 = new Stack<>();
        Stack<Integer> stack8 = new Stack<>();
        Stack<Integer> stack9 = new Stack<>();

        String s = br.readLine();
        int[] array = Stream.of(s.split("")).mapToInt(Integer::parseInt).toArray();

        boolean containZero;
        boolean sumMultipThree;

        containZero = Arrays.stream(array).anyMatch(value -> value == 0);
        sumMultipThree = (Arrays.stream(array).sum() % 3) == 0;


        for (int i = 0; i < array.length; i++) {
            int n = array[i];
            // n은 0~9 사이의 숫자임
            if (n == 0) {
                stack0.push(0);
            } else if (n == 1) {
                stack1.push(1);
            } else if (n == 2) {
                stack2.push(2);
            } else if (n == 3) {
                stack3.push(3);
            } else if (n == 4) {
                stack4.push(4);
            } else if (n == 5) {
                stack5.push(5);
            } else if (n == 6) {
                stack6.push(6);
            } else if (n == 7) {
                stack7.push(7);
            } else if (n == 8) {
                stack8.push(8);
            } else if (n == 9) {
                stack9.push(9);
            }
        }

        if (containZero && sumMultipThree) {
            printStack(stack9);
            printStack(stack8);
            printStack(stack7);
            printStack(stack6);
            printStack(stack5);
            printStack(stack4);
            printStack(stack3);
            printStack(stack2);
            printStack(stack1);
            printStack(stack0);
        } else {
            System.out.print(-1);
        }

    }

    public static void printStack(Stack<Integer> stack) {
        int n = stack.size();
        for (int i = 0; i < n; i++) {
            System.out.print(stack.pop() + "");
        }
    }
}
