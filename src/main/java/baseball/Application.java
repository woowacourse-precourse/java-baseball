package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Application {
    private ArrayList<Integer> playerNum;


    // 1. 서로 다른 3자리의 임의의 수 생성
    public static class RandomNum {
        public List<Integer> create() {
            List<Integer> computerNum = new ArrayList<>();
            while (computerNum.size() < 3) {
                int randomNum = Randoms.pickNumberInRange(1, 9);
                if (computerNum.contains(randomNum)) {
                    continue;
                } else {
                    computerNum.add(randomNum);
                }
            }
            return computerNum;
        }
    }

    // 2. 입력 받은 3자리 숫자 비교
    public static class Compare {

        // 같은 숫자가 몇 개 있는지 count
        public int count(List<Integer> computer, List<Integer> player) {
            int result = 0;
            for (int i = 0; i < player.size(); i++) {
                if (computer.contains(player.get(i))) {
                    result += 1;
                }
            }
            return result;

        }
        

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

