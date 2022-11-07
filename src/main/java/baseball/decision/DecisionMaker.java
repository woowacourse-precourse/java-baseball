package baseball.decision;

import camp.nextstep.edu.missionutils.Console;

public class DecisionMaker {

    final String InformationMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public Decision getDecision() {
        return acceptOpinion();
    }

    private Decision acceptOpinion() {
        printInformation();
        String opinion = Console.readLine();
        if (opinion.equals("1")) {
            return Decision.PLAY;
        }
        if (opinion.equals("2")) {
            return Decision.STOP;
        }
        throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }

    private void printInformation() {
        System.out.println(InformationMessage);
    }
}
