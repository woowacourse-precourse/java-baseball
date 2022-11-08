package baseball;



public class Validator {
    private static final String REGEX = "[1-9]{3}";


    static public boolean containDuplicatedNumber(String input) {
        for (int index = 0; index < input.length(); index++) {
            if (input.indexOf(input.charAt(index)) != index) {     // 중복된 문자가 있는 경우 가장 앞의 문자를 반환하는 것을 이용
                return true;
            }
        }

        return false;
    }

    static public boolean isValid(String input) {
        if (!input.matches(REGEX)) {
            return false;
        }

        if(containDuplicatedNumber(input)) {
            return false;
        }

        return true;
    }
}
