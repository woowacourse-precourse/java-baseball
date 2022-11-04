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
        List<Integer> computer = ChooseComputerNumbers(); // 컴퓨터의 숫자 입력받기
        return false;
    }

    public static List<Integer> ChooseComputerNumbers(){
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
