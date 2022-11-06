package baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private final int RESTART_NUMBER = 1;
    private final int EXIT_NUMBER = 2;

    public List<Integer> enterNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String playerInput = Console.readLine();

        return convertToIntegerList(playerInput);
    }

    public boolean wantToRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int playerInput = enterRestartNumber();
        if (playerInput == RESTART_NUMBER)
            return true;
        if (playerInput == EXIT_NUMBER)
            return false;
        throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
    }


    public int enterRestartNumber(){
        String playerInput = Console.readLine();

        return Integer.parseInt(playerInput);
    }


    public static List<Integer> convertToIntegerList(String playerInput) {
        return Arrays.stream(playerInput.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }


}
