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

        // 같은 숫자, 자리가 몇 개 있는지 count
        public int strike_count(List<Integer> computer, List<Integer> player) {
            int strike = 0;
            for (int i = 0; i < player.size(); i++) {
                if (computer.get(i) == player.get(i)) {
                    strike += 1;
                }
            }
            return strike;
        }
    }

    // 조건에 맞는 숫자 비교
    public static class Choice {
        static Compare compare = new Compare();

        public static String choice(List<Integer> computer, List<Integer> player) {

            int total = compare.count(computer, player);
            int strike = compare.strike_count(computer, player);
            int ball = total - strike;


            // 같은 수가 같은 자리에 있으면 스트라이크
            if (strike > 0) {
                return strike + "스트라이크";
                //다른 자리에 똑같이 있으면 볼
            } else if (ball > 0) {
                return ball + "볼";
                //같은 수가 같은 자리에 있으면 스트라이크
            } else if (total == 0) {
                return "낫싱";
            }
            return ball + "볼" + strike + "스트라이크";
        }
    }
    public static class Input {
        // 사용자 입력 값
        public List<Integer> playerNum() {
            System.out.println("숫자 입력: ");
            Scanner scanner = new Scanner(System.in);
            List<Integer> playNum = new ArrayList<>();
            String input = scanner.next();
            checkSize(input);

            for (String number : input.split("")) {
                playNum.add(Integer.parseInt(number));
            }
            return playNum;
        }
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

