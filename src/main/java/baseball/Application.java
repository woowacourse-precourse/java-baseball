package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        PlayerInput player = new PlayerInput();
        Computer computer = new Computer();
        List<Integer> numOfComputer = new ArrayList<Integer>();

        String input = Console.readLine();
        player.InputTest(input);

        numOfComputer = computer.GenerateRandomThreeNumber();

        System.out.println("Player's number: " + input);
        System.out.println("Computer's number: " + numOfComputer);

    }


}
