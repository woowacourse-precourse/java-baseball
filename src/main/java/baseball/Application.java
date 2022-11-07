package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = getNewNumber();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            if (!isRightInput(input)) {
                throw new IllegalArgumentException();
            }

            String output = "";
            int strikeCount = getStrikeCount(computer, input);
            int ballCount = getBallCount(computer, input);

            if (ballCount != 0) {
                output += String.valueOf(ballCount);
                output += "볼 ";
            }

            if (strikeCount != 0) {
                output += String.valueOf(strikeCount) + "스트라이크";
            }

            if (ballCount == 0 && strikeCount == 0) {
                output = "낫싱";
            }

            System.out.println(output);

            if (strikeCount != 3) continue;

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            input = Console.readLine();
            if (!input.matches("^[1-2]$")) throw new IllegalArgumentException();
            else if (input.equals("2")) break;
            computer = getNewNumber();

        }
    }


    public static List<Integer> getNewNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static boolean isRightInput(String input) {
        return input.matches("^[1-9]{3}$") && input.charAt(0) != input.charAt(1) && input.charAt(1) != input.charAt(2) && input.charAt(2) != input.charAt(0);
    }

    public static int getStrikeCount(List<Integer> computerNum, String input) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNum.get(i) == input.charAt(i) - '0') {
                count++;
            }
        }

        return count;
    }

    public static int getBallCount(List<Integer> computerNum, String input) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            int index = computerNum.indexOf(input.charAt(i) - '0');
            if (index != -1 && index != i) {
                count++;
            }
        }

        return count;
    }
}
