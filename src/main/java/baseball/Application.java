package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Console.*;


public class Application {

    private static final int BASEBALLGAME_ON = 1;

    private static final int BASEBALLGAME_OFF = 2;


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameStatus status = new GameStatus(true);


        while (status.isOn()) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            BaseballReferee referee = new BaseballReferee(new BaseballInput(computer));
            while (true) {
                System.out.print("숫자를 입력해주세요. : ");
                String inputData = readLine();
                BaseballOutput judge = referee.judge(new BaseballInput(inputData));
                StringBuilder sb = new StringBuilder();
                if (judge.getBall() != 0) {
                    sb.append(judge.getBall());
                    sb.append("볼 ");
                }

                if (judge.getStrike() != 0) {
                    sb.append(judge.getStrike());
                    sb.append("스트라이크");
                }
                if (sb.length() == 0) {
                    sb.append("낫싱");
                }

                System.out.println(sb);
                if (judge.getStrike() == 3) {
                    break;
                }

            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String gameOption = readLine();
            if (!(gameOption.equals("1") || gameOption.equals("2"))) {
                throw new IllegalArgumentException("게임 옵션을 잘못 입력하였습니다.");
            }
            status.change(gameOption);

        }
        System.out.println("게임 종료");

    }


}

