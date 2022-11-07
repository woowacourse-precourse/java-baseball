package baseball.screen;

import baseball.domain.Result;
import java.util.ArrayList;
import java.util.List;

public class OutputResolver {
    public void print() {
        System.out.println(buildPrompt(Result.getBall(), Result.getStrike()));
    }

    public void print(String prompt) {
        System.out.print(prompt);
    }

    private String buildPrompt(Integer ball, Integer strike) {
        List<String> ballsAndStrikes = new ArrayList<>();

        if (ball > 0) {
            ballsAndStrikes.add(ball + "볼");
        }
        if (strike > 0) {
            ballsAndStrikes.add(strike + "스트라이크");
        }
        if (ballsAndStrikes.isEmpty()) {
            return "낫싱";
        }

        return String.join(" ", ballsAndStrikes);
    }
}
