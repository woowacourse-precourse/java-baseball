package baseball;

public class Exception {

    public static void hasCharacters(String input) {
        String regex = "^[0-9]*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }

}
