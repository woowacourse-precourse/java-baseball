package baseball;



public class BaseballNumber {
    private String baseballNumber;


    public BaseballNumber() {}


    public void set(String input) {
        if (!isValid(input)) {
            throw new IllegalArgumentException();
        }

        baseballNumber = input;
    }


    static public boolean containDuplicatedNumber(String input) {
        for (int index = 0; index < input.length(); index++) {
            if (input.indexOf(input.charAt(index)) != index) {     // 중복된 문자가 있는 경우 가장 앞의 문자를 반환하는 것을 이용
                return true;
            }
        }

        return false;
    }

    static public boolean isValid(String input) {
        final String REGEX = "[1-9]+";

        if (input.length() != 3) {
            return false;
        }

        if (!input.matches(REGEX)) {
            return false;
        }

        if(containDuplicatedNumber(input)) {
            return false;
        }

        return true;
    }

}
