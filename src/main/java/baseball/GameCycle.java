package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameCycle {
    public String drawNumber() {
        List<String> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(String.valueOf(number))) {
                randomNumbers.add(String.valueOf(number));
            }
        }
        String randomNumber = String.join("", randomNumbers);
        return randomNumber;
    }
    public void outputWriteNumber(){
        System.out.print("숫자를 입력해주세요 : ");
    }
    public String inputNumber(){
        return Console.readLine();
    }
    public boolean numberLengthIsThree(String number) {
        if (number.length() != 3) throw new IllegalArgumentException();
        return true;
    }
    public boolean numberIsDigit(String number) {
        char[] numberCharArray = number.toCharArray();
        for (char tmpChar : numberCharArray) {
            if (!Character.isDigit(tmpChar)) throw new IllegalArgumentException();
        }
        return true;
    }
    public boolean numberIsNotZero(String number) {
        if (number.contains("0")) throw new IllegalArgumentException();
        return true;
    }
    public boolean numberIsNotDuplicate(String number) {
        for (int index = 0; index < number.length(); index++) {
            char tmpChar = number.charAt(index);
            if (index != number.indexOf(tmpChar)) throw new IllegalArgumentException();
        }
        return true;
    }
    public String playerInputNumber() {
        outputWriteNumber();
        String playerNumber = inputNumber();
        if (numberIsDigit(playerNumber));
        if (numberLengthIsThree(playerNumber));
        if (numberIsNotDuplicate(playerNumber));
        if (numberIsNotZero(playerNumber));
        return playerNumber;
    }
    public int countStrike(String answer, String input) {
        int strike = 0;
        for (int inputIndex = 0; inputIndex < input.length(); inputIndex++) {
            if (input.charAt(inputIndex) == answer.charAt(inputIndex)) strike++;
        }
        return strike;
    }
    public int countBall(String answer, String input) {
        int ball = 0;
        for (int inputIndex = 0; inputIndex < input.length(); inputIndex++) {
            String tmpString = String.valueOf(input.charAt(inputIndex));
            if (input.charAt(inputIndex) == answer.charAt(inputIndex)) continue;
            if (answer.contains(tmpString)) ball++;
        }
        return ball;
    }
    public String countResponse(String answer, String input) {
        int strike = countStrike(answer, input);
        int ball = countBall(answer, input);
        StringBuilder response = new StringBuilder();
        if (strike > 0 && ball > 0) {
            response.append(ball + "볼 " + strike + "스트라이크");
            return response.toString();
        }
        if (strike > 0) response.append(strike + "스트라이크");
        if (ball > 0) response.append(ball + "볼");
        if (strike == 0 && ball == 0) response.append("낫싱");
        return response.toString();
    }
    public boolean isThreeStrike(String request) {
        if (request.equals("3스트라이크")) return true;
        return false; //NOT 3 STRIKE
    }
    public void output(String message){
        System.out.println(message);
    }
    public void endGameMessage(){
        output("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public void play(){
        String answer = drawNumber();
        output(answer);
        while(true){
            String playerNumber = playerInputNumber();
            String countStatus = countResponse(answer, playerNumber);
            output(countStatus);
            if(isThreeStrike(countStatus))break;
        }
        endGameMessage();
    }
}
