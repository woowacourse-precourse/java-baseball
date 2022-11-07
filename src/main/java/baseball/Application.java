package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        List<Integer> randomNumList = makeRandomNum();
        List<Integer> inputNumList = makeInputNumList();
    }
    public static List<Integer> makeRandomNum() {
        List<Integer> randomNumList = new ArrayList<>();
        while(randomNumList.size() < 3) {
            int newRandomNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNumList.contains(newRandomNum)) {
                randomNumList.add(newRandomNum);
            }
        }
        return randomNumList;
    }
    public static List<Integer> makeInputNumList() {
        System.out.print("숫자를 입력해주세요 : ");

        String inputString = Console.readLine();

        List<Integer> inputNumList = new ArrayList<>();
        for (int inputStringIdx = 0; inputStringIdx < inputString.length(); inputStringIdx++) {
            int nowIdxNum = (int) inputString.charAt(inputStringIdx) - 48;
            inputNumList.add(nowIdxNum);
        }
        return inputNumList;
    }
}
