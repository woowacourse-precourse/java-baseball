package baseball.controller;


import baseball.service.GameStartService;


public class GameStartController {
    private static void controlGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = GameStartService.getUserInput();
        if(userInput.equals("1")){
            GameStartService.initGame();
            startGame();
        }else{
            finishGame();
        }
    }

    private static void finishGame() {
        System.out.println("게임 종료");
    }

    public static void startFirstGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    private static void startGame() {
        GameStartService.initBallAndStrike();
        System.out.print("숫자를 입력해주세요 : ");
        saveNumber();
        compareNumber();
    }

    private static void compareNumber() {
        String HINT = GameStartService.compareNumber();
        showHint(HINT);
    }

    private static void showHint(String hint) {
        System.out.println(hint);
        if(hint.equals("3스트라이크")){
            System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
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


