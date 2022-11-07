package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    // 컴퓨터의 랜덤한 숫자를 생성해서 반환
    private static List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        int randomNumber = 0;
        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static void playGame() {
        List<Integer> computer = getComputerNumber();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String num = Console.readLine();
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if (Console.readLine().equals("2"))
                break;
        }
    }
}