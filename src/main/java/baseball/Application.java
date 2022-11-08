package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computer = RandomNums();
            if (playGames(computer)) {
                break;
            }
        }
    }

    public static List<Integer> RandomNums() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static boolean playGames(List<Integer> computer) {
        int[] answer = new int[2];  // 볼,스트라이크

        while (true) {
            answer[0] = 0;
            answer[1] = 0;

            System.out.print("숫자를 입력해주세요 : ");

            int num = Integer.parseInt(Console.readLine());

            checkInput(num);

            answer = checkNums(computer, answer, num/100, num/10%10, num%10);

            printAnswer(answer);

            if (answer[1] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int end = Integer.parseInt(Console.readLine());
                return checkFinish(end);
            }
        }
    }

    public static void checkInput(int num) {
        int hund = num / 100, tens = num / 10 % 10, units = num % 10;

        if (hund == tens || hund == units || tens == units) {
            throw new IllegalArgumentException();
        }
        if (num < 100 || num > 1000) {
            throw new IllegalArgumentException();
        }
    }

    public static int[] checkNums(List<Integer> computer, int[] answer, int hund, int tens, int units) {
        if (computer.contains(hund)) {
            if (computer.get(0) == hund) {
                answer[1]++;
            } else {
                answer[0]++;
            }
        }
        if (computer.contains(tens)) {
            if (computer.get(1) == tens) {
                answer[1]++;
            } else {
                answer[0]++;
            }
        }
        if (computer.contains(units)) {
            if (computer.get(2) == units) {
                answer[1]++;
            } else {
                answer[0]++;
            }
        }
        return answer;
    }

    public static void printAnswer(int answer[]) {
        if (answer[0] == 0 && answer[1] == 0) {
            System.out.println("낫싱");
        } else if (answer[0] != 0) {
            if (answer[1] != 0) {
                System.out.println(answer[0] + "볼 " + answer[1] + "스트라이크");
            } else {
                System.out.println(answer[0] + "볼");
            }
        } else {
            System.out.println(answer[1] + "스트라이크");
        }
    }

    public static boolean checkFinish(int finish) {
        if (finish == 2) {
            return true;
        } else if (finish == 1) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}