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
}
