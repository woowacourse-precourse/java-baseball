package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }


    // 6. 게임 진행
    public static boolean startGame() {
        List<Integer> computer = computerNumber();
//        System.out.println(computer);
        String baseballResult = "";
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String userNum = userNumber();
            List<Integer> user = userNumberIsValid(userNum);
            baseballResult = result(computer, user);
            System.out.println(baseballResult);
        } while (!baseballResult.equals("3스트라이크"));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String retry = userNumber();
        return isGameRetry(retry);
    }


    // 5. 맞으면 유저에게 1 또는 2를 받아서 새로 게임을 시작할지, 게임을 끝낼지 결정
    public static boolean isGameRetry(String retry) {
        if (retry.equals("1")) {
            return true;
        } else if (retry.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }


    // 1. 컴퓨터의 수 생성
    public static List<Integer> computerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }


    // 2. 유저에게 숫자 받기기
   public static String userNumber() {
        return Console.readLine();
    }


    // 3. 유저가 입력한 값이 유효한지 확인
    public static List<Integer> userNumberIsValid (String userNumber) {
        // 1. 세자리가 맞는지
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        // 2. 숫자만 들어왔는지
        char firstNum = userNumber.charAt(0);
        char secondNum = userNumber.charAt(1);
        char thirdNum = userNumber.charAt(2);
        if (48 >= (int)firstNum || (int)firstNum > 57) {
            throw new IllegalArgumentException();
        } else if (48 >= (int)secondNum || (int)secondNum > 57) {
            throw new IllegalArgumentException();
        } else if (48 >= (int)thirdNum || (int)thirdNum > 57) {
            throw new IllegalArgumentException();
        }

        // 3. 세 수가 모두 다른값인지
        HashSet<Character> userNumberSet = new HashSet<>();
        userNumberSet.add(firstNum);
        userNumberSet.add(secondNum);
        userNumberSet.add(thirdNum);
        if (userNumberSet.size() != 3) {
            throw new IllegalArgumentException();
        }

        List<Integer> userNumberList = new ArrayList<>();
        userNumberList.add((int)firstNum-48);
        userNumberList.add((int)secondNum-48);
        userNumberList.add((int)thirdNum-48);

        return userNumberList;
    }


    // 4. 값이 일치하지 않으면 볼, 스트라이크 개수 표시
    public static String result(List<Integer> computerNumber, List<Integer> userNumber) {
        String strikeBallResult = "";
        int strikeCnt = isStrike(computerNumber, userNumber);
        int ballCnt = isBall(computerNumber, userNumber);
        if (ballCnt != 0 && strikeCnt != 0) {
            strikeBallResult += ballCnt + "볼 " + strikeCnt + "스트라이크";
        } else if (ballCnt != 0) {
            strikeBallResult += ballCnt + "볼";
        } else if (strikeCnt != 0) {
            strikeBallResult += strikeCnt + "스트라이크";
        } else if (ballCnt == 0 && strikeCnt == 0) {
            strikeBallResult += "낫싱";
        }

        return strikeBallResult;
    }

    // 4-1. 스트라이크 개수 구하기
    public static Integer isStrike(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikeCount = 0;
        for (int i = 0 ; i < 3 ; i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }


    // 4-2. 볼 개수 구하기
    public static Integer isBall(List<Integer> computerNumber, List<Integer> userNumber) {
        int ballCount = 0;
        for (int i = 0 ; i < 3 ; i++) {
            if (!computerNumber.get(i).equals(userNumber.get(i)) && userNumber.contains(computerNumber.get(i))) {
                ballCount += 1;
            }
        }
        return ballCount;
    }
}


