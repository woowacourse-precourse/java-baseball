package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;

public class UserService {

    private final User user;
    private final Computer computer;
    private String userBaseballNumber;
    private String userRestartNumber;

    public UserService(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
    }

    public void inputBaseballNumber() {
        userBaseballNumber = Console.readLine();

        checkBaseballNumber();

        user.setBaseballNumber(userBaseballNumber);
    }

    public String getBaseballNumber() {
        return user.getBaseballNumber();
    }

    public String getAnswer(){
        return computer.getAnswer();
    }

    public void inputRestartNumber() {
        userRestartNumber = Console.readLine();

        checkRestartNumber();

        user.setUserRestartNumber(userRestartNumber);
    }

    public String getRestartNumber() {
        return user.getRestartNumber();
    }


    private void initGame(){
        computer.setAnswer();
    }

    private boolean checkNothing(){
        String answer;
        String baseballNumber;
        boolean returnNothingStatus = false;

        answer = getAnswer();
        baseballNumber = getBaseballNumber();

        for(int i=0; i<answer.length(); i++){
            for(int j=0; j<baseballNumber.length(); j++){
                if (answer.charAt(i) == baseballNumber.charAt(j)){
                    returnNothingStatus = true;
                }
            }
        }

        return returnNothingStatus;
    }

    private Integer checkBallStrike(String status){
        String answer;
        String baseballNumber;
        int gameCount = 0;

        answer = getAnswer();
        baseballNumber = getBaseballNumber();


        for(int i=0; i<answer.length(); i++){
            for(int j=0; j<baseballNumber.length(); j++){
                if (status.equals("strike") && i == j && answer.charAt(i) == baseballNumber.charAt(j)){
                    gameCount += 1;
                }
                if (status.equals("ball") && i != j && answer.charAt(i) == baseballNumber.charAt(j)){
                    gameCount += 1;
                }
            }
        }

        return gameCount;
    }


    private void checkRestartNumber() {
        if (!checkRestartlength() || checkIsInteger(userRestartNumber)) {
            throw new IllegalArgumentException("에러발생 프로그램을 종료합니다.");
        }
    }

    private void checkBaseballNumber() {
        if (!checkNumberLength() || !checkIsInteger(userBaseballNumber)) {
            throw new IllegalArgumentException("에러발생 프로그램을 종료합니다.");
        }
    }

    private boolean checkRestartlength() {
        boolean returnCheckNumber = true;
        if (userBaseballNumber.length() != 2) {
            returnCheckNumber = false;
        }
        return returnCheckNumber;
    }

    private boolean checkNumberLength() {
        boolean returnCheckNumber = true;
        if (userBaseballNumber.length() != 3) {
            returnCheckNumber = false;
        }
        return returnCheckNumber;
    }

    private boolean checkIsInteger(String userInputNumber) {
        boolean returnCheckNumber = true;
        char number;

        for (int i = 0; i < userInputNumber.length(); i++) {
            number = userInputNumber.charAt(i);

            if (!Character.isDigit(number)) {
                returnCheckNumber = false;
                break;
            }
        }

        return returnCheckNumber;
    }

}
