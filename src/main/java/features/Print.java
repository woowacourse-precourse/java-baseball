package features;

import static features.Hint.getCountBall;
import static features.Hint.getCountNothing;
import static features.Hint.getCountStrike;

public abstract class Print implements Factory {

    int countStrike = getCountStrike();
    int countBall = getCountBall();
    int countNothing = getCountNothing();

    private String strike = String.format("%d스트라이크");
    private String ball = String.format("%d볼 %d스트라이크", countBall, countStrike);
    private String nothing = "낫싱";

    @Override
    public String printResult() {
        String result = "";

        if (countStrike == 3) {
            result = victory();
        }
        if (countBall > 1) {
            result = ball;
        }
        if (countNothing == 3) {
            return nothing;
        }

        return result;
    }

    public static String victory() {
        String victory = "3스트라이크\n"
                + "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        return victory;
    }

}
