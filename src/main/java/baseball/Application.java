package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
    }

    static class Console {
        public static void newGame() {
            Scanner console_input = new Scanner(System.in);
            int a = console_input.nextInt();
            System.out.println(a);
        }
    }
}
