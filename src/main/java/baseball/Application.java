package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static final int numberOfDigits = 3;
    static final int minNumber = 1;
    static final int maxNumber = 9;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            // 랜덤한 숫자 받아온 후 컴퓨터 리스트에 값 추가
            List<Integer> computer = addToRandomNumberList();
            while (true) {
                // 사용자에게 숫자 입력받기
                String user_number = getTheUserToInputNumber();
                // 사용자의 숫자가 3자리가 아닌 경우 예외 처리
                exceptionIfNumberIsNotThreeDigits(user_number.length());
                // 사용자가 입력한 숫자를 사용자 리스트에 추가
                List<Integer> user = addTheNumberEnteredByTheUserList(user_number);
                // 스트라이크 개수 확인
                int strike = checkTheNumberOfStrikes(user, computer);
                // 3스트라이크 시 1게임 종료
                if (strike == 3) {
                    System.out.println("3스트라이크");
                    break;
                }
                // 볼 개수 확인
                int ball = checkTheNumberOfBall(user,computer);
                // 사용자에게 볼과 스트라이크 개수 출력
                outputTheNumberOfBallAndStrikes(strike,ball);
            }
            // 1게임이 끝날을 경우 종료 여부 확인 후 종료 시 프로그램 종료
            if(checkForShutdown())
                break;
        }
    }

    // 랜덤한 숫자 받아온 후 컴퓨터 리스트에 값 추가
    public static List<Integer> addToRandomNumberList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < numberOfDigits) {
            int randomNumber = Randoms.pickNumberInRange(minNumber, maxNumber);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    // 사용자에게 숫자 입력받기
    public static String getTheUserToInputNumber() {
        System.out.println("숫자를 입력해 주세요");
        return Console.readLine();
    }
    // 사용자의 숫자가 3자리가 아닌 경우 예외 처리
    public static void exceptionIfNumberIsNotThreeDigits(int len) {
        if (len != numberOfDigits) {
            throw new IllegalArgumentException("숫자를 제대로 입력하시지 않았습니다.");
        }
    }
    // 사용자가 입력한 숫자를 사용자 리스트에 추가
    public static List<Integer> addTheNumberEnteredByTheUserList(String user_number){
        List<Integer> user = new ArrayList<>();
        for (int i = 0; i < user_number.length(); i++) {
            user.add(user_number.charAt(i) - '0');
        }
        return user;
    }
    // 스트라이크 개수 확인
    public static int checkTheNumberOfStrikes(List<Integer> user, List<Integer> computer){
        int strike = 0;
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i) == computer.get(i)) {
                strike++;
            }
        }
        return strike;
    }
    // 볼 개수 확인
    public static int checkTheNumberOfBall(List<Integer> user, List<Integer> computer){
        int ball = 0;
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i) != computer.get(i)) {
                if (computer.indexOf(user.get(i)) != -1)
                    ball++;
            }
        }
        return ball;
    }
    // 사용자에게 볼과 스트라이크 개수 출력
    public static void outputTheNumberOfBallAndStrikes(int strike, int ball){
        if (ball == 0 && strike == 0)
            System.out.println("낫싱");
        else if (ball == 0)
            System.out.println(strike + "스트라이크");
        else if (strike == 0)
            System.out.println(ball + "볼 ");
        else
            System.out.println(ball + "볼 " + strike + "스트라이크");
    }
    // 1게임이 끝날을 경우 종료 여부 확인 후 종료 시 프로그램 종료
    public static boolean checkForShutdown(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String game_Whether_to_proceed = Console.readLine();
        if (game_Whether_to_proceed.equals("2")) {
            System.out.println("게임 종료");
            return true;
        }
        else return false;
    }
}