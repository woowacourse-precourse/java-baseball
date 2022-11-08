package baseball;

import java.util.HashMap;
import java.util.List;

public class BaseBallGame {
    public static final String GAME_START_MENT = "숫자 야구 게임을 시작합니다";

    public BaseBallGame() {
    }

    public void logic() throws IllegalArgumentException {
        Computer computer = new Computer();
        User user = new User();

        System.out.println(GAME_START_MENT);
        computer.createNumList();

        try {
            user.createNumList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

        HashMap<String, Integer> result = getResult(computer.getNumList(), user.getNumList());
        printResult(result);
    }

    private static HashMap<String, Integer> getResult(List<Integer> computerNumList, List<Integer> inputNumList) {
        HashMap<String, Integer> result = new HashMap<>();

        int strikeCnt = 0;
        int ballCnt = 0;

        for (int i=0; i<computerNumList.size(); i++) {
            if (computerNumList.get(i)==inputNumList.get(i)) {
                strikeCnt++;
                continue;
            }
            if (computerNumList.contains(inputNumList.get(i))) {
                ballCnt++;
            }
        }

        result.put("ball", ballCnt);
        result.put("strike", strikeCnt);

        return result;
    }

    private void printResult(HashMap<String, Integer> result) {
        if (result.get("ball")==0 & result.get("strike")==0) {
            System.out.println("낫싱");
        }
        if (result.get("ball")>0 & result.get("strike")>0) {
            System.out.println(result.get("ball")+"볼 "+ result.get("strike")+"스트라이크");
        }
        if (result.get("ball")==0 & result.get("strike")>0) {
            System.out.println(result.get("strike")+"스트라이크");
        }
        if (result.get("ball")>0 & result.get("strike")==0) {
            System.out.println(result.get("ball")+"볼");
        }
    }
}
