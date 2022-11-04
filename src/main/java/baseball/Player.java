package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    private List<Integer> threeDifferentNumbers;

    public List<Integer> createThreeDifferentNumbers() {
        threeDifferentNumbers = new ArrayList<>();
        
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        splitToDigits(input);
        
        return threeDifferentNumbers;
    }

    public void splitToDigits(String input) {
        for (char character : input.toCharArray()) {
            Integer number = Character.getNumericValue(character);
            threeDifferentNumbers.add(number);
        }
    }

    public static void main(String[] args) {
        Player player = new Player();
        System.out.println(player.createThreeDifferentNumbers());
    }
}
