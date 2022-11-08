package baseball;

import camp.nextstep.edu.missionutils.Console;

public class View {
    private String s;

    public void printLine(String s){
        try {
            System.out.printf(s);
        }
        catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }

    public void inputInt(){
        try{
            int number;
            System.out.print("숫자를 입력해주세요 : ");
            number = Integer.parseInt(Console.readLine());
        }
        catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }
}
