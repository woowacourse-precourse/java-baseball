package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다");

        while (true) {
            List<Integer> computerNumList = generateComputerNum();
            Boolean win = false;

            while (win == false) {
                String userNum = inputUserNum();
                List<Integer> userNumList = splitUserNumToList(userNum);
                String judgeStr = judge(computerNumList, userNumList);

                if (judgeStr.equals("3스트라이크")) {
                    break;
                }
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        }
    }

    public static String judge(List<Integer> computerNumList, List<Integer> userNumList) {
        //수만 같으면 ball,자릿수 까지 같으면 strike
        int ball = judgeBall(computerNumList, userNumList);
        int strike = judgeStrike(computerNumList, userNumList);

        if (ball != 0 && strike != 0) {
            return ball + "볼 " + strike + "스트라이크";
        }
        if (ball != 0) {
            return ball + "볼";

        }
        if (strike != 0) {
            return strike + "스트라이크";
        }

        return "낫싱";
    }

    public static int judgeBall(List<Integer> computerNumList, List<Integer> userNumList) {
        int ball = 0;
        for (int comDigit = 0; comDigit < 3; comDigit++) {
            if (isBall(computerNumList.get(comDigit), userNumList, comDigit)) {
                ball++;
            }
        }
        return ball;
    }

    private static boolean isBall(int computerNum, List<Integer> userNumList, int comDigit) {
        for (int userDigit = 0; userDigit < 3; userDigit++) {
            if (computerNum == userNumList.get(userDigit) && comDigit != userDigit) {
                return true;
            }
        }
        return false;
    }


    public static int judgeStrike(List<Integer> computerNumList, List<Integer> userNumList) {
        int strike = 0;
        for (int digit = 0; digit < 3; digit++) {
            if (computerNumList.get(digit) == userNumList.get(digit)) {
                strike++;
            }
        }
        return strike;
    }


    public static List<Integer> splitUserNumToList(String userNum) {
        List<Integer> userNumList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            userNumList.add(userNum.charAt(i) - '0');
        }

        return userNumList;
    }

    public static String inputUserNum() {
        System.out.println("숫자를 입력해주세요:");
        String userNumStr = readLine();

        try {
            Integer.parseInt(userNumStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (userNumStr.length() != 3) {
            throw new IllegalArgumentException();
        }

        return userNumStr;
    }


    public static List<Integer> generateComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);
            computerNum.add(random);
        }
        return computerNum;
    }


}
