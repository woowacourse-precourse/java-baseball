package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    public String ball;

    public Computer() {
        this.ball = this.generateRandom();
    }

    private String generateRandom() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            sb.append(Randoms.pickNumberInRange(1, 9));
        }

        return sb.toString();
    }

    public String getBall() {
        return ball;
    }
}