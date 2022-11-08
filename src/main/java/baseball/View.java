package baseball;

import camp.nextstep.edu.missionutils.Console;

public class View {
    private String s;

    public void printLine(String s) {
        try {
            System.out.print(s);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public int inputInt() {
        int number;
        try {
            number = Integer.parseInt(Console.readLine());
            return number;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return -1;
        }
    }

    public void printResult(int check, int number) {
        try {
            if (check == 0) {
                System.out.println("낫싱");
            } else if (check == 1) {
                System.out.print(number + "볼");
            } else if (check == 2) {
                System.out.print(number + "스트라이크");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
