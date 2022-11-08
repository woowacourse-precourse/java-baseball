package baseball;

import java.util.Scanner;

public class BaseballGame {

    private View view;

    public void GameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        String userInput = view.userRequestNumber();
    }
}
