package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static Boolean checkDigitInput(String input) throws IllegalArgumentException {
            for (int i = 0; i < input.length(); i++) {
                if (!Character.isDigit(input.charAt(i))) throw new IllegalArgumentException();
            }
        return true;
    }
    public static Boolean checkNumberInput(String input) throws IllegalArgumentException {
        if (input.length() != 3) throw new IllegalArgumentException();
        return true;
    }

    public static Boolean checkInput(String input) {
        try {
            if (checkDigitInput(input) && checkNumberInput(input)) return true;
        } catch (IllegalArgumentException e) {
            System.err.println("올바르지 못한 입력값이 들어왔습니다");
            throw new IllegalArgumentException("에러");
        }
        return true;
    }

    public static List<Integer> makeUserCount(String input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) list.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        return list;
    }
    public static void main(String[] args) {

        String input;
        Boolean endFlag;
        Boolean replay = true;
        List <Integer> playerCount = null;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (replay) {
            Baseball playGame = new Baseball();
            replay = false;
            endFlag = false;

            while(!endFlag) {
                System.out.print("숫자를 입력해주세요: ");
                input = Console.readLine();
                if (checkInput(input)) playerCount = makeUserCount(input);

                if (playGame.countCheck(playerCount)) {
                    endFlag = true;
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = Console.readLine();
            if (Integer.parseInt(input) == 1) replay = true;
        }
    }
}

class Baseball {
    private List<Integer> baseballCount;
    public Baseball() {
        baseballCount = new ArrayList<>();
        while (baseballCount.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballCount.contains(randomNumber)) {
                baseballCount.add(randomNumber);
            }
        }
    }
    public Boolean countCheck(List<Integer> player) {
        System.out.println(player);
        int strike = 0;
        int ball = 0;


        for (int i = 0; i < player.size(); i++) {
            if (player.contains(baseballCount.get(i))) ball++;

            if (player.get(i) == baseballCount.get(i)) {
                ball--;
                strike++;
            }
        }
        announceCount(strike, ball);
        if (strike == 3) return true;
        return false;
    }
    public void announceCount(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ball == 3) {
            System.out.println(ball +"볼");
            return;
        }
        if (strike == 3) {
            System.out.println(strike +"스트라이크");
            return;
        }

        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
}