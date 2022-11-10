package baseball.service;

public class Player {
    private ThreeNumber number;

    public ThreeNumber getThreeNumber() {
        return number;
    }

    public void setNumber(String input) {
        number = new ThreeNumber();
        number.setNumber(input);
    }
}
