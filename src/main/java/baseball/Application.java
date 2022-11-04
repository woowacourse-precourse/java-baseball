package baseball;

import java.util.ArrayList;

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
    { System.out.println(GAME_START_GUIDE_MESSAGE); }

    Game() {
        this.computer = new Computer();
    }

    public ArrayList<Integer> getGamePlayerInput() {
        System.out.print(PLAYER_INPUT_GUIDE_MESSAGE);

        ArrayList<Integer> gamePlayerRandomNumbers = new ArrayList<>(NUMBER_LENGTH);
        for (int numberOfRandomNumbers = 0; numberOfRandomNumbers < NUMBER_LENGTH; numberOfRandomNumbers++) {
            gamePlayerRandomNumbers.add(Integer.parseInt(Console.readLine()));
        }

        return gamePlayerRandomNumbers;
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