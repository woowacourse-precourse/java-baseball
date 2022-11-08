package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private String playerNumber;

    public void selectNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        playerNumber = Console.readLine();
    }

    public String getSelectedNumber(){
        return playerNumber;
    }

}
