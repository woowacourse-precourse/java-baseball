package baseball;

import static baseball.view.InputView.printFirstNumberBaseballGameMessage;

import baseball.controller.GameController;
public class Application {


    public static void main(String[] args) {
        printFirstNumberBaseballGameMessage();
        GameController GameController = new GameController();
        GameController.run();
    }








}
