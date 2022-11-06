package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        randomPick();
        inputNumber();
    }

    /*1.랜덤으로 컴퓨터가 임의의 값 선택.*/
    public static void randomPick() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    /*2. 게임 플레이어가 입력한 숫자 받기*/
    public static void inputNumber() {
        Scanner scan = new Scanner(System.in);
        List<Integer> user = new ArrayList<>();
        String strNumber = scan.next();
        for (String chr : strNumber.split("")) {
            user.add(Integer.parseInt(chr));
        }
    }

    /*3. 컴퓨터와 입력숫자를 비교해서 스트라이크 판정 Integer로 반환*/
    public static void strike(List<Integer> user, List<Integer> computer) {
        int countStrike = 0;
        for (int i = 0; i < 3; i++) {
            if (user.get(i).equals(computer.get(i))) {
                countStrike++;
            }
        }
//        return countStrike;
    }

}
