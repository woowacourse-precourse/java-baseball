package baseball;

import camp.nextstep.edu.missionutils.*;

public class InputOutput {
    public static int[] getThreeNumber(){
        String line = getLine();
        // 예외처리 다 해주고

        int[] threeWord = new int[3];
        for (int i = 0; i < line.length(); i++) {
            threeWord[i] = charToInt(line.charAt(i));
        }
        return threeWord;
    }

    public static int getRestartNumber(){
        String line = getLine();
        // 예외처리 다 해주고

        return charToInt(line.charAt(0));
    }

    private static String getLine(){
        return Console.readLine();
    }

    private static int charToInt(char c){
        return c - '0';
    }
}
