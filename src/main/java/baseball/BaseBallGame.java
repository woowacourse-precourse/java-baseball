package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;

public class BaseBallGame {
    public static final String GAME_START_MENT = "숫자 야구 게임을 시작합니다";
    public static final String RIGHT_ANS_MENT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public BaseBallGame() {
    }

    public void logic() throws IllegalArgumentException {
        Computer computer = new Computer();
        User user = new User();

        System.out.println(GAME_START_MENT);
        computer.createNumList();

        while(true) {
            try {
                user.createNumList();
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }

            HashMap<String, Integer> result = getResult(computer.getNumList(), user.getNumList());
            printResult(result);

            if (result.get("strike")==3) {
                System.out.print(RIGHT_ANS_MENT);
                int choice = Integer.parseInt(Console.readLine());
                if (choice == 2) {
                    break;
                }
                computer.createNumList();
            }
        }
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
