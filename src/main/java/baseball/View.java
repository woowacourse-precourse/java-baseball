package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class View {
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    static final void printStartGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static final void printChoiceEndOrNewGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    static final void printPleaseInputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    static final void printStrike(int num){
        System.out.println(num + "스트라이크");
    }

    static final void printBall(int num){
        System.out.println(num + "볼");
    }

    static final void printBallAndStrike(int ball, int strike){
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    static final String getUserInput() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
