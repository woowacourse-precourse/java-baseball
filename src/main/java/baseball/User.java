package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class User {
    private String userInput;
    List<Integer> computerNum;
    final String RECEIVE_MESSAGE = "숫자를 입력해주세요 : ";

    public User(List<Integer> computerNum, List<Integer> userNum) {
        initializeUser(computerNum, userNum);
        receiveUserInput(userNum);
    }

    void initializeUser(List<Integer> computerNum, List<Integer> userNum) {
        userNum.clear();
        this.computerNum = computerNum;
    }

    void receiveUserInput(List<Integer> userNum) {
        printReceiveMessage();
        userInput = Console.readLine();
        checkUserInput(userNum);
    }

    void printReceiveMessage() {
        System.out.print(RECEIVE_MESSAGE);
    }

    void checkUserInput(List<Integer> userNum) {
        checkInputLength();
        checkRightType();
        checkBeforeAdd(userNum);
        Comparison comparison = new Comparison(computerNum, userNum);
    }

    void checkInputLength() {
        if (userInput.length() != 3)
            throw new IllegalArgumentException();
    }

    void checkRightType(){
        char[] inputChar = userInput.toCharArray();
        for(Character c : inputChar){
            if(!Character.isDigit(c)) throw new IllegalArgumentException();
        }
    }

    void checkBeforeAdd(List<Integer> userNum) {
        for (int i = 0; i < userInput.length(); i++) {
            int userChar = userInput.charAt(i) - '0';
            checkInputRange(userChar);
            checkDuplicate(userNum, userChar);
            userNum.add(userChar);
        }
    }

    void checkInputRange(int userChar) {
        if (userChar <= 0 | userChar > 9)
            throw new IllegalArgumentException();
    }

    void checkDuplicate(List<Integer> userNum, int userChar) {
        if (userNum.contains(userChar))
            throw new IllegalArgumentException();
    }
}
