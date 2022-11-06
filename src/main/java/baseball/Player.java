package baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    public List<Integer> enterNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String playerInput = Console.readLine();

        if(!validateIsThreeNumber(playerInput)|| !validateIsUniqueNumber(playerInput)){
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }

        return convertToIntegerList(playerInput);
    }

    public boolean wantToRestart(){
        int RESTART_NUMBER = 1;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int playerInput = enterRestartNumber();
        return playerInput == RESTART_NUMBER;
    }


    public int enterRestartNumber(){
        String playerInput = Console.readLine();
        if (!validateIsRestartNumber(playerInput)){
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
        return Integer.parseInt(playerInput);
    }

    private boolean validateIsThreeNumber(String playerInput) {
        return playerInput.matches("^[0-9]{3}$");
    }

    private boolean validateIsUniqueNumber(String playerInput) {
        int COMPARE_LENGTH = 3;
        long inputLength = Arrays.stream(playerInput.split("")).distinct().count();
        return COMPARE_LENGTH == inputLength;
    }

    private boolean validateIsRestartNumber(String playerInput) {
        return playerInput.matches("^[1-2]$");
    }


    public static List<Integer> convertToIntegerList(String playerInput) {
        return Arrays.stream(playerInput.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

}
