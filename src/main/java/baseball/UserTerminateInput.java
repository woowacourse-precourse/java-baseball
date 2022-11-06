package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserTerminateInput {
    private Integer input;

    protected UserTerminateInput(){
        this.input = processTerminate();
    }

    protected Integer getUserTerminate(){
        return this.input;
    }

    protected Integer processTerminate(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString = Console.readLine();

        Integer inputInteger = Integer.parseInt(inputString);
        return inputInteger;
    }


}