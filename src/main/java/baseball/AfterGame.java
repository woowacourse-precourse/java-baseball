package baseball;

import camp.nextstep.edu.missionutils.Console;

public class AfterGame {
    private static final boolean RESTART = true;
    private static final boolean FINISH = false;
    public void outputQuest(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public String inputRestartOrFinish(){
        return Console.readLine().trim();
    }
    public boolean isRestartOrFinish(String input){
        if(input.equals("1"))return RESTART;
        if(input.equals("2"))return FINISH;
        throw new IllegalArgumentException();
    }
    public boolean play(){
        outputQuest();
        return isRestartOrFinish(inputRestartOrFinish());
    }
}
