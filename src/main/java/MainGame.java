package baseball;

import java.util.List;

public class MainGame {
    public static void main(String[] args) {
        GenerateRandomNum randomNum = new GenerateRandomNum();
        Input input = new Input();
        Judge judge = new Judge();
        Restart restart = new Restart();
        boolean re = true;

        while (re) {
            List<Integer> computer = randomNum.create();
            String result = "";
            while (!result.equals("3스트라이크")) {
                result = judge.judgement(computer, input.playerNumber());
                System.out.println(result);
            }
            re = restart.restart();
        }
    }
}