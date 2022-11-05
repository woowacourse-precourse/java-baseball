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

        boolean gameEnd = false;

        while (!gameEnd) {
            validationCheck(userNumber());
            compare(userNumber(), makeNumber()); // 오늘 이거 나누는 작업 해야함. 컴퓨터랑 내가 입력한 번호 비교
            if (!playAgain()) break;
        }
    }


    public static List<Integer> userNumber() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");

        String inputNumber = Console.readLine();
        List<Integer> userNumber = new ArrayList<>();

        for (String number : inputNumber.split("")) {
            userNumber.add(Integer.parseInt(number));
        }
        return userNumber;
    }


    public static boolean validationCheck(List<Integer> userNumber) {
        // 길이 체크
        // 3자 미만이거나 초과면 오류발생으로 넘어가는데 메세지 출력이 안된다
        if (userNumber.size() != 3) throw new IllegalArgumentException("오류가 발생했습니다.");
        // 중복값 체크
        if (userNumber.size() != userNumber.stream().distinct().count())
            throw new IllegalArgumentException("오류가 발생했습니다.");

        return false;
    }

    public static boolean playAgain() {
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

    // 랜덤 수를 만드는 메소드
    public static List<Integer> makeNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer); // 정상 출력
        return computer;
    }

    // 중복되는 값만 찾는다. 커밋 전. 순서가 없다?
    // List<Integer> UserNumber, List<Integer> MakeNumber
    public static List<Integer> compare(List<Integer> userNumber, List<Integer> makeNumber) {

        List<Integer> resultList = userNumber.stream()
                .filter(old -> makeNumber.stream()
                        .anyMatch(Predicate.isEqual(old)))
                .collect(Collectors.toList());

        return resultList;
    }

    public int countStrike(List<Integer> userNumber, List<Integer> makeNumber){
        int strike = 0;
        for(int i = 0; i < 3; i++){
            if(makeNumber.get(i) == userNumber.get(i)){
                strike += 1;
            }
        }
        return strike;
    }

}

