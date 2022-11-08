package runGame;

import baseball.generator.GenerateGameNumber;
import baseball.message.OutputMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 */
public class GameStarter {

    private final int START_NUM = 1;
    private final int EXIT_NUM = 2;

    private static OutputMessage outputMessage = new OutputMessage();

    public void GameStarter() {
    }

    public void start() {
        // 시작 메시지 출력
        outputMessage.startMessage();
        // 게임 시작
        playGame();
    }

    public static void playGame() {
        int strikeCount = 0;
        // 컴퓨터 난수 생성
        List<Integer> comBallList = new GenerateGameNumber().getGenerateNumerList();

        do {
            // 사용자 입력 생성
            List<Integer> userBallList = getUserInputValue();

            // isStrikeOut();
        } while(strikeCount != 0);
    }

    public static List<Integer> getUserInputValue() throws IllegalArgumentException {
        outputMessage.userInputMessage();
        String input = Console.readLine();
        /**
         * 예외처리 구현
         */
        return null;
    }

    public static List<Integer> userInputToList(String userInput) {
        List<Integer> userInputList = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            userInputList.add((int) userInput.charAt(i));
        }
        return userInputList;
    }



    public static void isCorrect(int userInput, int comInput) {
        LinkedHashMap<Integer, Integer> userMap = inputToMap(String.valueOf(userInput));
        LinkedHashMap<Integer, Integer> comMap = inputToMap(String.valueOf(comInput));

        StringBuilder sb = new StringBuilder();

        int strike = 0, ball = 0, nothing = 0;

        for (int i = 0; i < 3; i++) {
            if (comMap.containsValue(userMap.get(i))) {
                if (userMap.get(i) == comMap.get(i)) {
                    strike++;
                    ball--;
                } else {
                    ball++;
                }
            }
        }

        if (ball > 0) {
            sb.append(ball).append("볼").append(" ");
        } else if (strike > 0) {
            sb.append(strike).append("스트라이크").append(" ");
        } else {
            sb.append("낫싱");
        }

        System.out.println(sb.toString());
    }

    /**
     * 숫자와 위치정보를 담은 Map을 반환한다.
     *
     * @param {Integer} baseBallNumber return {Map<Integer, Integer>}
     */
    public static LinkedHashMap<Integer, Integer> inputToMap(String num) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < 3; i++) {
            map.put(Integer.parseInt(num.split("")[i]), i);
        }
        return map;
    }

}
