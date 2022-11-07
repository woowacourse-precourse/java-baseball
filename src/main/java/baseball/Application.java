package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input;
        String oneMore = "1";
        int randomNumber;
        int ball = 0;
        int strike = 0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (oneMore.equals("1")){
            randomNumber = getRandomNumber();
            while (strike != 3){
                input = getInput();
                ball = getBall(input, randomNumber);
                strike = getStrike(input, randomNumber);
                printResult(ball, strike);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            oneMore = getOneMoreInput();
        }
    }

    static int getBall(String input, int randomNumber)
    {
        int ret = 0;
        int one;
        int ten;
        int hundred;

        one = randomNumber % 10;
        randomNumber /= 10;

        ten = randomNumber % 10;
        randomNumber /= 10;

        hundred = randomNumber % 10;

        if (input.charAt(0) - '0' == ten || input.charAt(0) - '0' == one){
            ret++;
        }
        if (input.charAt(1) - '0' == hundred || input.charAt(1) - '0' == one){
            ret++;
        }
        if (input.charAt(2) - '0' == hundred || input.charAt(2) - '0' == ten){
            ret++;
        }

        return ret;
    }

    static int getStrike(String input, int randomNumber){
        int ret = 0;
        int one;
        int ten;
        int hundred;

        one = randomNumber % 10;
        randomNumber /= 10;

        ten = randomNumber % 10;
        randomNumber /= 10;

        hundred = randomNumber % 10;

        if (input.charAt(0) - '0' == hundred){
            ret++;
        }
        if (input.charAt(1) - '0' == ten){
            ret++;
        }
        if (input.charAt(2) - '0' == one){
            ret++;
        }

        return ret;
    }

    static void printResult(int ball, int strike){
        if (ball == 0 && strike == 0){
            System.out.println("낫싱");
            return;
        }
        if (ball != 0 && strike != 0){
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            return;
        }
        if (ball != 0){
            System.out.printf("%d볼\n", ball);
            return;
        }
        System.out.printf("%d스트라이크\n", strike);
    }

    static int getRandomNumber(){
        int ret;

        while (true){
            ret = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(100, 999);
            if (isValidRandomNumber(ret)){
                break;
            }
        }
        return ret;
    }

    static boolean isValidRandomNumber(int num){
        int one;
        int ten;
        int hundred;

        one = num % 10;
        num /= 10;

        ten = num % 10;
        num /= 10;

        hundred = num % 10;

        if (hundred == ten || hundred == one || ten == one){
            return false;
        }
        return true;
    }

    static String getInput() throws IllegalArgumentException{
        String ret = camp.nextstep.edu.missionutils.Console.readLine();

        if (ret.length() != 3 || !isValidInputNumber(ret)){
            throw new IllegalArgumentException();
        }
        return ret;
    }

    static boolean isValidInputNumber(String str){
        for (int i = 0; i < str.length(); i++){
            if (!(str.charAt(i) >= '1' && str.charAt(i) <= '9')){
                return false;
            }
        }

        for (int i = 0; i < str.length(); i++){
            if (isDuplicate(str.charAt(i), str)){
                return false;
            }
        }

        return true;
    }

    static boolean isDuplicate(char c, String str){
        int cnt = 0;
        for (int i = 0; i < str.length(); i++){
            if (c == str.charAt(i)){
                cnt++;
            }
        }

        if (cnt > 1){
            return true;
        }
        return false;
    }

    static String getOneMoreInput() throws IllegalArgumentException{
        String ret = camp.nextstep.edu.missionutils.Console.readLine();

        if (ret.equals("1") || ret.equals("2")){
            return ret;
        }
        throw new IllegalArgumentException();
    }
}
