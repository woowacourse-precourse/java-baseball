package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Application {

    private static String userInput;
    private static int targetNumber;

    public static void main(String[] args) {

        startGamePrint();
        playGame();
        endGamePrint();
    }

    private static void playGame() {

        while (true) {

            targetNumber = makeTargetNumber();
            userAttempt();
            gameContinuePrint();
            userInput = Console.readLine();
            validGameContinueInput(Integer.parseInt(userInput));
            if (userInput.equals("2")) break;
        }
    }

    private static void userAttempt() {

        while (true) {
            getNumberPrint();
            userInput = Console.readLine();
            validUserInput(Integer.parseInt(userInput));

            BallAndStrike ballAndStrike = compareNumbers(targetNumber, Integer.parseInt(userInput));
            ballAndStrike.print();
            if (ballAndStrike.getStrike() == 3) {
                gameOverPrint();
                break;
            }
        }
    }

    public static int makeTargetNumber() {
        String str;
        while(true){
            str = "";
            for(int i=0; i<3; i++){
                str += String.valueOf(Randoms.pickNumberInRange(1, 9));
            }
            if(uniqueChecker(str)) break;
        }
        return Integer.parseInt(str);
    }

    private static BallAndStrike compareNumbers(int targetNumber, int userInput) {
        BallAndStrike count = new BallAndStrike();
        String target = String.valueOf(targetNumber);
        String input = String.valueOf(userInput);

        for(int i=0; i<input.length(); i++){
            if(target.indexOf(input.charAt(i)) == -1) continue;
            if(target.charAt(i) == input.charAt(i)) count.setStrike(count.getStrike() + 1);
            else count.setBall(count.getBall() + 1);
        }

        return count;
    }


    private static void getNumberPrint() {
        System.out.print("숫자를 입력해주세요. : ");
    }

    private static void gameOverPrint() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static void gameContinuePrint() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static void startGamePrint() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void endGamePrint() {
        System.out.println("숫자 야구 게임을 종료합니다.");
    }
    private static boolean uniqueChecker(String str) {
        Set<Character> charSet = new LinkedHashSet<>();
        for(int i=0; i<str.length(); i++){
            charSet.add(str.charAt(i));
        }
        return str.length() == charSet.size();
    }

    private static void validUserInput(int number) {
        //세자리 수가 아닐때
        if(number < 100 || number > 999) {
            throw new IllegalArgumentException("세자리 수를 입력해야 합니다");
        }
        //세자리 수 중 0이 있을 때
        if(String.valueOf(number).indexOf('0') != -1){
            throw new IllegalArgumentException("0을 포함하지 않아야 합니다.");
        }
        //세자리 수 중 같은 수가 있을때
        if(!uniqueChecker(String.valueOf(number))){
            throw new IllegalArgumentException("각 자리수에 같은 숫자가 존재하지 않아야 합니다.");
        }
    }

    private static void validGameContinueInput(int number) {
        //1 또는 2가 아닐때
        if(number != 1 && number != 2){
            throw new IllegalArgumentException("1 또는 2 중에 입력해야합니다.");
        }
    }

}
