package configuration;

import features.Game;
import features.Hint;
import features.Input;
import features.Player;
import features.Print;

// 역할 관리자 : 의존성 연결을 책임지기, DIP
public class AppConfig{


    public Player createComputerNumber() {
        return new Player();
    }

    public Input inputUserNumber() {
        return new Input();
    }

    public Hint loopHint() {
        return new Hint();
    }

    public Print printResult() {
        return new Print();
    }

    public Game playGame() {
        return new Game(
                new Print());
    }
}
