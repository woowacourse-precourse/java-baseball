package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<Integer> random ;
    Game(){
        List<Integer> randomNumbers = new ArrayList<>();
        while(randomNumbers.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!randomNumbers.contains(randomNumber)){
                randomNumbers.add(randomNumber);
            }
        }
        this.random = randomNumbers;
    }
    public boolean playgame(){
        while(true){
            Inputnumber inputnumber = new Inputnumber();
            inputnumber.inputCheck();
            List inputNumber = inputnumber.stringTointList();

            Comparenumber comparenumber = new Comparenumber(random, inputNumber);
            comparenumber.compareprint();
            if (!comparenumber.isbaseballcontinue()) return false;
        }
    }


}
