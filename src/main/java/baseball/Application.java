package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

class Utils {
    public static List<Character> StringToCharList(String input) {
        List<Character> list = new ArrayList<>();
        for (char c : input.toCharArray()) {
            list.add(c);
        }
        return list;
    }

    public static HashSet<Character> StringToCharSet(String input) {
        HashSet<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            set.add(c);
        }
        return set;
    }

    public static void addOneToMap(HashMap<String, Integer> map, String key) {
        map.put(key, map.get(key) + 1);
    }
}


class Input {
    static final String GAME_GET_NUMBER = "숫자를 입력해주세요 : ";
    static final String EXCEPTION_REPETITION = "중복되는 숫자를 입력했습니다.";
    static final String EXCEPTION_CONTAINS_ZERO = "입력 값에 0이 포함됩니다.";
    static final String EXCEPTION_DIGITS_NOT_3 = "입력 값이 세 자리의 숫자가 아닙니다.";
    static final String EXCEPTION_NOT_NUMBER = "입력 값이 숫자가 아닙니다.";
    static final String EXCEPTION_NOT_1_OR_2 = "입력 값이 1이나 2가 아닙니다.";


    static void validInputInGame(String inputString) throws IllegalArgumentException {
        HashSet<Character> isRepeated = Utils.StringToCharSet(inputString);

        if (isRepeated.size() < 3) {
            System.out.println(EXCEPTION_REPETITION);
            throw new IllegalArgumentException();
        } else if (isRepeated.contains('0')) {
            System.out.println(EXCEPTION_CONTAINS_ZERO);
            throw new IllegalArgumentException();
        } else if (isRepeated.size() != 3) {
            System.out.println(EXCEPTION_DIGITS_NOT_3);
            throw new IllegalArgumentException();
        }
        for (char isInt : isRepeated) {
            int changed = isInt - '0';
            if ((changed > 9) || (changed < 0)) {
                System.out.println(EXCEPTION_NOT_NUMBER);
                throw new IllegalArgumentException();
            }
        }
    }

    static void validInputEndGame(String inputString) throws IllegalArgumentException {
        if (!(inputString.equals("1") || (inputString.equals("2")))) {
            System.out.println(EXCEPTION_NOT_1_OR_2);
            throw new IllegalArgumentException();
        }
    }

    static List<Character> getInputInGame() {
        System.out.print(GAME_GET_NUMBER);
        String input = Console.readLine();
        Input.validInputInGame(input);
        return Utils.StringToCharList(input);
    }

    static char getInputEndGame() throws IllegalArgumentException {
        String input = Console.readLine();
        validInputEndGame(input);
        return input.charAt(0);
    }
}


class Compare {
    static final String NOTHING = "낫싱";
    static final String BALL = "볼";
    static final String STRIKE = "스트라이크";

    static HashMap<String, Integer> compareWithAnswer(List<Character> answerList,
                                                      List<Character> userInputList) {
        HashMap<String, Integer> comparedMap = new HashMap<>();
        comparedMap.put(BALL, 0);
        comparedMap.put(STRIKE, 0);
        comparedMap.put(NOTHING, 1);
        for (int comparingNum = 0; comparingNum < 3; comparingNum++) {
            char answer = answerList.get(comparingNum);
            char input = userInputList.get(comparingNum);
            if (answerList.contains(input)) {
                comparedMap.put(NOTHING, 0);
                computeBallStrike(comparedMap, answer, input);
            }
        }
        return comparedMap;
    }

    static void computeBallStrike(HashMap<String, Integer> comparedMap,
                                  char answer, char input) {
        comparedMap.put(NOTHING, 0);
        if (answer == input) {
            Utils.addOneToMap(comparedMap, STRIKE);
        } else {
            Utils.addOneToMap(comparedMap, BALL);
        }
    }

    static boolean inputEqualsAnswer(HashMap<String, Integer> comparedMap) {
        return comparedMap.get(STRIKE) == 3;
    }
}


class Game {
    static final String NOTHING = "낫싱";
    static final String BALL = "볼";
    static final String STRIKE = "스트라이크";
    static final char CONTINUE_GAME = '1';
    static final char END_GAME = '2';
    static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    static final String GAME_RESTART_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    static final String GAME_CORRECT_ANSWER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    static List<Character> generateAnswer() {
        HashSet<Character> removeDuplication = new HashSet<>();
        while (removeDuplication.size() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);
            char randomChar = (char) (random + '0');
            removeDuplication.add(randomChar);
        }
        return new ArrayList<>(removeDuplication);
    }

    static void printResult(HashMap<String, Integer> comparedMap) {
        int balls = comparedMap.get(BALL);
        int strikes = comparedMap.get(STRIKE);

        if (comparedMap.get(NOTHING) != 0) {
            System.out.print(NOTHING);
        }
        if (comparedMap.get(BALL) != 0) {
            System.out.print(balls + BALL + " ");
        }
        if (comparedMap.get(STRIKE) != 0) {
            System.out.print(strikes + STRIKE);
        }
        System.out.print("\n");
    }

    static List<Character> startGame() {
        System.out.println(GAME_START);
        return generateAnswer();
    }

    static boolean restartOrEndGame() {
        boolean newGame;
        System.out.println(GAME_RESTART_OR_END);
        char userInput = Input.getInputEndGame();

        if (userInput == CONTINUE_GAME) {
            newGame = true;
        } else if (userInput == END_GAME) {
            newGame = false;
        } else {
            newGame = false;
        }
        return newGame;
    }

    static boolean userGotAnswer(List<Character> answer) {
        boolean userGotAnswer;
        HashMap<String, Integer> comparedMap = Compare.compareWithAnswer(answer, Input.getInputInGame());
        Game.printResult(comparedMap);
        if (Compare.inputEqualsAnswer(comparedMap)) {
            System.out.println(GAME_CORRECT_ANSWER);
            userGotAnswer = true;
        } else {
            userGotAnswer = false;
        }
        return userGotAnswer;
    }

    static void playGame() {
        boolean newGame = true;
        while (newGame) {
            List<Character> answer = Game.startGame();
            boolean userGotAnswer = false;
            while (!userGotAnswer) {
                userGotAnswer = userGotAnswer(answer);
            }
            newGame = Game.restartOrEndGame();
        }
    }
}

public class Application {
    public static void main(String[] args) {
        Game.playGame();
    }
}
