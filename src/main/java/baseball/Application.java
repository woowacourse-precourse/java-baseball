package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
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
        System.out.print("숫자를 입력해주세요 : ");
        String number = inputObject.nextLine();
        System.out.println(splitInputToArray(number));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
