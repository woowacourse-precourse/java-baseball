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

            if (answer[1] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int end = Integer.parseInt(Console.readLine());
            }
        }
    }
}