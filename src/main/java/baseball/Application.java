package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static final int NOTHING = 0;
    static final int BALL = 1;
    static final int STRIKE = 2;
    static final String GAME_START="숫자 야구 게임을 시작합니다.";
    static final String GAME_GET_NUMBER="숫자를 입력해주세요 : ";
    static final String EXCEPTION_REPETITION="중복되는 숫자를 입력했습니다.";
    static final String EXCEPTION_CONTAINS_ZERO="중복되는 숫자를 입력했습니다.";
    static final String EXCEPTION_DIGITS_NOT_3="중복되는 숫자를 입력했습니다.";
    static final String EXCEPTION_NOT_NUMBER="입력 값이 숫자가 아닙니다.";
    static final String EXCEPTION_NOT_1_OR_2="입력 값이 1이나 2가 아닙니다.";
    static final String GAME_RESTART_OR_END="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    static final String GAME_CORRECT_ANSWER="3개의 숫자를 모두 맞히셨습니다! 게임 종료";


    private static List<Character> generateRandomNoDuplication3Numbers() {
        HashSet<Character> removeDuplication = new HashSet<>();
        while (removeDuplication.size() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);
            char randomChar = (char) (random + '0');
            removeDuplication.add(randomChar);
        }
        return new ArrayList<>(removeDuplication);
    }

    private static List<Character> startGame() {
        return generateRandomNoDuplication3Numbers();
    }



    private static HashMap<Integer, Integer> checkBallOrStrike(List<Character> answerList,
                                                               List<Character> userInputList) {
        HashMap<Integer, Integer> comparedMap = new HashMap<>();
        comparedMap.put(BALL, 0);
        comparedMap.put(STRIKE, 0);
        comparedMap.put(NOTHING, 1);
        for (int comparingNum = 0; comparingNum < 3; comparingNum++) {
            char answer = answerList.get(comparingNum);
            char input = userInputList.get(comparingNum);
            if (answerList.contains(input)) {
                comparedMap.put(NOTHING, 0);
                ballOrStrike(comparedMap, answer, input);
            }
        }
        return comparedMap;
    }

    private static void ballOrStrike(HashMap<Integer, Integer> comparedMap,
                                     char answer, char input) {
        comparedMap.put(NOTHING, 0);
        if (answer == input) {
            addOneToMap(comparedMap, STRIKE);
        } else {
            addOneToMap(comparedMap, BALL);
        }
    }

    private static void addOneToMap(HashMap<Integer, Integer> map, int key) {
        int oldNumber = map.get(key);
        map.put(key, oldNumber + 1);
    }

    private static boolean correctAnswer(HashMap<Integer, Integer> comparedMap) {
        return comparedMap.get(STRIKE) == 3;
    }

    private static void printResult(HashMap<Integer, Integer> comparedMap) {
        int balls = comparedMap.get(BALL);
        int strikes = comparedMap.get(STRIKE);

        if (comparedMap.get(NOTHING) != 0) {
            System.out.print("낫싱");
        }
        if (comparedMap.get(BALL) != 0) {
            System.out.printf("%d볼 ", balls);
        }
        if (comparedMap.get(STRIKE) != 0) {
            System.out.printf("%d스트라이크", strikes);
        }
        System.out.print("\n");
    }

    private static void checkInput(String inputString) throws IllegalArgumentException {
        HashSet<Character> isRepeated = StringToCharSet(inputString);

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

    private static List<Character> StringToCharList(String input) {
        List<Character> list = new ArrayList<>();
        for (char c : input.toCharArray()) {
            list.add(c);
        }
        return list;
    }

    private static HashSet<Character> StringToCharSet(String input) {
        HashSet<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            set.add(c);
        }
        return set;
    }

    private static List<Character> getInputInGame()
            throws IllegalArgumentException {
        System.out.print(GAME_GET_NUMBER);
        String input = Console.readLine();
        checkInput(input);
        return StringToCharList(input);
    }

    private static char getInputEndGame() {
        String input = Console.readLine();
        return input.charAt(0);
    }

    private static boolean restartOrEndGame() throws IllegalArgumentException {
        boolean newGame;
        System.out.println(GAME_RESTART_OR_END);
        int userInput = getInputEndGame();
        if (userInput == CONTINUE_GAME) {
            newGame = true;
        } else if (userInput == END_GAME) {
            newGame = false;
        } else {
            System.out.println(EXCEPTION_NOT_1_OR_2);
            throw new IllegalArgumentException();
        }
        return newGame;
    }

    static final int CONTINUE_GAME = 1;
    static final int END_GAME = 2;

    private static boolean playGame(List<Character> answer) {
        boolean gameOn;
        List<Character> separatedInput = getInputInGame();
        HashMap<Integer, Integer> comparedMap = checkBallOrStrike(answer, separatedInput);
        printResult(comparedMap);
        if (correctAnswer(comparedMap)) {
            System.out.println(GAME_CORRECT_ANSWER);
            gameOn = false;
        } else {
            gameOn = true;
        }
        return gameOn;
    }

    public static void main(String[] args) {
        try {
            boolean newGame = true;
            while (newGame) {
                System.out.println(GAME_START);
                List<Character> answer = startGame();
//                System.out.println(answer);
                boolean gameOn = true;
                while (gameOn) {
                    gameOn = playGame(answer);
                }
                newGame = restartOrEndGame();
            }
        } catch (IllegalArgumentException e) {
            System.exit(0);
        }
    }
}
