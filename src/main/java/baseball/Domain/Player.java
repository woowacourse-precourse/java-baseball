package baseball.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private List<Integer> playerGameNumbers = new ArrayList<>();

    public void insertPlayerNumbers() {
        try {
            List<String> numbers = List.of(Console.readLine().split(""));
            List<Integer> playerNumbers = numbers.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            System.out.println();

            if (!Validator.checkIsCorrectNums(playerNumbers)) {
                throw new IllegalArgumentException("잘못된 번호를 입력하셨습니다.");
            }
            setPlayerGameNumbers(playerNumbers);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 번호를 입력하셨습니다.");
        }

    }

    public int getAnswerAboutRestart() {
        try{
            int playerInput =  Integer.parseInt(Console.readLine());
            return playerInput;

        }catch(Exception e){
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
    }
    public List<Integer> getPlayerGameNumbers() {
        return playerGameNumbers;
    }

    public void setPlayerGameNumbers(List<Integer> playerGameNumbers) {
        this.playerGameNumbers = playerGameNumbers;
    }

}
