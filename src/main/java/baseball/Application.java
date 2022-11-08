package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> computer = initComputer();
            int[] result;
            do {
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> human = readGameStep();
                result = match(computer, human);
                printResult(result);
            } while (result[1] != 3);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int restartFlag = readEndStep();
            if (restartFlag == 2) break;
        }
    }

    private static List<Integer> readGameStep() {
        String nextStep = Console.readLine();
        if (nextStep.length() != 3) throw new IllegalArgumentException("게임 진행 입력 오류");

        List<Integer> human = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int val = (int) (nextStep.charAt(i) - '0');
            if (!(1 <= val && val <= 9)) {
                throw new IllegalArgumentException("게임 진행 입력 오류");
            } else if (!human.contains(val)) {
                human.add(val);
            } else {
                throw new IllegalArgumentException("게임 진행 입력 오류");
            }
        }

        return human;
    }

    private static int readEndStep() {
        String endStep = Console.readLine();
        int selectedNum = (int) (endStep.charAt(0) - '0');

        if (selectedNum == 1 || selectedNum == 2) return selectedNum;
        else throw new IllegalArgumentException("끝내기 입력 오류");
    }

    private static List<Integer> initComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static int[] match(List<Integer> computer, List<Integer> human) {
        int[] result = {0, 0, 0};

        for (int i = 0; i < 3; i++) {
            if (computer.get(i) == human.get(i)) result[1]++;
            else if (human.contains(computer.get(i))) result[0]++;
        }

        if (result[0] == 0 && result[1] == 0) result[2] = 1;

        return result;
    }

    private static void printResult(int[] result) {
        if (result[1] == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (result[2] == 1) {
            System.out.println("낫싱");
        } else {
            if (result[0] == 0) {
                System.out.println(result[1] + "스트라이크");
            } else if (result[1] == 0) {
                System.out.println(result[0] + "볼");
            } else {
                System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
            }
        }
    }
}
