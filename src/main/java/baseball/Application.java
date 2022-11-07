package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Application {

    static Scanner sc;
    static int strike, ball;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            // 점수 초기화
            init();

            // 게임 시작
            game();

            // 재시작?
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String started = sc.nextLine();

            if (started.equals("2")) {
                break; // 끝
            } else if (!started.equals("1")) { // 2도 아니고 1도 아니면 예외
                throw new IllegalArgumentException();
            }
        }
        sc.close();
    }
    // 점수 초기화
    private static void init() {
        strike = 0;
        ball = 0;
    }

    //베이스볼 게임 진행
    private static void game() {
        LinkedHashSet<String> baseballSet = getRandomNumber();
        List<String> baseballList = new ArrayList<>(baseballSet);
        while (strike != 3) {
            // 점수 초기화
            init();

            // 숫자 입력 받기
            System.out.print("숫자를 입력해주세요 : \n");
            String[] userNumber = getUserNumber(sc.nextLine());

            // 스크라이크, 볼 체크
            scoreCheck(baseballSet, baseballList, userNumber);

            // 결과 출력
            result();
        }
    }
    //랜덤수 생성
    private static LinkedHashSet<String> getRandomNumber() {
        // 들어온 숫서대로 받기 위해 LinkedHashSet 사용
        LinkedHashSet<String> randomNumber = new LinkedHashSet<>();
        while (randomNumber.size() < 3) { // 길이가 3개인지 체크
            randomNumber.add(String.valueOf(Randoms.pickNumberInRange(1, 9)));
        }
        return randomNumber;
    }
}

