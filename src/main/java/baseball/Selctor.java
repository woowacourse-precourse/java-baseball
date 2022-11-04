package baseball;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Selctor {

    private final Crew crew;

    public Selctor(int[] number){
        this.crew = new Crew(number);

    }
    private List<Character> getPlayerNumberToChar(Member targetMember){
        List<Character> player = new ArrayList<>();
        int num = targetMember.getNumber();

        for (int len = String.valueOf(num).length(), i =0; i<len; i++){
           player.add(String.valueOf(num).charAt(i));
        }
        return player;
    }
    private List<Integer> getComputerNumber(){
        List<Integer> computer = new ArrayList<>();

        while(computer.size()<=3){
            int ranNum = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(ranNum)){
                computer.add(ranNum);
            }
        }
        return computer;
    }
    private int[] comparePlayerVsComputer(List<Character> player, List<Integer> computer){
        int ball = 0;
        int strike = 0;

        for (int len = player.size(), i=0; i<len;i++){
            int play = player.get(i) - '0';

            if (play== computer.get(i)){
                strike++;
         }

        }

        return 1;
    }
    private boolean isBall(int playerNum, List<Integer> computer){

        for (int i = 0; i<3; i++){
            for (int j = i+1; j<3; j++){
                if (playerNum == computer.get(j)){
                    return true;
                }
            }
        }
        return false;
    }
}
