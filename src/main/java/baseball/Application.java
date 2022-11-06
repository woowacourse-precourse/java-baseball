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
    

}
