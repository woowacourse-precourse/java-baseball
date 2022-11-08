package baseball;

public class User {

    private static User instance;

    private Numbers userNumbers;

    private User () {}

    public static User getUser() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    public void inputNewNumbers(int input) {
        this.userNumbers = Numbers.createNumbers(input);
    }

    public Number findUserNumber(int index) {
        return this.userNumbers.findNumber(index);
    }
}
