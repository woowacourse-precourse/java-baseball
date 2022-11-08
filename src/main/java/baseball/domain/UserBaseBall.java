package baseball.domain;

public class UserBaseBall {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    private static String userBallNumber;
    private static int[] duplicateNumer;

    public UserBaseBall() {
    }

    public static String getUserInput() {
        return userBallNumber;
    }

    public void setUserBallNumber(String userBallNumber) {
        validateNumber(userBallNumber);
        this.userBallNumber = userBallNumber;
    }


    public void validateNumber(String userBallNumber) {
        if (numberRange(userBallNumber)) {
            throw new IllegalArgumentException("숫자의 입력범위를 초과하였습니다.");
        } else if (numberLength(userBallNumber)) {
            throw new IllegalArgumentException("야구공 입력 개수를 초과하였습니다.");
        } else if (numberDuplicate(userBallNumber)) {
            throw new IllegalArgumentException("중복된 숫자는 입력 할 수 없습니다.");
        } else if(numberIsDigit(userBallNumber)) {
            throw new IllegalArgumentException("숫자만 입력 하실 수 있습니다.");
        }
    }

    private boolean numberIsDigit(String numbers) {
        for (Character number : numbers.toCharArray() ) {
            if(!Character.isDigit(number)) return true;
        }
        return false;
    }

    private boolean numberRange(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            int number = Character.getNumericValue(numbers.charAt(i));
            if (number < MIN_NUM || number > MAX_NUM) {
                return true;
            }
        }
        return false;
    }

    private boolean numberDuplicate(String numbers) {
        duplicateNumer = new int[10];
        for (int i = 0; i < numbers.length(); i++) {
            int num = Character.getNumericValue(numbers.charAt(i));
            duplicateNumer[num]++;
        }

        for (int i : duplicateNumer) {
            if (i > 1) {
                return true;
            }
        }

        return false;
    }

    private boolean numberLength(String numbers) {
        if (numbers.length() > 3) {
            return true;
        } else {
            return false;
        }
    }

}
