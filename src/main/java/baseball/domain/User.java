package baseball.domain;

public class User {

    private String number;

    public User() {
        this.number = "";
    }

    public String getNumber() {
        return this.number;
    }

    public void setInput(String input) {
        this.number = input;
    }
}
