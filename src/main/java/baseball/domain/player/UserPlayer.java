package baseball.domain.player;

import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Stream;

public class UserPlayer extends Player {

    @Override
    public void getNumber() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String strInput = Console.readLine();

        checkLengthOfInput(strInput);

        int intInput = Integer.parseInt(strInput);
        int[] arrInput = Stream.of(String.valueOf(intInput).split("")).mapToInt(Integer::parseInt).toArray();
        checkDuplicationOfInput(arrInput);

        number = intInput;
    }

    public void checkLengthOfInput(String strInput) throws IllegalArgumentException {
        if (strInput.length() != GameService.LENGTH_OF_NUM) { // 1. 길이가 맞지 않는 값이 입력된 경우
            throw new IllegalArgumentException();
        }
    }

    public void checkDuplicationOfInput(int[] arrInput) throws IllegalArgumentException {
        int[] check = new int[10];
        for (int j : arrInput) {
            if (check[j] == 1) { // 2. 각 자리수의 값이 중복이 있는 경우
                throw new IllegalArgumentException();
            }
            check[j] = 1;
        }
    }

}
