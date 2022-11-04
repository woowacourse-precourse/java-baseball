package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private static String makeRandomNumbers(){
        double randomNumber = Math.random();
        StringBuilder result = new StringBuilder();
        for(int i=0;i<3;i++){
            int iValue = (int)(randomNumber * 10);
            result.append(iValue);
        }
        return result.toString();
    }
    private static ArrayList<String> splitInputToArray(String input){
        ArrayList<String> result= new ArrayList<>();
        for(int i=0;i<input.length();i++){
            result.add(String.valueOf(input.charAt(i)));
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner inputObject = new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");
        String answer = makeRandomNumbers();
        System.out.println(answer);

        System.out.print("숫자를 입력해주세요 : ");
        String number = inputObject.nextLine();
        ArrayList<String> numberArray = splitInputToArray(number);
        System.out.println(numberArray);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
