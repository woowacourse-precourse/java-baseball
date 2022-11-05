package baseball;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class Game {
    final static String GAME_START_GUIDE_MESSAGE = "숫자 야구 게임을 시작합니다.";
    final static String PLAYER_INPUT_GUIDE_MESSAGE = "숫자를 입력해주세요 : ";
    final static int NUMBER_LENGTH = 3;
    private Computer computer;

    Game() {
        this.computer = new Computer();
    }

    public void play() {
        printGuideMessage(GAME_START_GUIDE_MESSAGE);
    }

    public void printGuideMessage(String guideMessage) {
        System.out.println(guideMessage);
    }

    public String getGamePlayerInput() {
        printGuideMessage(PLAYER_INPUT_GUIDE_MESSAGE);

        return Console.readLine();
    }

    public void checkGamePlayerNumberInput(String gamePlayerNumberInput) {
        checkNumberLength(gamePlayerNumberInput);
        hasSameNumber(gamePlayerNumberInput);
        hasCharacters(gamePlayerNumberInput);
    }

    private void checkNumberLength(String stringGamePlayerInput) {
        int stringLength =  stringGamePlayerInput.length();
        if (stringLength > NUMBER_LENGTH || stringLength < 1) {
            throw new IllegalArgumentException();
        }
    }

    private void hasSameNumber(String gamePlayerInput) {
        for (int stringIndex = 0; stringIndex < NUMBER_LENGTH; stringIndex++) {
            if (gamePlayerInput.lastIndexOf(gamePlayerInput.charAt(stringIndex)) != stringIndex) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void hasCharacters(String gamePlayerInput) {
        String regex = "^[0-9]*$";
        if (!gamePlayerInput.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }
}

class Computer {
    final static int NUMBER_LENGTH = 3;
    private ArrayList<Integer> randomNumbers = new ArrayList<>(NUMBER_LENGTH);

    Computer() {
        while (randomNumbers.size() < NUMBER_LENGTH) {
            Integer newRandomNumber = pickRandomNumber();
            if (!has(newRandomNumber)) {
                randomNumbers.add(newRandomNumber);
            }
        }
    }

    public ArrayList<Integer> getRandomNumbers() {
        return this.randomNumbers;
    }

    private boolean has(Integer number) {
        if (this.randomNumbers.contains(number)) {
            return true;
        }
        return false;
    }

    private static Integer pickRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}