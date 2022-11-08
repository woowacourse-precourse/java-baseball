package baseball.controller;

import baseball.view.ControlView;
import baseball.view.IntroView;
import baseball.view.PlayView;
import baseball.view.view;

public class GameController {
    public view intro() {
        return new IntroView();
    }

    public view play() {
        return new PlayView();
    }

    public view control() {
        return new ControlView();
    }


}
