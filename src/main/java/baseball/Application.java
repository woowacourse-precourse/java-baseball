package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            baseballGame();
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int num = Integer.parseInt(Console.readLine());
            if (num == 2) {
                break;
            }
        }
    }

    private static void baseballGame() {
        List<Integer> computer = getComputerNumber();

        System.out.println("숫자 야구 게임을 시작합니다.");
        for (int i = 0; i < 3; i++) {
            System.out.print(computer.get(i) + " ");
        }
        System.out.println();
        while (true) {
            ArrayList<Integer> user = new ArrayList<>();
            System.out.print("숫자를 입력해주세요 : ");
            String[] userNumber = Console.readLine().split("");
            for (String str : userNumber) {
                user.add(Integer.parseInt(str));
            }
            // 값을 제공하면 해당 값의 첫번 째 인덱스를 반환
            // indexof 해서 i 랑 같으면 스트라이크고, -1이면 x i 랑 다르면 볼
            int[] result = new int[2];
            for (int i = 0; i < computer.size(); i++) {
                int idxOf = computer.indexOf(user.get(i));
                System.out.println("idxOf = : " + idxOf);
                if (idxOf == i) {
                    // strike
                    result[0]++;
                    continue;
                }
                if (idxOf > 0) {
                    // ball
                    result[1]++;
                    continue;
                }
            }

            if (result[0] == 0) {
                System.out.println(result[1] + "볼 ");
            } else if (result[1] == 0) {
                System.out.println(result[0] + "스트라이크");
            } else {
                System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
            }

            if (result[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    // 컴퓨터 숫자 입력받는 메소드
    private static List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (isSize(computer)) {
            getRandomNumber(computer, Randoms.pickNumberInRange(1, 9));
        }
        return computer;
    }

    // 컴퓨터 리스트의 사이즈가 3 미만인지 확인하는 메소드
    private static boolean isSize(List<Integer> computer) {
        return computer.size() < 3;
    }

    // 컴퓨터의 숫자를 랜덤으로 부여하는 메소드
    private static void getRandomNumber(List<Integer> computer, int randomNumber) {
        if (isContains(computer, randomNumber)) {
            computer.add(randomNumber);
        }
    }

    // 중복된 숫자가 있는지 확인하는 메소드
    private static boolean isContains(List<Integer> computer, int randomNumber) {
        return !computer.contains(randomNumber);
    }
}
