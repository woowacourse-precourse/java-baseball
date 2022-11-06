package baseball.controller;

import baseball.view.View;

public class BaseballGame {
    private static final View view = new View();

    public BaseballGame(){
    }

    public void startGame(){
        view.initView();
    }
}
