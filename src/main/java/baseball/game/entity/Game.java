package baseball.game.entity;

import baseball.computer.entity.Computer;
import baseball.computer.service.ComputerService;
import baseball.user.convert.NumberConvert;
import baseball.user.service.UserService;

import java.util.Scanner;

public class Game {
    private final UserService userService;
    private final ComputerService computerService;
    private final NumberConvert convert;

    private int[] score = new int[2];
    boolean flag;

    public Game(){
        this.userService = new UserService();
        this.computerService = new ComputerService();
        this.convert = new NumberConvert();
    }

    public void play(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerService.setRandomNumber();
        while(flag != true) {
            start();
        }
    }
    public void start(){
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        userService.inputUserNumber = sc.next();
        userService.setUserNumber();
        printScore(userService.inputUserNumber);
    }
    public void end(){
        int endUserInput;

        Scanner sc = new Scanner(System.in);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하면 2를 입력하세요.");
        endUserInput = sc.nextInt();


        if(endUserInput == 1) {
            flag = false;
            start();
        } else if(endUserInput == 2) {
            //PASS
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void printScore(String strUserNumber){
        Integer integerUserNumber = convert.stringNumberToInteger(strUserNumber);
        Integer[] individualUserNumber = convert.integerToIntegerArrOfEachElement(integerUserNumber);

        for(int i = 0; i < individualUserNumber.length; i++) {
            setScore(i, individualUserNumber[i]);
        }

        checkingScore();
    }

    public void setScore(int index, int userNumber){
        for (int j = 0; j < computerService.computerNumbers.length; j++) {
            if (index == j && userNumber == computerService.computerNumbers[j]) {
                score[0] = score[0] + 1;
            } else if (index != j && userNumber == computerService.computerNumbers[j]) {
                score[1] = score[1] + 1;
            }
        }
    }

    public void checkingScore() {
        if (score[1] == 0 && score[0] == 0) {
            System.out.println("낫싱");
        } else if(score[1] > 0 && score[0] > 0 && score[0] < 3) {
            System.out.println(score[1] + "볼 " + score[0] + "스트라이크");
            score[0] = 0;
            score[1] = 0;
        } else if (score[1] > 0 && score[1] < 4 && score[0] == 0) {
            System.out.println(score[1] + "볼 ");
            score[0] = 0;
            score[1] = 0;
        } else if (score[0] > 0 && score[0] < 3 && score[1] == 0){
            System.out.println(score[0] + "스트라이크 ");
            score[0] = 0;
            score[1] = 0;
        }else {
            System.out.println("3 스트라이크");
            score[0] = 0;
            score[1] = 0;
            flag = true;
            end();
        }
    }
}
