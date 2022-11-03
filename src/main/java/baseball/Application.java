package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        if (gamePlaying() != 2) {
            gamePlaying();
        }

    }

    public static List<Integer> pickGameNumber() {
        List<Integer> gameNumberList = new ArrayList<>();
        while (gameNumberList.size() != 3) {
            checkNumber(gameNumberList);
        }
        return gameNumberList;
    }

    public static void checkNumber(List<Integer> numberList) {
        int num = Randoms.pickNumberInRange(1, 9);

        if (!numberList.contains(num)) {
            numberList.add(num);
        }
    }

    public static List<Integer> inputGameNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userNumberList = new ArrayList<>();
        String inputNum = readLine();
        int i = 0;
        while (userNumberList.size() != 3) {
            userNumberList.add(Character.getNumericValue(inputNum.charAt(i)));
            i++;
        }
        return userNumberList;

    }

    public static int gamePlaying() {
        List<Integer> gameNumberList = pickGameNumber();
//        List<Integer> userNumberList = inputGameNumber();
//        System.out.println(gameNumberList);


        int strike = 0;
        int ball = 0;
        while (strike != 3) {
            List<Integer> userNumberList = inputGameNumber();
            List<Integer> strikeNumberList = new ArrayList<>();
            strike = 0;
            ball = 0;
            for (int i = 0; i < 3; i++) {
                if (Objects.equals(gameNumberList.get(i), userNumberList.get(i))) {
                    strike++;
                    strikeNumberList.add(gameNumberList.get(i));
                }
                if (gameNumberList.contains(userNumberList.get(i)) && !strikeNumberList.contains(userNumberList.get(i))) {
                    ball++;
                }
            }
            if (strike != 0 || ball != 0) {
                System.out.println(strike + "스트라이크 " + ball + "볼");
            } else {
                System.out.println("낫띵");
            }
            System.out.println(gameNumberList + "" + userNumberList);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int restartGame = Integer.parseInt(readLine());
        return restartGame;
//        System.out.println(userNumberList);
    }




}
