package baseball;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        boolean isRestart = true;
        while (isRestart) {
            isRestart = StartNumberBaseballGame();
        }
    }

    public static boolean StartNumberBaseballGame(){
        List<Integer> computer = GenerateComputerNumbers();
        List<Integer> player = GeneratePlayerNumbers();
        return false;
    }

    public static int CheckStrike(List<Integer> computer, List<Integer> player){
        int strike = 0;
        for(int index = 0; index < computer.size(); index ++){
            if(computer.get(index) == player.get(index)){
                strike ++;
            }
        }
        return strike;
    }

    public static List<Integer> GeneratePlayerNumbers(){
        List<Integer> player = new ArrayList<>();
        String input = Console.readLine();
        int tempNumbers = Integer.parseInt(input);
        int divider = (int)Math.pow (10, input.length() -1 );
        while(divider > 0){
            player.add(tempNumbers / divider);
            tempNumbers = tempNumbers - (player.get(player.size() - 1)) * divider;
            divider = divider / 10;
        }
        return player;
    }

    public static List<Integer> GenerateComputerNumbers(){
        List<Integer> computer = new ArrayList<>(0);
        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
//        List<Integer> computer = new ArrayList<>();
//        while (computer.size() < 3) {
//            int randomNumber = Randoms.pickNumberInRange(1, 9);
//            if (!computer.contains(randomNumber)) {
//                computer.add(randomNumber);
//            }
//        }
//        String input = Console.readLine();
//        System.out.println(input);
//        System.out.println(computer);
