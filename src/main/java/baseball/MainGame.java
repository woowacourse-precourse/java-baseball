package baseball;

import java.util.List;

public class MainGame {
    public static void main(String args[]){
        RandomBaseballNum randomNumber = new RandomBaseballNum();
        numberScan player = new numberScan();
        Refree judge = new Refree();
        Continue decideContinue = new Continue();
        boolean again = true;

        while(again){
            List<Integer> Computer = randomNumber.randomNum();
            String result = "";
            while(!result.equals("3스트라이크")){
                result = judge.judgement(Computer, player.playerGames());
                System.out.println((result));
            }
            again = decideContinue.decideContinue();
        }
    }

}
