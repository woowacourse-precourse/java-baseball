package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static List<Integer> computerRandomNumber = new ArrayList<>();
    static boolean exitOrRestartSign = false;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            if (computerRandomNumber.size() == 0) {
                computerRandomNumber = makeRandomNumber();
            }

            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            if (!checkErrorInUserInput(userInput)) {
                break;
            }


            if (checkScoreInUserInput(userInput, computerRandomNumber)) {
                exitOrRestartSign = exitOrRestart();
            }
            if (exitOrRestartSign) {
                break;
            }

        }
    }

    // 나가기 or 재시작
    private static boolean exitOrRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String message = Console.readLine();
        try {
            if (message.equals("1")) {
                computerRandomNumber.clear();
                return false;
            } else if (message.equals("2")) {
                return true;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }

    }


    // 스트라이크, 볼, 낫싱 판별 후 출력
    static boolean checkScoreInUserInput(String userInput, List<Integer> computerInput) {
        int strikeCnt = 0;
        int ballCnt = 0;
        List<Integer> userInputList = new ArrayList<>();

        for (int index = 0; index < 3; index++) {
            userInputList.add(userInput.charAt(index) - '0');
        }

        boolean aleadyCheckedIndex[] = new boolean[3];
        for (int index = 0; index < 3; index++) {
            if (userInputList.get(index) == computerInput.get(index)) {
                strikeCnt++;
                aleadyCheckedIndex[index] = true;
            }
        }
        for (int index = 0; index < 3; index++) {
            if (aleadyCheckedIndex[index]) {
                continue;
            }
            if (computerInput.contains(userInputList.get(index))) {
                ballCnt++;
            }
        }
        if (ballCnt == 0 && strikeCnt == 0) {
            System.out.println("낫싱");
        } else if (ballCnt == 0 && strikeCnt != 0) {
            System.out.println(strikeCnt + "스트라이크");
        } else if (ballCnt != 0 && strikeCnt == 0) {
            System.out.println(ballCnt + "볼");
        } else {
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        }
        if (strikeCnt == 3) {
            return true;
        }
        return false;
    }

    //컴퓨터 랜덤 숫자 생성
    static List<Integer> makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    //유저 입력 체크
    static boolean checkErrorInUserInput(String userInput) {
        Set<Integer> numbersSet = new HashSet<>();
        for (int strIndex = 0; strIndex < userInput.length(); strIndex++) {
            int number = userInput.charAt(strIndex) - '0';
            numbersSet.add(number);
        }
        try {
            if (numbersSet.size() == 3) {
                return true;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

}
