package baseball.service;

import baseball.participant.Batter;
import baseball.participant.Emcee;
import baseball.participant.Pitcher;
import baseball.participant.Referee;
import baseball.result.Result;
import baseball.result.ResultType;

public class BaseballGameConsole {

    private final Referee referee = new Referee();
    private final Batter batter = new Batter();
    private final Emcee emcee = new Emcee();

    public void startWithPitcher(Pitcher pitcher) {
        emcee.showStartingGuide(pitcher.getName());

        boolean replay = true;
        while (replay) {
            playSingleGame(pitcher);
            replay = askReplaying(pitcher);
        }

        emcee.showEndingGuide();
    }

    private void playSingleGame(Pitcher pitcher) {
        String hitNumber = batter.readyToHitNumberBall();
        
        boolean strikeOut = false;
        while (!strikeOut) {
            System.out.print("숫자를 입력해주세요. : ");
            String pitchNumber = pitcher.pitchNumberBall();
            Result result = referee.judgeHitAndPitch(hitNumber, pitchNumber);
            strikeOut = result.getResultType() == ResultType.EXACT_MATCH;
            emcee.showResultMessage(result.getResultType(), result.numberOfBall(), result.numberOfStrike());
        }
    }

    private boolean askReplaying(Pitcher pitcher) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String replay = pitcher.willReplay();
        referee.validateReplaySelection(replay);
        return replay.equals("1");
    }
}
