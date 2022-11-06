package baseball;

import camp.nextstep.edu.missionutils.*;

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
