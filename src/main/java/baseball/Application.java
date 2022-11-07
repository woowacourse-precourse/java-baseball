package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 컴퓨터 랜덤숫자 뽑기
        List<Integer> computer = getComputerNumber();
        System.out.println("computer = " + computer);

        // 게임 시작
        boolean game = true;
        while (game) {
            int strike = 0;
            int ball = 0;

            System.out.println("숫자를 입력해주세요 : ");
            List<Integer> user = getNums();

            // 결과 계산 로직

            if (ball > 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike > 0) {
                System.out.print(strike + "스트라이크");
            }
            if (ball == 0 && strike == 0) {
                System.out.print("낫싱");
            }
            System.out.println();
            if (strike == 3) {
                // 게임 종료 로직
            }
            if (strike == 3 && game == true) {
                computer = getComputerNumber();
            }
        }
    }

    // 컴퓨터 숫자 얻기
    private static List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // 사용자 숫자 얻기
    private static List<Integer> getNums() {
        // 예상 숫자 입력
        String str = Console.readLine();
        System.out.println("str = " + str);

        // 3자리가 아닌 경우 예외처리
        if (str.length() != 3) {
            throw new IllegalArgumentException();
        }

        // 1 ~ 9의 숫자가 아닌 경우 예외처리
        List<Integer> nums = new ArrayList<>();
        nums.add(getInteger(str.charAt(0)));
        nums.add(getInteger(str.charAt(1)));
        nums.add(getInteger(str.charAt(2)));

        // 동일한 숫자가 있는 경우 예외처리
        if (nums.get(0) == nums.get(1) || nums.get(1) == nums.get(2) || nums.get(2) == nums.get(0)) {
            throw new IllegalArgumentException();
        }

        return nums;
    }

    // int 반환 함수
    private static int getInteger(char word) {
        char arr[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        for (int i = 0; i < 9; i++) {
            if (word == arr[i]) {
                return i + 1;
            }
        }

        throw new IllegalArgumentException();
    }
}
