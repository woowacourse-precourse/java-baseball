package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean restart;
        BaseballGame Game = new BaseballGame();
        Scanner sc = new Scanner(System.in);
        do {
            List<Integer> computerNumberList = makeRandomNumber();
            restart = Game.GameStart(sc, computerNumberList);
        } while (restart);
    }

    static List<Integer> makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}


class BaseballGame {
    //숫자 3개를 임의로 추출 하고 컴퓨터에 해당하는 변수에 할당하는 기능


    boolean checkErrorNumber(List<Integer> list) {
        if (list.size() > 3) {
            return false;
        }
        if (list.size() != list.stream().distinct().count()){
            return false;
        }
        return true;
    }


    List<Integer> splitNumber(int number) {
        List<Integer> list = new ArrayList<>();
        while (number > 0) {
            int div = number % 10;
            list.add(div);
            number = number / 10;
        }
        Collections.reverse((list));
        return list;
    }

    List<Integer> compareList(List<Integer> computerNumberList, List<Integer> userNumberList) {
        int strikeCount = 0;
        int ballCount = 0;

        List<Integer> checkList = new ArrayList<>();

        strikeCount += countStrike(strikeCount, computerNumberList, userNumberList);

        for (int computerIdx = 0; computerIdx < computerNumberList.size(); computerIdx++) {
            ballCount += countBall(computerIdx, ballCount, computerNumberList, userNumberList);
        }

        checkList.add(strikeCount);
        checkList.add(ballCount);

        return checkList;
    }


    int countStrike(int strikeCount, List<Integer> computerNumberList, List<Integer> userNumberList) {
        int idx = 0;
        while (idx < computerNumberList.size()) {
            if (Objects.equals(computerNumberList.get(idx), userNumberList.get(idx))) {
                strikeCount++;
            }
            idx++;
        }
        return strikeCount;
    }

    int countBall(int computerIdx, int ballCount, List<Integer> computerNumberList, List<Integer> userNumberList) {
        for (int userIdx = 0; userIdx < userNumberList.size(); userIdx++) {
            if (computerIdx != userIdx && Objects.equals(computerNumberList.get(computerIdx), userNumberList.get(userIdx))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    void printResult(List<Integer> checkList) {
        if (checkList.get(0) > 0 && checkList.get(1) > 0) {
            String result = checkList.get(1) + "볼 " + "" + checkList.get(0) + "스트라이크";
            System.out.println(result);
        } else if (checkList.get(0) == 0 && checkList.get(1) > 0) {
            String result = checkList.get(1) + "볼 ";
            System.out.println(result);
        } else if (checkList.get(0) > 0 && checkList.get(1) == 0) {
            String result = checkList.get(0) + "스트라이크";
            System.out.println(result);
        } else {
            System.out.println("낫싱");
        }
    }

    boolean GameStart(Scanner sc, List<Integer> computerNumberList) {
        while (true) {
            List<Integer> userNumberList;

            String strNumber = sc.next();
            int number;
            number = Integer.parseInt(strNumber);

            if (number == 2) {
                System.out.println(number);
                return false;
            } else if (number == 1) {
                System.out.println(number);
                return true;
            } else {
                System.out.print("숫자를 입력해주세요 : ");
                System.out.println(number);
            }

            userNumberList = splitNumber(number);

            if (!checkErrorNumber(userNumberList)) {
                throw new IllegalArgumentException();
            }

            List<Integer> checkList = compareList(computerNumberList, userNumberList);
            printResult(checkList);
            if (checkList.get(0) == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            }
        }
    }
}









