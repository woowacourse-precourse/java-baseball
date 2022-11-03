package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

    }
    public void playGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        String guess = "";

        System.out.print("숫자를 입력해주세요 : ");
        guess = String.valueOf(new Scanner(System.in));

        checkString(guess);
    }

    public void checkString(String str){
        int temp = 1;
        if (str.length()!=3)
            throw new IllegalArgumentException();

        for (int i = 0; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                throw new IllegalArgumentException();
            }
        }
    }
}