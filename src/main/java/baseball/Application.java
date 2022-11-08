package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        //2를 눌러 중지될 때까지 작동한다.
        while (true) {
            //컴퓨터 초기화 부분
            List<Integer> computer = initComputer();
            int[] result;

            //사용자 입력 및 매칭 부분
            do {
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> human = readGameStep();
                result = match(computer, human);
                printResult(result);
            } while (result[1] != 3);

            //게임 종료 부분
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int restartFlag = readEndStep();
            if (restartFlag == 2) break;
        }
    }

    public static List<Integer> readGameStep() {
        //한 줄에 3자리를 입력받는다.
        String nextStep = Console.readLine();
        if (nextStep.length() != 3) throw new IllegalArgumentException("게임 진행 입력 오류");

        //문자를 숫자로 변환하면서 1-9사이인지, 유니크한지 파악한다.
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

    public static int readEndStep() {
        //1 또는 2를 입력받는다.
        String endStep = Console.readLine();
        if (endStep.length() != 1) throw new IllegalArgumentException("끝내기 입력 오류");
        int selectedNum = (int) (endStep.charAt(0) - '0');

        //1 또는 2이면 반환하고, 아니면 예외를 던진다.
        if (selectedNum == 1 || selectedNum == 2) return selectedNum;
        else throw new IllegalArgumentException("끝내기 입력 오류");
    }

    public static List<Integer> initComputer() {
        //라이브러리를 이용해 1-9 범위의 유니크한 숫자 3개를 선택한다.
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static int[] match(List<Integer> computer, List<Integer> human) {
        //각 인덱스는 처음부터 볼, 스트라이크, 낫싱이다.
        int[] result = {0, 0, 0};

        //볼, 스트라이크를 판단한다.
        for (int i = 0; i < 3; i++) {
            if (computer.get(i) == human.get(i)) result[1]++;
            else if (human.contains(computer.get(i))) result[0]++;
        }

        //볼과 스트라이크가 0이면 낫싱이다.
        if (result[0] == 0 && result[1] == 0) result[2] = 1;

        return result;
    }

    public static void printResult(int[] result) {
        //결과에 따라 양식대로 출력한다.
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
