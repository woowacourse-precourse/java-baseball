package baseball;

public class Computer {
    private String answer;
    private int ball;
    private int strike;

    public Computer(String answer) {
        this.answer = answer;
    }

    public String getHint(String inputNumber) {
        ball = 0;
        strike = 0;
        for(int i=0; i<inputNumber.length(); i++) {
            char c = inputNumber.charAt(i);
            checkHintOf(c, i);
        }
        return getHintMessage();
    }

    private void checkHintOf(char c, int index) {
        if(answer.charAt(index) == c) {
            strike++;
        }
        else if(answer.contains(String.valueOf(c))) {
            ball++;
        }
    }

    private String getHintMessage() {
        if(ball == 0 && strike == 0) {
            return "낫싱";
        }
        else if(strike == 3) {
            return "3스트라이크";
        }
        else if (ball != 0 && strike == 0) {
            return ball + "볼";
        }
        else if(ball == 0 && strike != 0) {
            return strike + "스트라이크";
        }
        else {
            return ball + "볼 " + strike + "스트라이크";
        }
    }
}
