package baseball.service;

import baseball.participant.Batter;
import baseball.participant.Emcee;
import baseball.participant.Pitcher;
import baseball.participant.Referee;
import baseball.result.Result;
import camp.nextstep.edu.missionutils.Console;

import static baseball.result.ResultType.*;

public class BaseballGameConsole {

    private final Validator validator = new Validator();
    private final Batter batter = new Batter();
    private final Referee referee = new Referee();
    private final Emcee emcee = new Emcee();

    public void startWithPitcher(Pitcher pitcher) {
        emcee.showStartingGuide(pitcher.getName());
        do {
            playSingleGame(pitcher);
        } while (askReplaying());
    }

    private void playSingleGame(Pitcher pitcher) {
        boolean matchedAllNumber = false;
        String randomNumber = batter.selectRandomNumber();

        do {
            System.out.print("숫자를 입력해주세요. : ");
            String predictedNumber = pitcher.predictNumber();
            validator.validatePrediction(predictedNumber);

            Result result = referee.resultOfPrediction(randomNumber, predictedNumber);
            matchedAllNumber = result.getResultType() == EXACT_MATCH;

            emcee.showResultMessage(result.getResultType(), result.numberOfBall(), result.numberOfStrike());
        } while (!matchedAllNumber);
    }

    private boolean askReplaying() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String replay = Console.readLine();
        validator.validateReplaySelection(replay);
        return replay.equals("1");
    }
}
