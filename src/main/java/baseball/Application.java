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

        if(guess.length() == 3 ) System.out.println(guess);
        else throw new IllegalArgumentException ("입력이 잘못되었습니다");
    }
}