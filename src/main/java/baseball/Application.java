package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    static List<Integer> computer = new ArrayList<>();

    private static void computerNumber(List<Integer> list){
        while(list.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!list.contains(randomNumber)){
                list.add(randomNumber);
            }
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        computer.clear();
        computerNumber(computer);

        System.out.println("게임 종료");
    }
}
