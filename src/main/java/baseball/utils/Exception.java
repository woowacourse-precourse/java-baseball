package baseball.utils;

import java.util.regex.Pattern;


public class Exception {

    //regex for 1~9  3 digits
    public static final Pattern NUMBERS_PATTERN = Pattern.compile("([0-9]{1,3})$");

    public void checkInputNumbers(String inputNumbers) {
        checkThreeDigitNumber(inputNumbers);
    }

    public void checkOneDigitNumber(int inputNumber) {
        if (!((inputNumber == Constant.PLAYER_RESTART)||(inputNumber == Constant.PLAYER_ENDGAME))) {
            throw new NumberFormatException("잘못된 입력의 숫자입니다");
        }
    }

    public static void checkThreeDigitNumber(String inputNumbers) {
        if (!NUMBERS_PATTERN.matcher(inputNumbers).matches()) {
            throw new IllegalArgumentException("wrong");
        }
    }

//    public static void checkDuplicated(List<Integer> playerNumber) {
//        Set<Integer> items = new HashSet<>();
//        playerNumber.stream()
//                .filter(n -> !items.add(n))
//                .collect(Collectors.toSet());
//        if (items.size() != 3) {
//            throw new IllegalArgumentException();
//        }
//    }
}

