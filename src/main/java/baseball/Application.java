package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    static boolean answer = true;
    static boolean reStart = true;
    public static void main(String[] args) {
        List<Integer> comList = new ArrayList<>();

        // 3스트라이크가 아니면 반복
        while(answer) {
            if(reStart) {
                comList = comNumber();
            }

            List userList = userNumber();
            score(comList, userList);
        }
    }

    // 컴퓨터의 서로 다른 숫자 3개 저장
    public static List comNumber() {
        List<Integer> comList = new ArrayList<>();

        for (int i=0; i<3; i++) {
            int num = Randoms.pickNumberInRange(1, 9);

            if(!comList.contains(num)) {
                comList.add(num);
            } else {
                i--;
            }
        }

        reStart = false;

        return comList;
    }

    // 사용자의 숫자 저장
    public static List userNumber() {
        List<Integer> userList = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");

        String userNum = Console.readLine();

        for (int i=0; i<userNum.length(); i++) {
            userList.add(userNum.charAt(i) - '0');
        }

        userException(userNum, userList);

        return userList;
    }
    
    // 점수 판단 기능
    public static void score(List comList, List userList) {
        int strike = 0;
        int ball = 0;

        for (int i=0; i<comList.size(); i++) {
            if(comList.get(i) == userList.get(i)) {
                strike++;
            } else if (userList.contains(comList.get(i))) {
                ball++;
            }
        }

        StringBuilder sb = new StringBuilder();

        if (strike == 3) {
            answer = false;
            sb.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("3스트라이크");
            System.out.println(sb);
            reStartGame();
            return;
        } else if(ball > 0) {
            sb.append(ball +"볼 ");
        }

        if(strike > 0) {
            sb.append(strike +"스트라이크");
        }

        if(strike == 0 && ball == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb);
    }

    // 예외 처리 기능
    // 3자리여부, 숫자여부, 중복여부
    public static void userException(String userNum, List userList) {
        if (userNum.length() != 3) {
            throw new IllegalArgumentException("3자리 입력 해주세요");
        } else if(!userNum.chars().allMatch((Character::isDigit))) {
            throw new IllegalArgumentException("숫자만 입력 해주세요");
        }

        for(int i=0; i<3; i++) {
            int count = Collections.frequency(userList, userNum.charAt(i) -'0');

            if(count > 1) {
                throw new IllegalArgumentException("다른 숫자만 입력 해주세요");
            }
        }
    }

    // 재시작, 종료 기능
    public static void reStartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();

        if(input.contentEquals("1")) {
            answer = true;
            reStart = true;
        }
    }
}
