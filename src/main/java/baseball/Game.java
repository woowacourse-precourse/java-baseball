package baseball;
import camp.nextstep.edu.missionutils.Console;
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
            Input inputnumber = new Input();
            inputnumber.inputCheck();
            List inputNumber = inputnumber.stringTointList();
            Compare comparenumber = new Compare(random, inputNumber);
            comparenumber.compareprint();
            if (!comparenumber.isbaseballcontinue()) return false;
        }
    }
    public boolean gameRestart(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if(Integer.valueOf(input)==1) return true;
        if(Integer.valueOf(input)==2) return false;

        new IllegalArgumentException("해당하는 숫자가 아닙니다. 프로그램을 종료합니다.");
        return false;

    }
}
