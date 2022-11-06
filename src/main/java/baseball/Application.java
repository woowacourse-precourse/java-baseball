package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputStr = Console.readLine();

        PlayerInput player = new PlayerInput();
        Computer computer = new Computer();

        List<Integer> numOfComputer = computer.GenerateRandomThreeNumber();
        List<Integer> numOfPlayer = player.ReturnPlayerNum(inputStr);

        System.out.println("Computer's number: " + numOfComputer);
        System.out.println("Player's number: " + numOfPlayer);

        CheckStrikes(numOfComputer, numOfPlayer);

    }

    public static void CheckStrikes(List<Integer> computer, List<Integer> player) {
        int strikes = 0;

        for(int i = 0; i < computer.size(); i++) {
            if(computer.get(i) == player.get(i)) {
                strikes++;
            }
        }

        System.out.println(strikes);
    }


}
