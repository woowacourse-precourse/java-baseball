package baseball;

import java.util.Scanner;

public class View {

    private final Scanner scanner;

    public View(Scanner scanner) {
        this.scanner = scanner;
    }


    public String userRequestNumber(){
        System.out.println("숫자를 입력해주세요 : ");
        String input = scanner.nextLine();

        if(userInputException(input)){
            return input;
        }
        else {
            throw new IllegalArgumentException("입력값 오류로 인하여 프로그램을 종료합니다");
        }
    }

    private boolean userInputException(String input){

        if(input.length()!=3)return false;

        for(int i=0;i<input.length();i++){
            char number = input.charAt(i);

            if(number<'0'||number>'9') return false;

        }
        return true;
    }

}
