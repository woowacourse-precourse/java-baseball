package baseball.Domain;

import camp.nextstep.edu.missionutils.Console;

import baseball.View.Message;

import java.util.ArrayList;

public class User {
    public ArrayList<Integer> userNumber;

    public void setUserNumber() throws IllegalArgumentException {
        userNumber = new ArrayList<>();
        Message.printRequestUserNumber();
        verifyUserNumber(Console.readLine());
    }

    public void verifyUserNumber(String answer) throws IllegalArgumentException {
        checkSize(answer);
        checkDigit(answer);
        addUserNumber(answer);
    }

    public void checkSize(String answer) throws IllegalArgumentException {
        if (answer.length() != 3) {
            throw new IllegalArgumentException("Size error");
        }
    }

    public void checkDigit(String answer) throws IllegalArgumentException {
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) < 49 || answer.charAt(i) > 57) {
                throw new IllegalArgumentException("Digit error");
            }
        }
    }

    public void addUserNumber(String answer) throws IllegalArgumentException {
        for (int i = 0; i < answer.length(); i++) {
            int answerChar = answer.charAt(i) - '0';
            if (userNumber.contains(answerChar)) {
                throw new IllegalArgumentException("User Number dup error");
            }
            userNumber.add(answerChar);
        }
    }

    public static boolean finishInput() throws IllegalArgumentException {
        return verifyFinishNumber(Console.readLine());
    }

    public static boolean verifyFinishNumber(String finishNumber) throws IllegalArgumentException {
        if (finishNumber.equals("1")) {
            return true;
        } else if (finishNumber.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("User Finish Input Error");
    }
}
