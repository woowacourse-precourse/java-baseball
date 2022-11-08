package baseball.view;

import baseball.domain.Game;
import camp.nextstep.edu.missionutils.Console;

import static baseball.exception.InputException.isValidRestartOrStop;

public class OutputView {
    public static String gameResult(int ball, int strike){
        if(strike + ball == 0){
            return "낫싱";
        }

        if(strike == 0){
            return ball + "볼";
        }

        if(ball == 0){
            return strike + "스트라이크";
        }

        return ball + "볼 " + strike + "스트라이크";
    }

    public static boolean gameRestartOrStop(String result){
        if(!result.equals("3스트라이크")) return false;

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();

        if(!isValidRestartOrStop(input)){
            throw new IllegalArgumentException();
        }

        int restartOrStop = Integer.parseInt(input);

        if(restartOrStop == 1){
            Game baseballGame = new Game();
            baseballGame.startGame();
        }

        return true;
    }
}
