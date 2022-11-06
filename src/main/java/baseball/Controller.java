package baseball;

import baseball.utils.PrintMessage;

public class Controller {

    PrintMessage print = new PrintMessage();
    InGame inGame = new InGame();


    public void run() {
        print.gameStartNotice();
        inGame.gameStart();
    }


}
