package control;

import baseball.GenerateRandomNumber;
import baseball.InputUserNumber;
import baseball.PlayAgainResult;
import baseball.StrikeBallNothingResultGenerator;
import java.util.List;

public class ControlGameStarter {

    public void Game(){

        GenerateRandomNumber computerRandomnumber = new GenerateRandomNumber();

        InputUserNumber userInputNumber = new InputUserNumber();

        StrikeBallNothingResultGenerator Result = new StrikeBallNothingResultGenerator();

        PlayAgainResult playAgain = new PlayAgainResult();

        boolean restart = true;

        while (restart) {
            List<Integer> computer = computerRandomnumber.NumberCreate();
            String result = "";
            System.out.println("숫자 야구 게임을 시작합니다.");
            while (!result.equals("3스트라이크")) {
                result = Result.ResultJudgement(computer, userInputNumber.playerNumber());
                System.out.println(result);
            }
            restart = playAgain.restartIsOkay();
        }

    }
}
