package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class GameManager {
    static final int GUESS_NUMBER_SIZE = 3;
    private ArrayList<Integer> guessNumber;
    private boolean isCorrect;

    public boolean startGame() {
        init();

        while(!isCorrect) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            validateInput(input);

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
        guessNumber = new ArrayList<>();

        while (guessNumber.size() < GUESS_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!guessNumber.contains(randomNumber)) {
                guessNumber.add(randomNumber);
            }
        }
    }

    private void validateInput(String input) {
        if(!isOneToNine(input)) {
            throw new IllegalArgumentException("each position of input should be from one to nine.");
        } else if(!isThreeChar(input)) {
            throw new IllegalArgumentException("input length should be three.");
        } else if(hasDuplicatedDigit(input)) {
            throw new IllegalArgumentException("input has duplicated digit");
        }
    }

    private boolean isOneToNine(String input) {
        String pattern = "^[1-9]*$";
        return Pattern.matches(pattern, input);
    }

    private boolean isThreeChar(String input) {
        return input.length() == GUESS_NUMBER_SIZE;
    }

    private boolean hasDuplicatedDigit(String input) {
        for(int index = 0;index < input.length();index++) {
            if(hasEqualDigit(input, index)) {
                return true;
            }
        }

        return false;
    }

    /**
     * @return: 자기 자신 index를 제외한 동일한 숫자가 있는가??
     */
    private boolean hasEqualDigit(String input, int index) {
        for(int i = 0;i < input.length();i++) {
            if(i != index && input.charAt(i) == input.charAt(index)) {
                return true;
            }
        }

        return false;
    }

    private ArrayList<Integer> inputToUserGuess(String input) {
        ArrayList<Integer> ret = new ArrayList<>();

        for(char character: input.toCharArray()) {
            ret.add(character - '0');
        }

        return ret;
    }

    private String getResultOfUserGuess(ArrayList<Integer> userGuess) {
        final int strike = getStrike(userGuess);
        final int ball = getBall(userGuess);

        if(isNothing(strike, ball)) {
            return "낫싱";
        } else if(strike == GUESS_NUMBER_SIZE) {
            isCorrect = true;
        }

        return getResultString(strike, ball);
    }

    private String getResultString(final int strike, final int ball) {
        String resultString = "";

        if(ball > 0) {
            resultString += (ball + "볼 ");
        }
        if(strike > 0) {
            resultString += (strike + "스트라이크");
        }

        return resultString;
    }

    private int getStrike(ArrayList<Integer> userGuess) {
        int strike = 0;

        for(int index = 0;index < GUESS_NUMBER_SIZE;index++) {
            if(guessNumber.get(index) == userGuess.get(index)) {
                strike++;
            }
        }

        return strike;
    }

    private int getBall(ArrayList<Integer> userGuess) {
        int ball = 0;

        for(int userIndex = 0;userIndex < GUESS_NUMBER_SIZE;userIndex++) {
            int userDigit = userGuess.get(userIndex);
            ball += countUserDigitInAnswer(userIndex, userDigit);
        }

        return ball;
    }

    private int countUserDigitInAnswer(int userIndex, int userDigit) {
        int count = 0;

        for(int answerIndex = 0;answerIndex < GUESS_NUMBER_SIZE;answerIndex++) {
            if(userIndex != answerIndex && userDigit == guessNumber.get(answerIndex)) {
                count++;
            }
        }

        return count;
    }

    private boolean isNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }

    private boolean gameover() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String replaySign = Console.readLine();
        validateReplaySign(replaySign);

        if(replaySign.equals("1")) {
            return true;
        }

        exitGame();
        return false;
    }

    private void validateReplaySign(String replaySign) {
        if(!(replaySign.equals("1") || replaySign.equals("2"))) {
            throw new IllegalArgumentException("replaySign is not valid.");
        }
    }

    private void exitGame() {
        System.out.println("게임 종료");
    }
}