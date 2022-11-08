package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> rand() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public boolean retry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        final int check = in.nextInt();
        if (check == 1) {
            return true;
        }
        return false;
    }
}
