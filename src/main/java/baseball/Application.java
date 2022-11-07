package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> getRandomThreeNumbers() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }

    public static boolean getResult(List<Integer> computerNumbersList, List<Integer> userNumbersList) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(computerNumbersList.get(i), userNumbersList.get(i))) {
                strikeCount++;
            }
            if (!Objects.equals(computerNumbersList.get(i), userNumbersList.get(i))
                    && computerNumbersList.contains(userNumbersList.get(i))) {
                ballCount++;
            }
        }
        printResult(strikeCount, ballCount);
        return strikeCount == 3;
    }

    public static void printResult(int strikeCount, int ballCount) {
        if (strikeCount != 0 && ballCount != 0) {
            System.out.println(strikeCount + "스트라이크 " + ballCount + "볼");
        } else if (strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (ballCount != 0) {
            System.out.println(ballCount + "볼");
        } else {
            System.out.println("낫싱");
        }
    }
}
