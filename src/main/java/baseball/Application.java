package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    private static List<Integer> generateRandomNoDuplication3Numbers() {
        HashSet<Integer> removeDuplication = new HashSet<>();
        while (removeDuplication.size() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);
            removeDuplication.add(random);
        }
        return new ArrayList<>(removeDuplication);
    }

    private static List<Integer> startGame() {
        return generateRandomNoDuplication3Numbers();
    }

    private static List<Integer> seperate3Numbers(int input)
            throws IllegalArgumentException {
        List<Integer> separated = new ArrayList<>();
        for (int i = 2; i >= 0; i--) {
            int digit = input / (int) Math.pow(10, i);
            input = input % (int) Math.pow(10, i);
            separated.add(digit);
        }
        HashSet<Integer> isRepeated = new HashSet<>(separated);
        if (isRepeated.size() < 3) {
            throw new IllegalArgumentException();
        } else if (isRepeated.contains(0)) {
            throw new IllegalArgumentException();
        }
        return separated;
    }


    static final int NOTHING = 0;
    static final int BALL = 1;
    static final int STRIKE = 2;

    private static HashMap<Integer, Integer> checkBallOrStrike(List<Integer> answerList,
                                                               List<Integer> userInputList) {
        HashMap<Integer, Integer> comparedMap = new HashMap<>();
        comparedMap.put(BALL, 0);
        comparedMap.put(STRIKE, 0);
        comparedMap.put(NOTHING, 1);
        for (int comparingNum = 0; comparingNum < 3; comparingNum++) {
            int answer = answerList.get(comparingNum);
            int input = userInputList.get(comparingNum);
            if (answerList.contains(input)) {
                comparedMap.put(NOTHING, 0);
                comparedMap = ballOrStrike(comparedMap, answer, input);
            }
        }
        return comparedMap;
    }

    private static boolean isStrike(int answer, int input) {
        return answer == input;
    }

    private static HashMap<Integer, Integer> ballOrStrike(HashMap<Integer, Integer> comparedMap,
                                                          int answer, int input) {
        comparedMap.put(NOTHING, 0);
        if (isStrike(answer, input)) {
            addOneToMap(comparedMap, STRIKE);
        } else {
            addOneToMap(comparedMap, BALL);
        }
        return comparedMap;
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

    private static List<Integer> getAndSeperateInput() {
        int userInput = getUserIntInGame();
        return seperate3Numbers(userInput);
    }

    private static Integer getUserIntInGame()
            throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String input= Console.readLine();
        int inputInt=Integer.valueOf(input);
        if ((inputInt < 100) || (inputInt > 999)) {
            throw new IllegalArgumentException();
        }
        return inputInt;
    }

    private static Integer getUserIntEndGame()
            throws IllegalArgumentException {
        String input= Console.readLine();
        int inputInt=Integer.valueOf(input);
        if ((inputInt != 1) && (inputInt != 2)) {
            throw new IllegalArgumentException();
        }
        return inputInt;
    }

    private static boolean restartOrEndGame() {
        boolean newGame = true;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userInput = getUserIntEndGame();
        if (userInput == CONTINUE_GAME) {
            newGame = true;
        } else if (userInput == END_GAME) {
            newGame = false;
        }
        //else 예외사항 추가
        return newGame;
    }

    static final int CONTINUE_GAME = 1;
    static final int END_GAME = 2;

    private static boolean playGame(List<Integer> answer) {
        boolean gameOn;
        List<Integer> separatedInput = getAndSeperateInput();
        HashMap<Integer, Integer> comparedMap = checkBallOrStrike(answer, separatedInput);
        printResult(comparedMap);
        if (correctAnswer(comparedMap)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
                System.out.println("숫자 야구 게임을 시작합니다.");
                List<Integer> answer = startGame();
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
