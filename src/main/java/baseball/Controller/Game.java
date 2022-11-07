package baseball.Controller;

import baseball.View.Print;

public class Game {
    private final Print print = new Print();
    public Game(){
        print.gameStart();
    }
}
