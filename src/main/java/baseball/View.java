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

    public String inputInt() {
        String s;
        try {
            // 형변환 check
            s = Console.readLine();
            Integer.parseInt(s);
            return s;
        } catch (IllegalArgumentException e) {
            return String.valueOf(e);
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
