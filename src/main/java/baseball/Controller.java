package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseball.Rule.DIGITS;
import static baseball.Rule.COMMAND_RESTART;
import static baseball.Rule.COMMAND_END;


public class Controller {

    private List<Integer> computerNumber;
    private boolean isPlaying = true;

    private static final String STRIKE ="strike";
    private static final String STRIKE_KOR ="스트라이크";
    private static final String BALL ="ball";
    private static final String BALL_KOR ="볼";
    private static final String NOTHING ="nothing";
    private static final String NOTHING_KOR ="낫싱";
//    private static final int DIGITS = Rule.DIGITS.getValue();
//    private static final String COMMAND_RESTART = Rule.COMMAND_RESTART.toString();
//    private static final String COMMAND_END = Rule.COMMAND_END.toString();
    private final View view = new View();
    private final Model model = new Model();

//    public void generate() {
//        View.printStart();
//        do{
//            List<Integer> computerNumber = Model.createComputerNumber();
//            play(computerNumber);
//            String exitInput = View.getExitInput();
//            restartOrEnd(exitInput);
//        }while (isPlaying);
//
//    }
//
//    public void play(List<Integer> computerNumber){
//        Map<String, Integer>resultMap;
//        do {
////            System.out.println(computerNumber);
//            List<Integer> playerNumber = Model.createPlayerNumber();           //유효하지 않으면 예외발생
//            resultMap = checkAnswer(computerNumber, playerNumber);
//            View.printHint(createHint(resultMap));
//        }while(!isCorrect(resultMap));
//    }

    public void generate() {
        view.printStart();
        computerNumber = model.createComputerNumber();
        do {
            List<Integer> playerNumber = model.createPlayerNumber();           //유효하지 않으면 예외발생
            Map<String, Integer>resultMap = checkAnswer(computerNumber, playerNumber);
            view.printHint(createHint(resultMap));
            if (isCorrect(resultMap)) {
                String exitInput = view.getExitInput(); //예외발생
                restartOrEnd(exitInput);
            }
        }while(isPlaying);
    }

    public Map<String, Integer> checkAnswer(List<Integer> computerNumber, List<Integer> playerNumber) {
        Map<String, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < DIGITS ; i++) {
            if (computerNumber.contains(playerNumber.get(i))) {
                checkBallOrStrike(computerNumber.get(i), playerNumber.get(i), resultMap);
                continue;
            }
            int oldValue = resultMap.getOrDefault(NOTHING, 0);
            resultMap.put(NOTHING, oldValue + 1);
        }
        return resultMap;
    }

    //볼인지 스트라이크인지 확인하기
    public void checkBallOrStrike(Integer computerNum, Integer playerNum, Map<String, Integer> resultMap) {
        if (computerNum.equals(playerNum)) {
            int oldValue = resultMap.getOrDefault(STRIKE, 0);
            resultMap.put(STRIKE, oldValue + 1);
            return;
        }
        int oldValue = resultMap.getOrDefault(BALL, 0);
        resultMap.put(BALL, oldValue + 1);
    }

    public String createHint(Map<String, Integer> resultMap) {
        List<String> answer = new ArrayList<>();
        if (resultMap.containsKey(BALL)) {
            answer.add(String.format("%d%s", resultMap.get(BALL), BALL_KOR));
        }
        if (resultMap.containsKey(STRIKE)) {
            answer.add(String.format("%d%s", resultMap.get(STRIKE), STRIKE_KOR));
        }
        if (resultMap.containsKey(NOTHING)
                && resultMap.get(NOTHING) == DIGITS) {
            answer.add(NOTHING_KOR);
        }

        return String.join(" ", answer).trim();
    }

    public boolean isCorrect(Map<String, Integer> resultMap) {
        return resultMap.containsKey(STRIKE) && resultMap.get(STRIKE) == DIGITS;
    }

    public void restartOrEnd(String input) {
        if (input.equals(COMMAND_RESTART)) {
            computerNumber = model.createComputerNumber();
        }
        if (input.equals(COMMAND_END)) {
            isPlaying = false;
        }
    }

}
