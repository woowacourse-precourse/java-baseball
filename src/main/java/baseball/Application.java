package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        int strike = 0;
        String restart = "0";

        GameStart();
        while (!restart.equals("2")) {
            PlayGame(strike, restart);
            GameEnd(strike);
            restart = ReStart();
        }
    }

    public static void GameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void PlayGame(int strike, String restart) {
        strike = 0;
        List<Integer> comNum = SetComNum();
        while (strike != 3) {
            List<Integer> userNum = InputUserNum();
            strike = StrikeBallCheck(comNum, userNum);
        }
    }

    public static List<Integer> SetComNum() {
        List<Integer> comNum = new ArrayList<>();
        while (comNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comNum.contains(randomNumber)) {
                comNum.add(randomNumber);
            }
        }
        System.out.println(comNum.toString());
        return comNum;
    }

    public static List<Integer> InputUserNum() {
        System.out.println("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        List<Integer> userNum = new ArrayList<>();
        for (String Number : inputNum.split("")) {
            userNum.add(Integer.parseInt(Number));
        }
        InputException(userNum);
        return userNum;
    }

    public static void InputException(List<Integer> userNum){
        if(userNum.size() != 3){
            throw new IllegalArgumentException();
        } else{
            InputDuplication(userNum);
        }
    }

    public static void InputDuplication(List<Integer> userNum) {
        Set<Integer> userNumSet = new HashSet<>(userNum);
        if (userNum.size() != userNumSet.size()){
            throw new IllegalArgumentException();
        }
    }

    public static int StrikeBallCheck(List<Integer> comNum, List<Integer> userNum) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (userNum.get(i) == comNum.get(i)) {
                strike = strike + 1;
            } else if (comNum.contains(userNum.get(i))) {
                ball = ball + 1;
            }
        }
        PrintStrikeBall(strike, ball);

        return strike;
    }

    public static void PrintStrikeBall(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public static void GameEnd(int strike) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static String ReStart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = Console.readLine();
        return restart;
    }
}
