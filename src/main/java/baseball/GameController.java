package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController {

    private static List<Integer> computerNumber;
    private static boolean isPlaying = true;
    private static final String STRIKE ="strike";
    private static final String STRIKE_KOR ="스트라이크";
    private static final String BALL ="ball";
    private static final String BALL_KOR ="볼";
    private static final String NOTHING ="nothing";
    private static final String NOTHING_KOR ="낫싱";

    private static final int DIGITS = GameRule.DIGITS.getValue();
    private static final String COMMAND_RESTART = GameRule.COMMAND_RESTART.getValue()+"";
    private static final String COMMAND_END = GameRule.COMMAND_END.getValue()+"";

    public void generate() {
        //1. 컴퓨터 수 생성
        computerNumber = GameModel.createComputerNumber();
        do {
            //2.플레이어수 생성(예외)
            List<Integer> playerNumber = GameModel.createPlayerNumber();
            //3. 플레이어 수 비교하기
            Map<String, Integer> resultMap = checkAnswer(computerNumber, playerNumber);
            //4.힌트 출력하기
            View.printHint(createHint(resultMap));
            //5.정답확인하기 (예외)
            if (isCorrect(resultMap)) {
                String exitInput = View.getExitInput();
                restartOrEnd(exitInput);
            }
        }while(isPlaying);
    }

    public static Map<String, Integer> checkAnswer(List<Integer> computerNumber, List<Integer> playerNumber) {
        Map<String, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < computerNumber.size(); i++) { //세자리 수 비교
            if (computerNumber.contains(playerNumber.get(i))) { //포함하는지
                checkBallOrStrike(computerNumber.get(i), playerNumber.get(i), resultMap);
                continue;
            }
            int oldValue = resultMap.getOrDefault(NOTHING, 0);
            resultMap.put(NOTHING, oldValue + 1);

        }
        return resultMap;
    }

    //4-1. 볼인지 스트라이크인지 확인하기
    public static void checkBallOrStrike(Integer computerNum, Integer playerNum, Map<String, Integer> resultMap) {
        if (computerNum.equals(playerNum)) { //일치하는지
            int oldValue = resultMap.getOrDefault(STRIKE, 0);
            resultMap.put(STRIKE, oldValue + 1);
            return;
        }
        int oldValue = resultMap.getOrDefault(BALL, 0);
        resultMap.put(BALL, oldValue + 1);
    }

    public static String createHint(Map<String, Integer> resultMap) {
        List<String> answer = new ArrayList<>();
        if (resultMap.containsKey(BALL)) {
            answer.add(String.format("%d%s", resultMap.get(BALL), BALL_KOR));
        }
        if (resultMap.containsKey(STRIKE)) {
            answer.add(String.format("%d%s", resultMap.get(STRIKE), STRIKE_KOR));
        }
        if (resultMap.containsKey(NOTHING)
                && resultMap.get(NOTHING).equals(DIGITS)) {
            answer.add(NOTHING_KOR);
        }

        return String.join(" ", answer).trim();
    }

    public static boolean isCorrect(Map<String, Integer> resultMap) {
        return resultMap.containsKey(STRIKE) && resultMap.get(STRIKE) == DIGITS;
    }

    public static void restartOrEnd(String input) {
        if (input.equals(COMMAND_RESTART)) {
            computerNumber = GameModel.createComputerNumber();
        }
        if (input.equals(COMMAND_END)) {
            isPlaying = false;
        }
    }
}
