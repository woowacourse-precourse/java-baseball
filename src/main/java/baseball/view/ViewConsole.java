package baseball.view;

import baseball.uitls.Hints;

import java.util.List;

public class ViewConsole implements Viewable {

    private final String START_LINE = "숫자 야구 게임을 시작합니다.";
    private final String INPUT_LINE = "숫자를 입력해주세요 :";
    private final String END_LINE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String CONTINUE_LINE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    @Override
    public void printHint(Hints hints) {
        calBallCount(hints);
    }

    private static void calBallCount(Hints hints) {
        if (hints.hasBallStrike()) {
            System.out.println(hints.getBall() + "볼" + " " + hints.getStrike() + "스트라이크");
            return;
        }

        if (hints.hasOnlyBall()) {
            System.out.println(hints.getBall() + "볼");
            return;
        }

        if (hints.hasOnlyStrike()) {
            System.out.println(hints.getStrike() + "스트라이크");
            return;
        }

        System.out.println("낫싱");
    }

    @Override
    public void printStart() {
        System.out.println(START_LINE);
    }

    @Override
    public void printInput() {
        System.out.print(INPUT_LINE);
    }

    @Override
    public void printEnd() {
        System.out.println(END_LINE);
    }

    @Override
    public void printIsContinue() {
        System.out.println(CONTINUE_LINE);
    }

}
