package baseball;

import java.util.Random;
import java.util.Scanner;

public class Application {
    static Scanner sc;
    static Random random;

    static boolean inGame;
    static boolean isCorrect;
    static int num = 0;
    static int num1 = 0;
    static int num2 = 0;
    static int num3 = 0;

    static int com1;
    static int com2;
    static int com3;
    static boolean flag;

    static int strikeCount;
    static int ballCount;
    public static void main(String[] args){
        System.out.println("숫자 야구 게임을 시작합니다.");
        inGame = true;
        while(inGame){
            flag = true;
            makeRandomNumber();
            isCorrect = false;
            play();
        }
    }

    public static void input(){
        sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        num = sc.nextInt();
        num1 = num / 100;
        num2 = (num / 10) % 10;
        num3 = num % 10;
        if(num1 == num2 || num2 == num3 || num3 == num1){
            throw new IllegalArgumentException();
        }
    }

    public static void print(){
        if(strikeCount == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            sc = new Scanner(System.in);
            isCorrect = true;
            if(sc.nextInt() == 1){
                inGame = true;
            }
            else{
                inGame = false;
            }
        }
        else if(strikeCount == 0 && ballCount == 0){
            System.out.println("낫싱");
        }
        else if(ballCount != 0 && strikeCount == 0){
            System.out.println(ballCount + "볼");
        }
        else if(ballCount == 0){
            System.out.println(strikeCount + "스트라이크");
        }
        else{
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }
    public static void play(){
        while(!isCorrect){
            input();
            strikeCount = 0;
            ballCount = 0;
            verify(num1, num2, num3);
            print();
        }
    }

    public static void verify(int num1, int num2, int num3) {
        if(com1 == num1) strikeCount++;
        if(com2 == num2) strikeCount++;
        if(com3 == num3) strikeCount++;

        if(com1 == num2 || com1 == num3) ballCount++;
        if(com2 == num1 || com2 == num3) ballCount++;
        if(com3 == num1 || com3 == num2) ballCount++;
    }

    public static void makeRandomNumber(){
        while(flag){
            random = new Random();
            com1 = random.nextInt(100) % 9 + 1;
            com2 = random.nextInt(100) % 9 + 1;
            com3 = random.nextInt(100) % 9 + 1;
            if(com1 != com2 && com2 != com3 && com3 != com1) {
                flag = false;
            }
        }
    }
}
