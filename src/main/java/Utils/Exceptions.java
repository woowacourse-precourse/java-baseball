package Utils;

public class Exceptions {
    public static final Exceptions EXCEPTIONS = new Exceptions();

    public Exceptions() {
        super();
    }

    public String ValidateUserInputNumber(String readLine) {
        if (!readLine.matches("^[1-9]*?") && readLine.length() != 3) {
            throw new IllegalArgumentException(Messages.INPUT_ERROR_MESSAGE);
        }
        return readLine;
    }

}
