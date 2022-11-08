package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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

        if (comparedMap.get(BALL) != 0) {
            System.out.print(balls + BALL + " ");
        }
        if (comparedMap.get(STRIKE) != 0) {
            System.out.print(strikes + STRIKE);
        }
        if ((comparedMap.get(BALL) == 0)&&(comparedMap.get(STRIKE) == 0)) {
            System.out.print(NOTHING);
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
