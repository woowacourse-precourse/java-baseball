package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class UserTerminateInput {

    public String processTerminate(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString = Console.readLine();
        return inputString;
    }

    public boolean permitTerminate(Integer terminateValue){
        if(terminateValue.equals(2)){
            System.out.println("게임 종료");
            return true;
        } else{
            return false;
        }
    }

}