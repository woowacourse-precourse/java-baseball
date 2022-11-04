package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class GameManager {
    private ArrayList<Integer> guessNumber;
    private boolean isCorrect;

    public boolean startGame() {
        init();
        while(!isCorrect) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            try {
                validateInput(input);
            } catch(Exception e) {
                exitGame(e);
                return false;
            }

            ArrayList<Integer> userGuess = inputToUserGuess(input);
            String resultString = getResultOfUserGuess(userGuess);
            System.out.println(resultString);

        }
        return gameover();
    }

    private void init() {
        isCorrect = false;
        makeNewGuessNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    
    //README.md 내 주어진 코드 변형
    private void makeNewGuessNumber() {
        while (guessNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!guessNumber.contains(randomNumber)) {
                guessNumber.add(randomNumber);
            }
        }
    }

    private void validateInput(String input) {
        if(!isOneToNine(input))
            throw new IllegalArgumentException("each position of input should be from one to nine.");
        else if(!isThreeChar(input))
            throw new IllegalArgumentException("length of input should be three.");
        else if(hasDuplicatedDigit(input))
            System.out.println("정답은 세자리 모두 다 다릅니다.");
    }

    private boolean isOneToNine(String input) {
        for(char character: input.toCharArray()) {
            if(character<'1'||character>'9') {
                return false;
            }
        }

        return true;
    }

    private boolean isThreeChar(String input) {

    }

    private boolean hasDuplicatedDigit(String input) {

    }

    private ArrayList<Integer> inputToUserGuess(String input) {

    }

    private String getResultOfUserGuess(ArrayList<Integer> userGuess) {

    }

    private int getStrike(ArrayList<Integer> userGuess) {

    }

    private int getBall(ArrayList<Integer> userGuess) {

    }

    private boolean isNothing(int strike, int ball) {

    }

    private boolean gameover() {

    }

    private void exitGame(Exception e) {

    }
}