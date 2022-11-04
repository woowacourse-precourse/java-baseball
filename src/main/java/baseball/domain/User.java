package baseball.domain;

public class User {
    private String userAnswer;

    public User(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}
