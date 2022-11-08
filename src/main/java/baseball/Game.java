package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    public Map<String, Integer> result;

    public Game() {
        result = new HashMap<>();
        result.put("strike", 0);
        result.put("ball", 0);
    }

    public void startGame() throws IllegalArgumentException {
        Computer computer = new Computer();
        Player player = new Player();

        computer.makeRandomNumber();

        while (true) {
            // result 초기화
            resetResult();

            // 사용자로부터 숫자 입력받기(입력 받는 값에 따라 예외 처리)
            try {
                player.inputNumber();
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }

            compareNumbers(computer.myNumberList, player.myInputNumber);

            String printResult = printCompareResult();

            if (printResult.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public void resetResult() {
        result.replace("strike", 0);
        result.replace("ball", 0);
    }

    public void compareNumbers(List<Integer> comNum, List<Integer> userNum) {
        for (int i = 0; i < 3; i++) {
            int eachUserNum = userNum.get(i);
            int eachComNum = comNum.get(i);

            if (eachComNum == eachUserNum) {
                //System.out.println("스트라이크");
                result.replace("strike", result.get("strike") + 1);
                continue;
            }

            if (comNum.contains(eachUserNum)) {
                //System.out.println("볼");
                result.replace("ball", result.get("ball") + 1);
                continue;
            }
        }
    }

    public String printCompareResult() {
        if (result.get("strike") == 0 && result.get("ball") == 0) {
            System.out.println("낫싱");
            return "낫싱";
        }

        if (result.get("strike") == 0 && result.get("ball") == 1) {
            System.out.println("1볼");
            return "1볼";
        }

        if (result.get("strike") == 0 && result.get("ball") == 2) {
            System.out.println("2볼");
            return "2볼";
        }

        if (result.get("strike") == 0 && result.get("ball") == 3) {
            System.out.println("3볼");
            return "3볼";
        }

        if (result.get("strike") == 1 && result.get("ball") == 0) {
            System.out.println("1스트라이크");
            return "1스트라이크";
        }

        if (result.get("strike") == 1 && result.get("ball") == 1) {
            System.out.println("1볼 1스트라이크");
            return "1볼 1스트라이크";
        }

        if (result.get("strike") == 1 && result.get("ball") == 2) {
            System.out.println("2볼 1스트라이크");
            return "2볼 1스트라이크";
        }

        if (result.get("strike") == 2 && result.get("ball") == 0) {
            System.out.println("2스트라이크");
            return "2스트라이크";
        }

        if (result.get("strike") == 2 && result.get("ball") == 1) {
            System.out.println("1볼 2스트라이크");
            return "1볼 2스트라이크";
        }

        if (result.get("strike") == 3 && result.get("ball") == 0) {
            System.out.println("3스트라이크");
            return "3스트라이크";
        }

        return "";
    }
}
