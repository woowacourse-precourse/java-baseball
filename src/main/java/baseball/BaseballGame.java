package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private static RandomNumber target;
    private static RandomNumber num;
    private static List<Integer> targetlist;
    private static List<Integer> numlist;

    private static final String regexCode = "^[1-2]$";

    public BaseballGame() {
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int gameCode = 1;

        while (gameCode != 2) {
            target = new RandomNumber();
            target.createRandomNumber();
            targetlist = new ArrayList<>(target.getRandomNumberList());

            while (true) {
                System.out.println("숫자를 입력해주세요 : ");
                num = new RandomNumber();
                num.checkInput();
                numlist = new ArrayList<>(num.getRandomNumberList());
                String compareResultStr = compareNumber();
                System.out.println(compareResultStr);
                if (compareResultStr.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            while (true) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String codeStr = Console.readLine();
                if (checkGameCode(codeStr)) {
                    gameCode = Integer.parseInt(codeStr);
                    break;
                }
                System.out.println("1과 2 중에 다시 입력해주세요.");
            }
        }

    }

    private static String compareNumber() {
        String resStr = "";
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int computerNum = targetlist.get(i);
            int userNum = numlist.get(i);

            if (computerNum == userNum) {
                strike++;
            } else if (targetlist.contains(userNum)) {
                ball++;
            }
        }

        if (ball == 0 && strike == 0) {
            resStr = "낫싱";
        }
        if (ball != 0) {
            resStr = ball + "볼 ";
        }
        if (strike != 0) {
            resStr += strike + "스트라이크";
        }

        return resStr;
    }

    private static boolean checkGameCode(String gameCodeStr) {
        if (gameCodeStr.matches(regexCode)) {
            return true;
        }
        return false;
    }

}
