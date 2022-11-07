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
}
