package Utils;

public class Exceptions {
    public static final Exceptions EXCEPTIONS = new Exceptions();

    public Exceptions() {
        super();
    }

    public String ValidateUserInputNumber(String readLine) {
        for (int i = 0; i < readLine.length(); i++) {
            if (!Character.isDigit(readLine.charAt(i)) || readLine.charAt(i) == '0' || readLine.length() != 3) {
                throw new IllegalArgumentException(Messages.INPUT_ERROR_MESSAGE);
            }
        }
        if (readLine.charAt(0) == readLine.charAt(1) || readLine.charAt(1) == readLine.charAt(2) || readLine.charAt(0) == readLine.charAt(2)) {
            throw new IllegalArgumentException(Messages.DUPLICATION_ERROR_MESSAGE);
        }
        return readLine;
    }

    public String ValidateOneOrTwoNumber(String readLine) {
        if (!readLine.matches("^[1-9]*?") && readLine.length() != 1) {
            throw new IllegalArgumentException(Messages.ONE_OR_TWO_ERROR_MESSAGE);
        }
        return readLine;
    }

}
