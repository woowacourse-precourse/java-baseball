package baseball;

public class Judge {
    public String GameStart(String computer, String user) {
        Rule rule = new Rule();
        int strike = rule.strike(computer, user);
        int total = rule.contain(computer, user);
        int ball = total - strike;

        if (total == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";

    }


}
