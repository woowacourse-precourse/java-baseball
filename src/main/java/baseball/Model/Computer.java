package baseball.Model;


import baseball.Util.RandomUtil;

public class Computer {
    private String computerInput;
    private final Ball ball = new Ball();

    public void setComputerInput() {
        computerInput = RandomUtil.randomNum();
    }

    public String ballHintCheck(String userInput) {
        return ball.ballHintResult(userInput, computerInput);
    }
}
