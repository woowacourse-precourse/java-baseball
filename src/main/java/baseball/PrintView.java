package baseball;

import camp.nextstep.edu.missionutils.Console;

public class PrintView {
    public boolean isExit() throws IllegalArgumentException{
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input=Console.readLine();
        if(input.equals("1")) return false;
        if(input.equals("2")) return true;
        throw new IllegalArgumentException();
    }
    public void printInput(){
        System.out.printf("숫자를 입력해주세요 : ");
    }
    public void printEndGame(){
        System.out.println("게임 종료");
    }

}
