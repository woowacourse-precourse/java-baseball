package baseball.Model;


import java.util.HashSet;
import java.util.Set;

public class UserInputNumber {

    private final static int USER_NUM_MAX = 3; //최대 유저 숫자
    private String userNumber;

    public String getUserNumber() {
        return userNumber;
    }

    public UserInputNumber(String userNumber) {
        if(isThereZero(userNumber) && isValidSizeOfNumberRange(userNumber) && isItAllSameNumber(userNumber)) {
            this.userNumber = userNumber;
        }
    }

    public boolean isThereZero(String checkWord) throws IllegalArgumentException {
        if(checkWord.contains("0")) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isValidSizeOfNumberRange(String checkWord) throws IllegalArgumentException {
        if(!(checkWord.length() < USER_NUM_MAX)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isItAllSameNumber(String checkWord) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();
        for(int index = 0; index < checkWord.length(); index++) {
            set.add(checkWord.charAt(index));
        }
        if(set.size() != checkWord.length()) {
            throw new IllegalArgumentException();
        }
        return true;
    }


}
