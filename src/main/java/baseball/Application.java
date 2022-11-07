package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> input = new ArrayList<>();
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

    }
    public static void gmae(){
        while(true){
            System.out.println("숫자를 입력해주세요: ");
            inputValidate(Console.readLine());
        }
    }

    public static void answerValidate(){

    }

    public static void inputValidate(String input){
        lengthCheck(input);
        numberCheck(input);
        notEqualCheck();

    }

    public static void numberCheck(String str){
        try{
            for(int i=0; i<str.length(); i++){
                int value = Integer.parseInt(str.substring(i, i+1));
                input.add(value);
            }
        }catch(NumberFormatException nfe){throw new IllegalArgumentException();}
    }
    public static void lengthCheck(String input){
        if(input.length() != 3){
            throw new IllegalArgumentException();
        }
    }
    public static void notEqualCheck(){
        for(int i=0; i<input.size(); i++){
            int value = input.get(i);
            if(input.indexOf(value) != input.lastIndexOf(value)) throw new IllegalArgumentException();  // 리스트에 값이 여러 개 존재한다는 의미이므로 IllegalArgumentException 발생
        }
    }

    public static void resultCheck(){

    }

    public static int ballCheck(int strike){
        return 0;
    }
    public static int strikeCheck(){
        return 0;
    }

    public static void printResult(){

    }
    public static boolean exitGameValidate(){
        throw new IllegalArgumentException();
    }

}