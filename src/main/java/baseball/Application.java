package baseball;


import java.util.ArrayList;
import java.util.List;

public class Application {

    // 기능 목록 1 : 숫자 야구 게임 시작 문구 생성
    static List<Integer> startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        return makeThreeNumber();
    }

    // 기능 목록 2 : 1부터 9까지의 랜덤한 값 생성
    static int randomValue() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }

    // 기능 목록 3 : 1부터 9까지 서로 다른 3자리 수 생성
    static List<Integer> makeThreeNumber() {
        List<Integer> computerNumber = new ArrayList<>();

        while (computerNumber.size() < 3) {
            int randomNumbers = randomValue();
            if (computerNumber.contains(randomNumbers)) {
                continue;
            } else {
                computerNumber.add(randomNumbers);
            }
        }
        return computerNumber;
    }

    // 기능 목록 4 : 같은 수가 같은 자리에 있을 경우, 스트라이크 확인
    static int countStrike (List < Integer > computer, List < Integer > player){
        int strike = 0;

        for (int i = 0; i < player.size(); i++) {
            if (computer.get(i) == player.get(i)) {
                strike += 1;
            }
        }
        return strike;
    }

    // 기능 목록 5 : 같은 수가 다른 자리에 있을 경우, 볼 확인
    static int countBall(List<Integer> computer, List<Integer> player) {
        int Ball = 0;

        for (int i = 0; i < player.size(); i++) {
            if (computer.get(i) == player.get(i)) {
                continue;
            } else if (computer.contains(player.get(i))) {
                Ball += 1;
            }
        }
        return Ball;
    }

    // 기능 목록 6 : 낫싱, 스트라이크, 볼 판단
    public String judge(int Ball, int strike) {
        String judge;
        int total = Ball + strike;

        if (total == 0) {
            judge = "낫싱";
        } else if (strike != 0) {
            judge = strike + "스트라이크";
        } else if (Ball != 0) {
            judge = Ball + "볼";
        } else {
            judge = Ball + "볼 " + strike + "스트라이크";
            return judge;
        }
    }

    // 기능 목록 7 : 3스트라이크 일 경우, 게임 종료
    static boolean threeStrike(int strike) {

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        // TODO: 프로그램 구현

        startMessage();
        List<Integer> computerNumber = makeThreeNumber();
    }
}