import java.util.Scanner;
import java.util.Stack;

public class stack {

    public static void main(String[] args) {
        int numberCount = 0;
        String push = "push";
        String pop = "pop";
        String size = "size";
        String empty = "empty";
        String top = "top";

        Scanner sc = new Scanner(System.in);
        numberCount = sc.nextInt();
        sc.nextLine();

        Stack<Integer> stack = new Stack<Integer>();

        while (numberCount > 0) {

            String order = sc.nextLine();


            if (order.equals(top)) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                    numberCount--;
                    continue;
                }
                int topNumber = stack.peek();
                System.out.println(topNumber);

            } else if (order.equals(size)) {
                int sizeNumber = stack.size();
                System.out.println(sizeNumber);

            } else if (order.equals(empty)) {
                int isEmptyNumber = stack.isEmpty() ? 1 : 0;
                System.out.println(isEmptyNumber);

            } else if (order.equals(pop)) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                    numberCount--;
                    continue;
                }
                int popNumber = stack.pop();
                System.out.println(popNumber);

            } else if (order.substring(0,4).equals(push)) {
                int number = Integer.parseInt(order.substring(5));
                stack.push(number);
            }

            numberCount--;
        }

        sc.close();
    }
}
