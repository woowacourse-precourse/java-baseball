package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        int newGame = 1;

        while (newGame == 1) {
            newGame = game();
        }
    }

    public static int game() throws IllegalArgumentException {

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println("숫자 야구 게임을 시작합니다.");

        String input;
        boolean endGame = true;

        while (endGame) {
            System.out.print("숫자를 입력해주세요 : ");
            input = Console.readLine();
            inputException(input);
            endGame = scoreCalculation(input, computer);
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int newGame = Integer.parseInt(Console.readLine());
        return newGame;
    }

    public static boolean scoreCalculation(String input, List<Integer> computer) {

        int strike = strikeCount(input, computer);
        int ball = ballCount(input, computer);

        System.out.println(outputFormat(strike, ball));

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }

        return true;
    }

    public static void inputException(String input){

        //입력 예외 사항
        if (input.length() != 3 || input.contains("0")) {
            throw new IllegalArgumentException("1에서 9까지 서로 다른 임의의 수 3개를 선택해야 합니다. ex) 671");
        }

        for ( int i = 0 ; i < 3 ; i++) {
            if ( !Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("1에서 9까지 서로 다른 임의의 수 3개를 선택해야 합니다. ex) 671");
            }
        }

        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException("1에서 9까지 서로 다른 임의의 수 3개를 선택해야 합니다. ex) 671");
        }
    }

    public static int strikeCount(String input, List<Integer> computer) {

        int strike = 0;

        for (int i = 0; i < 3 ; i++ ) {
            if( Character.getNumericValue(input.charAt(i)) == computer.get(i)){
                strike++;
            }
        }
        return strike;
    }

    public static int ballCount(String input, List<Integer> computer) {
        int ball = 0;
        if (Character.getNumericValue(input.charAt(0)) == computer.get(1) || Character.getNumericValue(input.charAt(0)) == computer.get(2)) {
            ball++;
        }
        if (Character.getNumericValue(input.charAt(1)) == computer.get(0) || Character.getNumericValue(input.charAt(1)) == computer.get(2)) {
            ball++;
        }
        if (Character.getNumericValue(input.charAt(2)) == computer.get(0) || Character.getNumericValue(input.charAt(2)) == computer.get(1)) {
            ball++;
        }
        return ball;
    }

    public static String outputFormat(int strike, int ball) {

        if (ball > 0 && strike > 0) {
            return ball + "볼 " + strike + "스트라이크";
        } else if (ball > 0) {
            return ball + "볼";
        } else if (strike > 0) {
            return strike + "스트라이크";
        } else {
            return "낫싱";
        }
    }
}
