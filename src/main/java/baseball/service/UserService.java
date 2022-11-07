package baseball.service;

import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;

public class UserService {

    private final User user;
    private String userBaseballNumber;
    private String userRestartNumber;

    public UserService(User user) {
        this.user = user;
    }

    public void inputBaseballNumber() {
        userBaseballNumber = Console.readLine();

        checkBaseballNumber();

        user.setBaseballNumber(userBaseballNumber);
    }

    public String getBaseballNumber() {
        return user.getBaseballNumber();
    }

    public void inputRestartNumber() {
        userRestartNumber = Console.readLine();
        user.setUserRestartNumber(userRestartNumber);
    }

    public String getRestartNumber() {
        return user.getRestartNumber();
    }

    private void checkBaseballNumber() {
        if (!checkNumberLength() || !checkIsInteger()) {
            throw new IllegalArgumentException("프로그램을 종료합니다.");
        }
    }

    private boolean checkNumberLength() {
        boolean returnCheckNumber = true;
        if (userBaseballNumber.length() != 3) {
            returnCheckNumber = false;
        }
        return returnCheckNumber;
    }

    private  boolean checkIsInteger(){
        boolean returnCheckNumber = true;
        char number;

        for(int i=0; i<userBaseballNumber.length(); i++){
            number = userBaseballNumber.charAt(i);

            if(!Character.isDigit(number)){
                returnCheckNumber = false;
                break;
            }
        }

        return returnCheckNumber;
    }

}
