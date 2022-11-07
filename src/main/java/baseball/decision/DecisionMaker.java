package baseball.decision;

import camp.nextstep.edu.missionutils.Console;

public class DecisionMaker {

    private String wantPlayGame = "1";
    private String wantStopGame = "2";

    private final String informationMessage = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.";

    public Decision getDecision() {
        return acceptOpinion();
    }

    private Decision acceptOpinion() {
        printInformation();
        String opinion = Console.readLine();
        if (opinion.equals(wantPlayGame)) {
            return Decision.PLAY;
        }
        if (opinion.equals(wantStopGame)) {
            return Decision.STOP;
        }
        throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }

    private void printInformation() {
        System.out.println(String.format(informationMessage, wantPlayGame, wantStopGame));
    }

}
