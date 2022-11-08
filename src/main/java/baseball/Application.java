package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static List<Integer> readGameStep(){
        String nextStep = Console.readLine();
        if(nextStep.length() != 3) throw new IllegalArgumentException();

        List<Integer> human = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            int val = (int)(nextStep.charAt(i)-'0');
            if(!human.contains(val)){
                human.add(val);
            }else{
                throw new IllegalArgumentException("게임 진행 입력 오류");
            }
        }

        return human;
    }

    private static int readEndStep(){
        String endStep =  Console.readLine();
        int selectedNum = (int)(endStep.charAt(0) - '0');

        if(selectedNum == 1 || selectedNum == 2) return selectedNum;
        else throw new IllegalArgumentException("끝내기 입력 오류");
    }

    private static List<Integer> initComputer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static int[] match(List<Integer> computer, List<Integer> human){
        int[] result = {0, 0, 0};

        for (int i = 0; i < 3; i++){
            if(computer.get(i) == human.get(i)) result[1]++;
            else if(human.contains(computer.get(i))) result[0]++;
        }

        if(result[0] == 0 && result[1] == 0) result[2] = 1;

        return result;
    }
}
