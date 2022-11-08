package baseball;

import java.util.Scanner;

public class BaseballGame {

    private View view;
    private final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public void GameStart(){

        String userInput = view.userRequestNumber();
    }
}
