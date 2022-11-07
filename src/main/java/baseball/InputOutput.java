package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class InputOutput {
    public static int[] getThreeNumber(){
        printThreeNumber();
        String line = getLine();
        // 예외처리 다 해주고

        int[] threeWord = new int[3];
        for (int i = 0; i < line.length(); i++) {
            threeWord[i] = charToInt(line.charAt(i));
        }
        return threeWord;
    }

    public static int getRestartNumber(){
        printRestartNumber();
        String line = getLine();
        // 예외처리 다 해주고

        return charToInt(line.charAt(0));
    }

    public static int[] getRandomAnswer(){
        int[] duplicationChecking = new int[10];
        int[] gotThreeNumber = new int[3];

        int i = 0;
        while (i < 3){
            int num = Randoms.pickNumberInRange(1, 9);
            if (duplicationChecking[num] == 0){
                duplicationChecking[num] = 1;
                gotThreeNumber[i] = num;
                i += 1;
            }
        }
        return gotThreeNumber;
    }

    public static void printGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void printStrikeBall(int strike, int ball){
        if (strike == 0 && ball == 0){
            System.out.println("낫싱");
        }
        if (ball > 0 && strike > 0){
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (ball > 0 && strike == 0){
            System.out.println(ball + "볼 ");
        }
        if (ball == 0 && strike > 0){
            System.out.println(strike + "스트라이크");
        }
    }

    public static void printCorrectNumber(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static void printThreeNumber(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    private static void printRestartNumber(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }



    private static String getLine(){
        return Console.readLine();
    }

    private static int charToInt(char c){
        return c - '0';
    }
}
