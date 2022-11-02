package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int user_input=userInput();
    }

    private static int userInput() {
        String input_String;
        int input_int;
        Scanner scanner=new Scanner(System.in);

        input_String=scanner.next();
        input_int=input_String_to_int(input_String);
        return input_int;
    }
}
