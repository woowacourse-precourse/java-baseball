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
        while (guessNumber.size() < 3) {
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
            System.out.println("정답은 세자리 모두 다 다릅니다.");
        }
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
        return input.length() == 3;
    }

    private boolean hasDuplicatedDigit(String input) {
        for(int index = 0;index < input.length();index++) {
            if(hasEqualDigit(input, index)) {
                return true;
            }
        }

        return false;
    }

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
        } else if(strike == 3) {
            isCorrect = true;
        }

        return getResultString(strike, ball);
    }

    private String getResultString(final int strike, final  int ball) {
        String ret = "";
        if(ball > 0) {
            ret += (ball + "볼 ");
        }
        if(strike > 0) {
            ret += (strike + "스트라이크");
        }

        return ret;
    }

    private int getStrike(ArrayList<Integer> userGuess) {
        int ret = 0;
        for(int index = 0;index < 3;index++) {
            if(guessNumber.get(index) == userGuess.get(index)) {
                ret++;
            }
        }

        return ret;
    }

    private int getBall(ArrayList<Integer> userGuess) {
        int ret = 0;
        for(int userIndex = 0;userIndex < 3;userIndex++) {
            int userDigit = userGuess.get(userIndex);
            ret += countUserDigitInAnswer(userIndex, userDigit);
        }

        return ret;
    }

    private int countUserDigitInAnswer(int userIndex, int userDigit) {
        int count = 0;
        for(int answerIndex = 0;answerIndex < 3;answerIndex++) {
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