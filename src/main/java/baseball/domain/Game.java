package baseball.domain;

import baseball.utils.ChangeToChar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    final ChangeToChar changeToChar = new ChangeToChar();
    private char[] number;
    private Player player;
    public Game(int minNum,int maxNum){
        number = changeToChar.changetoChar(randNumGenerate(minNum, maxNum));
        player = new Player();
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
    public char[] getNumber() {
        return number;
    }
    public Player getPlayer(){
        return player;
    }
}
