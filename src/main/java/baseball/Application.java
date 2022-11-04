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
            String userNum = inputUserNum();
            List<Integer> userNumList = splitUserNumToList(userNum);

        }
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
