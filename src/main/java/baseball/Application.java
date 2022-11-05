package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {



    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application T = new Application();

        //컴퓨터 랜덤 3개의 숫자
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println("숫자 야구 게임을 시작합니다.");
        String userNum = Console.readLine();
        System.out.println("숫자를 입력해주세요 : "+ userNum);

        // 내숫자 List<Integer> 배열로 만들기
        String[] s = userNum.split("");
        List<Integer> myList = new ArrayList<>();
        for(int i = 0 ; i<userNum.length() ; i++) {
            myList.add(Integer.parseInt(s[i]));
        }
        System.out.println("computer= " + computer);
        System.out.println("내 숫자= "+ myList);

        }
    private static void changeUserNum() {
    }


}

