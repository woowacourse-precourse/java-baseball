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
            System.out.println("숫자를 입력해주세요 : ");
            number = Integer.parseInt(Console.readLine());
            return number;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return -1;
        }
    }

    public void printResult(int i) {
        try {
            if(i==-1){
                System.out.println("낫싱");
            } else if (i==1) {
                System.out.print(i + "볼");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
