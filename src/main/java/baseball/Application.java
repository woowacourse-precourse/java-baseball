package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Integer> randomNumberByComputer;
        List<Integer> randomNumberByUser;

        System.out.println("숫자 야구 게임을 시작합니다.");


        while(true){
            randomNumberByComputer = generateRandomNumber();
            System.out.print("숫자를 입력해주세요 : ");
            randomNumberByUser = inputNumberByUser();


        }

    }

    private static List<Integer> generateRandomNumber(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static List<Integer> inputNumberByUser(){
        List<Integer> inputNumber = new ArrayList<>();
        String num = Console.readLine();

        for(int i = 0; i <num.length(); i++){
            inputNumber.add((int) num.charAt(i));
        }
        return inputNumber;
    }
}
