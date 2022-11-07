package baseball;

import java.util.Scanner;

public class Application {

    static boolean isDuplicate(char c, String str)
    {
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
    static boolean isValidNumber(String str)
    {
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
    static String getInput() throws IllegalArgumentException
    {
        String ret = camp.nextstep.edu.missionutils.Console.readLine();

        if (ret.length() != 3 || !isValidNumber(ret)){
            throw new IllegalArgumentException();
        }
        return ret;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input;
        while (true)
        {
            input = getInput();
        }
    }
}
