package baseball.config;

import baseball.controller.PlayGameController;
public class Config {
    public static PlayGameController playGameController(){
        return new PlayGameController();
    }
}
