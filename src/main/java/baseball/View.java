package baseball;

import java.util.HashSet;
import java.util.Scanner;


public class View {

    private final Scanner scanner;
    private final String INPUT_NUMBER="숫자를 입력해주세요 : ";

    public View(Scanner scanner) {
        this.scanner = scanner;
    }


    public String userRequestNumber(){

        viewMessage(INPUT_NUMBER);
        String input = scanner.nextLine();

        if(userInputException(input)){
            return input;
        }
        else {
            throw new IllegalArgumentException("입력값 오류로 인하여 프로그램을 종료합니다");
        }
    }

    public void viewMessage(String message){
        System.out.println(message);
    }

    private boolean userInputException(String input){

        HashSet<Character> overlapCheck = new HashSet<>();

        if(input.length()!=3)return false;

        for(int i=0;i<input.length();i++){
            char number = input.charAt(i);
            overlapCheck.add(number);
            if(number<'0'||number>'9') return false;
        }

        if(overlapCheck.size()!=3) return false;

        return true;
    }

}
