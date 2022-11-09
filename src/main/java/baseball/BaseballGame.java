package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;

public class BaseballGame {
    public void start() {
        GameMessage.introMessage();
        do {
            run(Computer.createBaseballNumberList());
        } while(continueGame());
    }
    private void run(List<Integer> baseballNumberList) {
        String input;
        Integer strikeCount;
        Integer ballCount;
        do {
            GameMessage.mainMessage();
            input = Console.readLine();
            Map<String, Integer> count = Referee.createRefereeCount(baseballNumberList, Player.createInputNumberList(input));
            ballCount = count.get(BallStatus.BALL.toString());
            strikeCount = count.get(BallStatus.STRIKE.toString());

            GameMessage.resultMessage(Referee.refereeAnswer(ballCount, strikeCount));
        } while (isClearGame(strikeCount));
    }
    public boolean isClearGame(Integer strikeCount) {
        return strikeCount != 3;
    }
    private boolean continueGame() {
        GameMessage.endMessage();

        String flag = Console.readLine();
        ValidationCode.validateFlag(flag);

        return flag.equals(EndPoint.RE_START.getFlag());
    }
}
