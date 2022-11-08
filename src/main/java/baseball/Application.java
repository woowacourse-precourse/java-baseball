package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int mode = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (mode == 1) {
            String computerRandomNumber = MyUtil.createRandomNumber();
            solve(computerRandomNumber);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String inputModeNum = Console.readLine();
            checkModeNumberValidate(inputModeNum);
            mode = Integer.valueOf(inputModeNum);
        }
    }

    public static void solve(String computerRandomNumber) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = Console.readLine();
            checkInputNumberValidate(inputNumber);

            List<Integer> matchResult = matchResult(computerRandomNumber, inputNumber);
            StringBuilder sb = new StringBuilder();
            if (matchResult.get(1) != 0) {
                sb.append(matchResult.get(1));
                sb.append("볼");
            }
            if (!matchResult.contains(0)) {
                sb.append(" ");
            }
            if (matchResult.get(0) != 0) {
                sb.append(matchResult.get(0));
                sb.append("스트라이크");
            }
            if (sb.length() == 0) {
                System.out.println("낫싱");
            } else {
                System.out.println(sb.toString());
            }
            if (matchResult.get(0) == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
        }
    }

    // 컴퓨터가 생성한 랜덤값과 사용자가 입력한 값을 비교하여 List의 첫 번째 index에는 스트라이크를, 두 번째 index에는 볼의 개수
    public static List<Integer> matchResult(String computerRandomNumber, String inputNumber) {
        int[] strikeBall = new int[2];
        for (int compIdx = 0; compIdx <= 2; ++compIdx) {
            for (int inputIdx = 0; inputIdx <= 2; ++inputIdx) {
                addStrikeBall(computerRandomNumber.charAt(compIdx), inputNumber.charAt(inputIdx),
                        compIdx, inputIdx, strikeBall);
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int x : strikeBall) {
            ret.add(x);
        }
        return ret;
    }

    public static void addStrikeBall(char computerRandomNumberElement, char inputNumberElement,
                                     int compIdx, int inputIdx, int[] strikeBall) {
        if (computerRandomNumberElement != inputNumberElement) {
            return;
        }
        if (compIdx == inputIdx) {
            strikeBall[0]++;
        } else {
            strikeBall[1]++;
        }
    }

    public static void checkModeNumberValidate(String inputModeNum) {
        if (!inputModeNum.equals("1") && !inputModeNum.equals("2")) {
            throw new IllegalArgumentException("잘못된 모드 입력값");
        }
    }

    public static void checkInputNumberValidate(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("입력값의 길이가 잘못되었습니다.");
        }
        char first = inputNumber.charAt(0), second = inputNumber.charAt(1), third = inputNumber.charAt(2);
        if (!inRangeOneToNine(first) || !inRangeOneToNine(second) || !inRangeOneToNine(third)) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 포함될 수 있습니다.");
        }
        if (first == second || second == third || first == third) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    private static boolean inRangeOneToNine(char x) {
        return x >= '1' && x <= '9';
    }
}
