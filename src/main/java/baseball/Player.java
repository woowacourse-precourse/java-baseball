package baseball;



public class Player {
    private String number;


    public Player() {}


    public void setNumber(String input) {
        if (!Validator.isValid(input)) {
            throw new IllegalArgumentException();
        }

        this.number = input;
    }
}
