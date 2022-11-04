package baseball;



public class BaseballNumber {
    private String number;


    public BaseballNumber() {}


    public void set(String input) {
        if (!Validator.isValid(input)) {
            throw new IllegalArgumentException();
        }

        number = input;
    }
}
