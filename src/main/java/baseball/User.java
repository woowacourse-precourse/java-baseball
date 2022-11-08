package baseball;

public class User {

    private Numbers userNumbers;

    public User () {}

    public void inputNewNumbers(int input) {
        this.userNumbers = Numbers.createNumbers(input);
    }

    public Number findUserNumber(int index) {
        return this.userNumbers.findNumber(index);
    }
}
