package baseball.controller;


import baseball.service.GameStartService;
import baseball.status.GameStatus;
import baseball.status.HintStatus;


public class GameStartController {
    private static void controlGame() {
        System.out.println(GameStatus.RESTART_OR_STOP_GAME.getText());
        String userInput = GameStartService.getUserInput();
        if(userInput.equals("1")){
            GameStartService.initGame();
            startGame();
        }else{
            finishGame();
        }
    }

    private static void finishGame() {
        System.out.println(GameStatus.END_GAME.getText());
    }

    public static void startFirstGame(){
        System.out.println(GameStatus.START_GAME.getText());
        startGame();
    }

    private static void startGame() {
        GameStartService.initBallAndStrike();
        System.out.print(GameStatus.INPUT_USER_NUMBER.getText());
        saveNumber();
        compareNumber();
    }

    private static void compareNumber() {
        String HINT = GameStartService.compareNumber();
        showHint(HINT);
    }

    private static void showHint(String hint) {
        System.out.println(hint);
        if(hint.equals(HintStatus.ANSWER.getText())){
            System.out.println(GameStatus.SUCCESS_GAME.getText());
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


