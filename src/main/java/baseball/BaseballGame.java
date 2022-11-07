package baseball;

import java.util.List;


public class BaseballGame {

    private static boolean end;
    private final GameService gameService = new GameService();

    public void gameStart(){

        end = false;
        Number makeNumber = new Number();
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNumber = makeNumber.getRandomNumber();

        while(!end){
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> userNumber = makeNumber.inputUserNumber();

            Integer strike = gameService.countStrike(randomNumber, userNumber);
            gameService.countBall(randomNumber, userNumber);
            gameService.printResult();
            if (strike == 3) {
                end = gameService.checkRestart();
                if (end == false) {
                    randomNumber = makeNumber.getRandomNumber();
                }
            }
        }
    }
}
