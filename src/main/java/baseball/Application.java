package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input;
        String oneMore = "1";
        int randomNumber;
        while (oneMore.equals("1")){
            randomNumber = getRandomNumber();
            oneMore = getOneMoreInput();
        }
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
