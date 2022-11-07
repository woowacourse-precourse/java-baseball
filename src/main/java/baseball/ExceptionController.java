package baseball;

import java.util.regex.Pattern;

public class ExceptionController {

    private final static String inputNumberRegex = "[1-9]+";
    private final static String checkNewGameRegex = "[1-2]+";
//    private static Pattern pattern = Pattern.compile(regex);

    public void inputNumberException(String number) {
//        System.out.println("예외 처리 진입");
        if (number.length() != 3 || !number.matches(inputNumberRegex)) {
//            System.out.println("Exception");
            throw new IllegalArgumentException();
        }
    }

    public void checkNewGameException(String number) {
//        System.out.println("예외 처리 진입2");
        if (number.length() != 1 || !number.matches(checkNewGameRegex)) {
//            System.out.println("Exception2");
            throw new IllegalArgumentException();
        }
    }

}
