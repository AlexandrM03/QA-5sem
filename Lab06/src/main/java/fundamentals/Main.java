package fundamentals;

import java.util.Scanner;

public class Main {
    static void setMonth(int a) {
        String[] month = {"январь", "феваль", "март", "апрель", "май", "июнь",
                "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
        String s;
        try {
            s = month[a - 1];
            System.out.println("Месяц - " + s + ".");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Такого месяца не существует");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello, " + in.nextLine());

        StringBuilder toll = new StringBuilder(in.nextLine());
        toll.reverse();
        System.out.println("Reverse: " + toll);

        for (int i = 0; i < 5; i++) {
            int random_number1 = 1 + (int) (Math.random() * 50);
            System.out.print(random_number1 + " ");
        }
        System.out.println();

        int x = in.nextInt();
        int y = in.nextInt();
        System.out.println("Sum = " + (x + y));
        System.out.println("Multiply = " + (x * y));

        int number = in.nextInt();
        setMonth(number);
    }
}
