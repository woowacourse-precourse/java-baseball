package baseball.domain;

import baseball.utils.ChangeToChar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    final ChangeToChar changeToChar = new ChangeToChar();
    private char[] number;
    private Player player;
    public Game getInstance(int minNum,int maxNum){
        if (player==null){
            player = new Player();
        } else{
            player.init();
        }
        number = changeToChar.changetoChar(randNumGenerate(minNum, maxNum));
        return this;
    }
    public int randNumGenerate(int minNum, int maxNum) {
        int number = 0;
        List<Integer> numList = new ArrayList<>();
        int digit = 100;
        do {
            int tempnumber;
            do {
                tempnumber = Randoms.pickNumberInRange(minNum, maxNum);
            } while(numList.contains(tempnumber));

            numList.add(tempnumber);
            number += tempnumber * digit;
            digit /= 10;
        } while(digit != 0);
        return number;
    }
    public void check(int cur) {
        for(int i = 0; i < 3; ++i) {
            if (number[i] == player.getInput()[cur] && i==cur) {
                player.plusStrike();
                return;
            } else if(number[i] == player.getInput()[cur]){
                player.plusBall();
                return;
            }
        }
    }
    public void printBaseBallCount() {
        if (player.getStrike() == 3) {
            System.out.println("3스트라이크");
        } else if (player.getStrike() == 0 && player.getBall() == 0) {
            System.out.println("낫싱");
        } else if (player.getStrike() != 0 && player.getBall() != 0) {
            System.out.println(player.getBall() + "볼 " + player.getStrike() + "스트라이크");
        } else if (player.getStrike() != 0 && player.getBall() == 0) {
            System.out.println(player.getStrike() + "스트라이크");
        } else if (player.getStrike() == 0 && player.getBall() != 0) {
            System.out.println(player.getBall() + "볼");
        }
    }
    public Player getPlayer(){
        return player;
    }
}
