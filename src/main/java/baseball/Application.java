package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = makeNumber();
            String result = "";
            while (!result.equals("3스트라이크")) {
                result = score(userNumber(),computer);
                System.out.println(result);
            }
            if (!playAgain()) break;
        }
    }

    private static List<Integer> userNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userNumber = new ArrayList<>();
        String inputNumber = Console.readLine();

        for (String number : inputNumber.split("")) {
            userNumber.add(Integer.parseInt(number));
        }
        if (userNumber.size() != 3) throw new IllegalArgumentException("오류가 발생했습니다.");
        // 중복값 체크
        if (userNumber.size() != userNumber.stream().distinct().count())
            throw new IllegalArgumentException("오류가 발생했습니다.");

        return userNumber;
    }

    private static boolean playAgain() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        String call = Console.readLine();
        if (call.equals("1")) return true;
        if (call.equals("2")) return false;
        else {
            System.out.println("다시 입력해주세요");
            playAgain();
        }
        return true;
    }

    private static List<Integer> makeNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static int countStrike(List<Integer> userNumber, List<Integer> makeNumber){
        int strike = 0;
        for(int i = 0; i < 3; i++){
            if(makeNumber.get(i) == userNumber.get(i)){
                strike = strike + 1;
            }
        }
        return strike;
    }

    private static int equalNumber(List<Integer> userNumber, List<Integer> makeNumber) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (makeNumber.contains(userNumber.get(i))) {
                count = count + 1;
            }
        }
        return count;
    }

    private static String score(List<Integer> userNumber, List<Integer> makeNumber){
        int count = equalNumber(userNumber, makeNumber);
        int strike = countStrike(userNumber,makeNumber);
        int ball = count-strike;

        if(count == 0 && strike == 0){
            return "낫싱";
        }else if(strike == 0){
            return ball + "볼";
        }else if(ball == 0){
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}

