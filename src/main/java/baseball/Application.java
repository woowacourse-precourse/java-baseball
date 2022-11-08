package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<Integer> computer = new ArrayList<>();
    static int strikeCount = 0;
    static int ballCount = 0;
    public static void main(String[] args) {
        do{
            while(true){//strickCount!=3
                //input
                List<Integer> input = valueToList(Integer.parseInt(Console.readLine()));
                strikeCount = strike(computer, input);
                ballCount = ball(computer, input);
            }
            //end game
        }while(true);//replay or exit
    }

    public static List<Integer> valueToList(int value){
        List<Integer> list = new ArrayList<>();

        while (value / 10 != 0) {
            list.add(0, value % 10);
            value /= 10;
        }
        list.add(0, value % 10);
        return list;
    }
    private static int ball(List<Integer> computer, List<Integer> input) {
        int ball = 0;
        for (int i = 0; i < computer.size(); i++)
            if (!computer.get(i).equals(input.get(i)) && computer.contains(input.get(i))) ball++;
        return ball;
    }

    private static int strike(List<Integer> computer, List<Integer> input) {
        int strike = 0;
        for (int i = 0; i < computer.size(); i++)
            if (computer.get(i).equals(input.get(i))) strike++;
        return strike;
    }
    private static void reset() {
        strikeCount = 0;
        ballCount = 0;
        computer.clear();
    }
}