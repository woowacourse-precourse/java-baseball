package baseball;


import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static Boolean gameBreak(){
        int input = Integer.parseInt(Console.readLine());
        return getBreakConditional(input);
    }

    private static Boolean getBreakConditional(int input) {
        if(input == 2){
            return true;
        } else if (input == 1) {
            return false;
        }else {
            throw new IllegalArgumentException();
        }
    }
}
