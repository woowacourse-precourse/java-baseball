package baseball;

import java.util.List;


public class BaseballGame {

    private static boolean end = false;
    private final GameService gameService = new GameService();

    public void gameStart(){

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNumber = Number.getRandomNumber();

        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> userNumber = Number.inputUserNumber();

            gameService.countStrike(randomNumber, userNumber);
            gameService.countBall(randomNumber, userNumber);
            boolean isAnswer = gameService.printResult();
            if (isAnswer) {
                end = gameService.checkRestart();
                randomNumber = Number.getRandomNumber();
            }
        }
    }
}
