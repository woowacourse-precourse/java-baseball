package baseball.exception;

import java.util.Objects;

public class Exception {
    public boolean scoreException(String input) {
        boolean check = false;
        if (input.length() == 3) {
            check = checkLimit(input);
        }
        return check;
    }

    private static boolean checkLimit(String input) {
        boolean check = true;
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) < '1' || input.charAt(i) > '9') {
                check = false;
                break;
            }
        }
        return check;
    }

    public boolean checkInputSame(String input) {
        boolean check = true;
        if (Objects.equals(input.charAt(0), input.charAt(1))) check = false;
        else if (Objects.equals(input.charAt(0), input.charAt(2))) check = false;
        else if (Objects.equals(input.charAt(1), input.charAt(2))) check = false;
        return check;
    }

    public boolean regameException(String input) {
        boolean check = true;
        if (input.length() == 1) {
            if ("1".equals(input) || "2".equals(input)) check = false;
        }
        return check;
    }
}
