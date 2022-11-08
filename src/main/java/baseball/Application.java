package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        boolean repeat = true;

        while (repeat){
            List<Integer> computer = LetsPlayBall.createRandomNumber();
            String result = "";
            while (!result.equals("3스트라이크")){
                result = LetsPlayBall.gameResult(computer, LetsPlayBall.getSetGo());
                System.out.println(result);
            }
            repeat = LetsPlayBall.restart();
        }
    }
}
