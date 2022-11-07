package baseball;

import java.util.ArrayList;
import java.util.List;

public class MainGame {
    RandomBaseballNum RandomBaseballNum = new RandomBaseballNum();
    numberScan numberScan = new numberScan();
    Refree refree = new Refree();
    Continue Continue = new Continue();
    boolean again = true;
    public void playGames(){
        while(again){
            List<Integer> Computer = RandomBaseballNum.randomNum();
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> result = new ArrayList<>();
            result = numberScan.playerGames();
            String results = result.toString();
            while(!results.equals("3스트라이크")){
                results = refree.judgement(Computer, numberScan.playerGames());
                System.out.println((results));
            }
            again = Continue.decideContinue();
        }
    }

}
