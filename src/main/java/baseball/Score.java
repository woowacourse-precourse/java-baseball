package baseball;


import java.util.List;

public class Score {

    enum matchingTypes {FAIL, STRIKE, BALL}

    private int maxScore;
    private int strike;
    private int ball;
    private int fail;

    public Score(int maxScore) {
        this.strike = 0;
        this.ball = 0;
        this.fail = 0;
        this.maxScore = maxScore;
    }

    private matchingTypes decideMatchingTypeBetween(int idxInUser, int idxInComputer) {
        if (idxInComputer == -1) {
            return matchingTypes.FAIL;
        } else {
            if (idxInComputer == idxInUser) {
                return matchingTypes.STRIKE;
            } else {
                return matchingTypes.BALL;
            }
        }
    }

    private void clearAllScore() {
        this.strike = 0;
        this.fail = 0;
        this.ball = 0;
    }

    public void updateTotalScore(List<Integer> computer, List<Integer> user) {
        System.out.println(computer);
        System.out.println(user);

        clearAllScore();

        for (int i = 0; i < user.size(); i++) {
            int idxInComputer = computer.indexOf(user.get(i));

            // strike, fail, ball 중에 해당하는 유형을 찾아 해당 유형의 점수를 1 증가
            matchingTypes matchingType = decideMatchingTypeBetween(i, idxInComputer);
            increase(matchingType);
        }
    }

    public void print() {
        if (isAllStrike()) {
            System.out.printf("%d스트라이크\n", strike);
        } else if (isAllFail()) {
            System.out.println("낫싱");
        } else {
            System.out.printf("%d볼 %d스트라이크\n", this.ball, this.strike);
        }
    }

    public boolean isAllStrike() {
        if (this.strike == this.maxScore) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAllFail() {
        if (this.fail == this.maxScore) {
            return true;
        } else {
            return false;
        }
    }


    private void increase(matchingTypes type) {
        if (type == matchingTypes.FAIL) {
            increaseFail();
        } else if (type == matchingTypes.BALL) {
            increaseBall();
        } else if (type == matchingTypes.STRIKE) {
            increaseStrike();
        }
    }

    private void increaseStrike() {
        this.strike++;
    }

    private void increaseBall() {
        this.ball++;
    }

    private void increaseFail() {
        this.fail++;
    }


}
