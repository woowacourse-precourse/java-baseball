package baseball.controller;

import baseball.service.GameService;
import baseball.view.Requester;
import baseball.view.Respondent;
import camp.nextstep.edu.missionutils.Console;

public class Controller {

    final int SIZE = 3;
    final int START_NUM = 1;
    final int END_NUM = 9;
    final int RETRY = 1;
    final int FINISH = 2;

    GameService service = new GameService();

    public void run() {
        setGame();
        playGame();
        endGame();
        askRetry();
    }

    private void setGame() {
        service.setGame(SIZE, START_NUM, END_NUM);
    }

    private void playGame() {
        service.playGame();
    }

    private void endGame() {
        Respondent.respondGameOver();
    }

    private void askRetry() throws IllegalArgumentException {
        Requester.requestRetryOrFinish();
        if(isRetry() == RETRY){
            run();
        }
    }

    private int isRetry() throws IllegalArgumentException{
        int input = Integer.parseInt(Console.readLine());

        if(input == 0 || input > FINISH){
            throw new IllegalArgumentException();
        }
        return input;
    }
}
