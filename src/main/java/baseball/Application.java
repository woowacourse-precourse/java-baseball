package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        play();
        isNewGame();
    }
    public static void play(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        int min = 100;
        int max = 999;
        String random = String.valueOf((int) ((Math.random() * (max - min)) + min));
        guess(random);
    }
    public static void guess(String com_num){
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요 :");
        String usr_num= sc.next();
    }
    public static void isNewGame(){

    }
}
