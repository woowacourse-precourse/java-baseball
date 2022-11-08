package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BaseballGame {
    Scanner sc = new Scanner(System.in);
    List<Integer> num_list = new ArrayList<>();
    List<Integer> my_list = new ArrayList<>();
    int ballCount;
    int strikeCount;

    public BaseballGame() {
        makeNumList();
        initalizeBall();
    };

    public void makeNumList() {

    }

    public void initalizeBall() {
        int ballCount = 0;
        int strikeCount = 0;
    }

    public void writeMyNumList() {

    }

    public void strikeBall() {

    }

     public void message() {

     }

}

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        loop:
        while(true) {
            BaseballGame baseballGame = new BaseballGame();
            while(true) {
                baseballGame.writeMyNumList();
                baseballGame.strikeBall();
                baseballGame.message();
            }
        }

    }

}
