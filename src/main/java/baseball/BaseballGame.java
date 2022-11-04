package baseball;

import java.util.List;


public class BaseballGame {

    private static final boolean end = false;
    private final GameService gameService = new GameService();

    public void gameStart(){

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNumber = Number.getRandomNumber();

        while(!end){
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> userNumber = Number.inputUserNumber();

            Integer strike = gameService.countStrike(randomNumber, userNumber);
            Integer ball = gameService.countBall(randomNumber, userNumber);
            boolean isAnswer = gameService.printResult(strike, ball);
        }
    }
}
