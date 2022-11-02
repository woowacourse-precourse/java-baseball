package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean retry = false;

        do {
            List<Integer> computer = getComputer();
            System.out.println("computer: "+Arrays.toString(computer.toArray()));
        } while (retry);

        System.out.println("애플리케이션 종료");
    }

    //컴퓨터 숫자 입력
    public static List<Integer> getComputer() {
        List<Integer> computer = new ArrayList<>();

        while(computer.size() < 3) {
            addComputer(computer);
        }

        return computer;
    }

    private static void addComputer(List<Integer> computer) {
        int random = Randoms.pickNumberInRange(1, 9);

        if(!computer.contains(random)) {
            computer.add(random);
        }
    }
}
