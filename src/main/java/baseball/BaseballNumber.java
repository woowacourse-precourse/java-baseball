package baseball;



public class BaseballNumber {
    private String baseballNumber;


    public BaseballNumber() {}


    public void set(String input) {
        this.baseballNumber = input;
    }


    public boolean containDuplicatedNumber() {
        for (int index = 0; index < baseballNumber.length(); index++) {
            if(baseballNumber.indexOf(baseballNumber.charAt(index)) != index) {     // 중복된 문자가 있는 경우 가장 앞의 문자를 반환하는 것을 이용
                return true;
            }
        }

        return false;
    }

    public boolean isValid() {
        final String REGEX = "[1-9]+";

        if (baseballNumber.length() != 3) {
            return false;
        }

        if (!baseballNumber.matches(REGEX)) {
            return false;
        }

        if(this.containDuplicatedNumber()) {
            return false;
        }

        return true;
    }

}
