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

    // 유저가 입력한 문자열 체크
    private static String[] getUserNumber(String userInput) {
        String[] userNumber = userInput.split("");

        // 입력받은 문자 중 숫자가 아닌 것이 있으면 예외 발생
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }

        //입력받은 숫자가 세글자가 아니거나 중복된 숫자 포함 시 예외 발생
        //Set.of는 동일한 키값 존재 시 자체적으로 예외 처리
        if (Set.of(userNumber).size() != 3) {
            throw new IllegalArgumentException();
        }
        return userNumber;
    }
    //strike, ball 점수 계산
    private static void scoreCheck(LinkedHashSet<String> baseballSet, List<String> baseballList, String[] userNumber) {
        for (int i = 0; i < userNumber.length; i++) {
            // 같은 자리에 같은 수라면 strike
            if (userNumber[i].equals(baseballList.get(i))) {
                strike++;
                // 포함만 되어있다면 ball
            } else if (baseballSet.contains(userNumber[i])) {
                ball++;
            }
        }
    }
}

