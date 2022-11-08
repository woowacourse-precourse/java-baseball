package baseball;

public class Computer {
    private String answer;

    public Computer(String answer) {
        this.answer = answer;
    }

    public String getHint(String inputNumber) {
        int strike = countStrike(inputNumber);
        int ball = countAll(inputNumber) - strike;
        return getHintMessage(strike, ball);
    }

    private int countStrike(String input) {
        int count = 0;
        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if(answer.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    private int countAll(String input) {
        int count = 0;
        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if(answer.contains(String.valueOf(c))) {
                count++;
            }
        }
        return count;
    }

    private String getHintMessage(int strike, int ball) {
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
