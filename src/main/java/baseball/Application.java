package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    //기능1.
    public static List<Integer> computer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer();
    }

    //기능2.
    public static List<Integer> user(){
        List<Integer> user = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String userNum = Console.readLine();
        char[] charArr; //입력된 값을 3개의 수로 분할할 배열

        //예외상황 3가지
        if (userNum.length() != 3){
            throw new IllegalArgumentException("3개의 숫자를 입력하지 않았습니다.");
        } else if (!userNum.matches("-?\\d+")) {
            throw new IllegalArgumentException("숫자를 입력하지 않았습니다.");
        }else {
            charArr = userNum.toCharArray();
            if (charArr[0] == charArr[1] || charArr[0] == charArr[2] || charArr[1] == charArr[2]){
                throw new IllegalArgumentException("겹치는 숫자가 있습니다.");
            }else {
                user.add(charArr[0] - '0');
                user.add(charArr[1] - '0');
                user.add(charArr[2] - '0');
            }
        }

        return user;
    }

    //기능3. 컴퓨터와 사용자의 숫자 비교해 스트라이크 개수 구하기
    public static int strike(List<Integer> computer, List<Integer> user){
        int strike = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == user.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    //기능4. 컴퓨터와 사용자의 숫자 비교해 볼 개수 구하기
    public static int ball(List<Integer> computer, List<Integer> user, int strike) {
        int ball = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.contains(user.get(i))) {
                ball++;
            }
        }
        ball -= strike;
        return ball;
    }

    //기능5. 비교한 결과를 알려주기
    public static void result(int strike, int ball) {
        if (ball > 0) {
            if (strike > 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else {
                System.out.println(ball + "볼");
            }
        } else {
            if (strike < 1) {
                System.out.println("낫싱");
            } else {
                System.out.println(strike + "스트라이크");
            }
        }
    }

    //기능6. 승리했을 경우 (3스트라이크) 실행될 함수 (1 또는 2를 입력받기.)
    public static String victory(){
        System.out.println("게임을 계속하려면 1, 종료하려면 2를 입력하세요.");
        String victory = Console.readLine();
        return victory;
    }
}
