package baseball;

import java.util.ArrayList;

public class BaseballDecision {
    private Integer strikeCount;
    private Integer ballCount;
    private Boolean nothingFlag;
    private final NumberHandler numberHandler;

    public BaseballDecision(NumberHandler numberHandler) {
        this.numberHandler = numberHandler;
    }

    public void makeDecision() {
        strikeCount = 0;
        ballCount = 0;
        nothingFlag = false;

        ArrayList<Integer> computerNumber = numberHandler.getComputerNumber();
        ArrayList<Integer> userNumber = numberHandler.getUserNumber();

        for (int index = 0; index < 3; index++) {
            if (computerNumber.get(index) == userNumber.get(index)) {
                strikeCount++;
            } else if (computerNumber.contains(userNumber.get(index))) {
                ballCount++;
            }
        }

        if (ballCount > 0 || strikeCount > 0) {
            nothingFlag = false;
        } else {
            nothingFlag = true;
        }
    }

    @Override
    public String toString() {
        String sign = "";

        if (nothingFlag) {
            return "낫싱";
        }

        if (ballCount > 0) {
            sign += ballCount + "볼 ";
        }

        if (strikeCount > 0) {
            sign += strikeCount + "스트라이크";
        }

        return sign;
    }

    public Integer getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(Integer strikeCount) {
        this.strikeCount = strikeCount;
    }

    public Integer getBallCount() {
        return ballCount;
    }

    public void setBallCount(Integer ballCount) {
        this.ballCount = ballCount;
    }

    public Boolean getNothingFlag() {
        return nothingFlag;
    }

    public void setNothingFlag(Boolean nothingFlag) {
        this.nothingFlag = nothingFlag;
    }
}
