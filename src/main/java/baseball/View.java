package baseball;

import java.util.HashSet;
import java.util.Scanner;


public class View {

    private final Scanner scanner;
    private final String INPUT_NUMBER="숫자를 입력해주세요 : ";

    public View(Scanner scanner) {
        this.scanner = scanner;
    }

    public int restOrExit(){
        String input = scanner.nextLine();

        if(resetOrExitException(input)){
            return Integer.parseInt(input);
        }
        else {
            throw new IllegalArgumentException("입력값 오류로 인하여 프로그램을 종료합니다");
        }
    }

    // 문자열 1 or 2 이외에는 전부다 예외처리
    public boolean resetOrExitException(String input){
        if(input.equals("1")||input.equals("2"))return true;
        else return false;
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

    //해쉬 셋을 이용하여 중복된 값이 못들어오게 설정한 후 사이즈가 3이 되지 않으면 중복된 값 존재로 파악
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
