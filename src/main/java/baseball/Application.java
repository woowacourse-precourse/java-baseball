package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

// userInput의 볼, 스트라이크를 검사
class CheckNumber {
    // 스트라이크, 볼 변수 선언
    int strike = 0;
    int ball = 0;

    // ball, strike 상관없이 포함 검사 (total)
    public int CountBallPlusStrike(List<Integer> computer, List<Integer> userInput) {
        int total = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (userInput.contains(computer.get(i))) {
                total++;
            }
        }
        return total;
    }

    // strike 만 검사
    public int CountStrike(List<Integer> computer, List<Integer> userInput) {
        int strike = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == userInput.get(i)) {
                strike++;
            }
        }
        return strike;

        // ball은 total-strike 로 구할 수 있다.
    }
}

public class Application {

    public static void main(String[] args) {
        String userInput = null;
        int status = 1;

        // 1. 시작 멘트
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 2. 숫자 3개 랜덤 추출
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        while (status == 1) {
            // 3. 사용자 입력 받기
            userInput = Console.readLine();
        }
//        // 4. 숫자 검사
//        if (CheckNumber(computer.toString(), userInput)==1){
//            return;
//        }
        // 5. 새로 시작 or 종료
        Scanner sc2 = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        status = Integer.valueOf(sc2.next());
    }
}
