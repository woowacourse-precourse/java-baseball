package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import camp.nextstep.edu.missionutils.*;
import java.util.Map;
import java.util.Scanner;

public class Application {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void getComputersRandomNumber(List<Integer> computersNumber) {
        while (computersNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computersNumber.contains(randomNumber)) {
                computersNumber.add(randomNumber);
            }
        }
    }

    public static void getUsersInputNumber(List<Integer> usersNumber) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = sc.next();
        if (input.length() > 3) {
            throw new IllegalArgumentException();
        }
        //각 자리수를 옮겨담는다.
        for (int i = 0; i < 3; i++) {
            char eachDigit = input.charAt(i);
            usersNumber.add((Character.getNumericValue(eachDigit)));
        }
    }

    //digitPosition -> 0,1,2 인덱스를 이용하여 백의자리, 십의자리 일의자리를 접근한다.
    //해당 자리의 값끼리 비교해서 Strike를 체크하고 아니라면 포함여부를 확인하여 Ball인지 체크한다.
    public static void checkEachDigit(List<Integer> computersNumber, List<Integer> usersNumber,
        Map<String, Integer> strikeBallCount, int digitPosition) {
        if (digitPosition == 3) {
            return;
        }
        int computersCurrentPositionDigit = computersNumber.get(digitPosition);
        int usersCurrentPositionDigit = usersNumber.get(digitPosition);
        if (computersCurrentPositionDigit == usersCurrentPositionDigit) { // 숫자가 같다면 Strike값 증가
            strikeBallCount.put("Strike", strikeBallCount.get("Strike") + 1);
        } else if (computersNumber.contains(
            usersCurrentPositionDigit)) { //숫자가 같지않다면 수에 해당 숫자가 존재하는지 체크 , 있다면 Ball값 증가
            strikeBallCount.put("Ball", strikeBallCount.get("Ball") + 1);
        }
        checkEachDigit(computersNumber, usersNumber, strikeBallCount, digitPosition + 1);
    }

    public static int checkStrikeBallCount(Map<String, Integer> strikeBallCount) {
        StringBuilder sb = new StringBuilder();
        int strikeCount = strikeBallCount.get("Strike");
        int ballCount = strikeBallCount.get("Ball");
        int input = 0;
        if (ballCount != 0) {
            sb.append(ballCount + "볼 ");
        }
        if (strikeCount != 0) {
            sb.append(strikeCount + "스트라이크");
        }
        if (ballCount == 0 && strikeCount == 0) {
            sb.append("낫싱");
        }
        System.out.println(sb.toString());

        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            input = sc.nextInt();
        }
        return input;
    }

    public static int playOneCycle(List<Integer> computersNumber) {
        List<Integer> usersNumber = new ArrayList<>();
        getUsersInputNumber(usersNumber);
        Map<String, Integer> strikeBallCount = new HashMap<>() {
            {
                put("Strike", 0);
                put("Ball", 0);
            }
        }; // 스트라이크와 볼 값을 저장할변수
        checkEachDigit(computersNumber, usersNumber, strikeBallCount, 0);
        return checkStrikeBallCount(strikeBallCount);
    }

    public static int playOneGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computersNumber = new ArrayList<>();
        getComputersRandomNumber(computersNumber);
        int oneCycleResult;
        do {
            oneCycleResult = playOneCycle(computersNumber);
        } while (oneCycleResult == 0);
        return oneCycleResult;
    }
}
