package baseball.model;

public class Flow {
    private final static String ANSWER = "3스트라이크\n";

    private boolean gameFlag = true;
    private boolean subGameFlag = true;

    public void setGameFlag(boolean isAgain) {
        if (isAgain) {
            this.gameFlag = true;
        }
        if (!isAgain) {
            this.gameFlag = false;
        }
    }

    public void setSubGameFlag(String countResult) {
        if (countResult.equals(ANSWER)) {
            this.subGameFlag = false;
            return;
        }
        this.subGameFlag = true;
    }

    public Boolean getGameFlag() {
        return this.gameFlag;
    }

    public Boolean getSubGameFlag() {
        return this.subGameFlag;
    }

    public void setSubGameFlag() {
        this.subGameFlag = true;
    }

}
