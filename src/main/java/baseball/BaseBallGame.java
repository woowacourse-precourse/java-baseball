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
}
