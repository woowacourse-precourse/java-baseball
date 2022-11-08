package baseball;



public class Player {
    private String number;


    public Player() {}


    public String getNumber() {
        return this.number;
    }

    public void setNumber(String input) {
        if (!Validator.isValid(input)) {
            GameMessagePrinter.printInvalidInput();
            throw new IllegalArgumentException();
        }

        this.number = input;
    }
}
