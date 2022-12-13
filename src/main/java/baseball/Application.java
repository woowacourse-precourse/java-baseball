package baseball;

import static Controller.GameController.GAME_CONTROLLER;
import static Views.OutputView.OUTPUT_VIEW;


public class Application {
    public static void main(String[] args) {
        OUTPUT_VIEW.PrintGameStartMessage();
        GAME_CONTROLLER.SelectGoOrStopGame();
    }


}






















