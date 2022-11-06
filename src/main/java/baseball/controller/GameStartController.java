package baseball.controller;


import baseball.service.GameStartService;
import baseball.status.GameStatus;
import baseball.status.HintStatus;
import baseball.view.View;


public class GameStartController {
    private static void controlGame() {
        View.printRestartOrStop();
        String userInput = GameStartService.getUserInput();
        if(userInput.equals("1")){
            GameStartService.initGame();
            startGame();
        }else if(userInput.equals("2")){
            finishGame();
        }else{
            throw new IllegalArgumentException();
        }
    }

    private static void finishGame() {
        View.printFinishGame();
    }

    public static void startFirstGame(){
        View.printStartGame();
        startGame();
    }

    private static void startGame() {
        GameStartService.initBallAndStrike();
        View.printInputUserNumber();
        saveNumber();
        compareNumber();
    }

    private static void compareNumber() {
        String HINT = GameStartService.compareNumber();
        showHint(HINT);
    }

    private static void showHint(String hint) {
        View.printHint(hint);
        if(hint.equals(HintStatus.ANSWER.getText())){
            View.printCompleteGame();
            controlGame();
        }else{
            startGame();
        }
    }

    private static void saveNumber() {
        saveComputerNumber();
        saveUserNumber();
    }

    private static void saveUserNumber() {
        GameStartService.saveUserNumber();
    }

    private static void saveComputerNumber() {
        GameStartService.saveComputerNumber();
    }
}


