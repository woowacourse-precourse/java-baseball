package baseball.domain.player;

import java.util.stream.Stream;

import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Console;

public class UserPlayer extends Player {

    @Override
    public void getNumber() throws IllegalArgumentException {
        String strInput = Console.readLine();
        if (strInput.length() != GameService.LENGTH_OF_NUM) { // 1. 길이가 맞지 않는 값이 입력된 경우
            throw new IllegalArgumentException();
        }

        int intInput = Integer.parseInt(strInput);
        int[] arrInput = Stream.of(String.valueOf(intInput).split("")).mapToInt(Integer::parseInt).toArray();
        int[] check = new int[10];
        for (int i = 0; i < strInput.length(); i++) {
            if (check[arrInput[i]] == 1) { // 2. 각 자리수의 값이 중복이 있는 경우
                throw new IllegalArgumentException();
            }
            check[arrInput[i]] = 1;
        }

        number = intInput;
    }
    
}
