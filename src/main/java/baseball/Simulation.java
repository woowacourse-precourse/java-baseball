package baseball;

import baseball.View.User;
import baseball.Model.Computer;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    static final String START_MSG = "숫자 야구 게임을 시작합니다.";
    static final String END_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    Computer computer = new Computer();
    User user = new User();
    public void simulate() {
        List<Integer> randomNumList = computer.createNumber();

        while (true) {
            List<Integer> inputNumList = user.inputNumber();

            List<Integer> strikeBallList = checkStrikeBall(randomNumList, inputNumList);
            String result = getResult(strikeBallList);
            System.out.println(result);
            if (strikeBallList.get(0) == 3) {
                System.out.println(END_MSG);
                break;
            }
        }
        reSimulate();
    }


    public List<Integer> checkStrikeBall(List<Integer> randomNumList, List<Integer> inputNumList) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNumList.get(i) == inputNumList.get(i)) {
                strike++;
            } else if (randomNumList.contains(inputNumList.get(i))) {
                ball++;
            }
        }
        List<Integer> tmpResult = new ArrayList<>(List.of(strike, ball));
        return tmpResult;
    }

    public String getResult(List<Integer> strikeBallList) {
        int strike = strikeBallList.get(0);
        int ball = strikeBallList.get(1);
        String strResult = "낫싱";
        if (strike == 0) {
            if (ball != 0) {
                strResult = ball + "볼";
            }
        } else {
            if (ball != 0) {
                strResult = ball + "볼 " + strike + "스트라이크";
            } else {
                strResult = strike + "스트라이크";
            }
        }
        return strResult;
    }

    public void reSimulate() {
        String inputCheck = Console.readLine();
        if (inputCheck.equals("1")) {
            simulate();
        }
    }
}
