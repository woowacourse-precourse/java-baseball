package baseball.service;

import static baseball.constant.Message.USER_INPUT_MESSAGE;
import static baseball.valid.Valid.*;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    /**
     * 유저의 Consle 입력을 받아오는 메소드
     * @return User의 콘솔 입력
     */
    public String userInput(){
        System.out.println(USER_INPUT_MESSAGE);
        String userInput = Console.readLine();

        validUserInputSize(userInput);
        validUserInputNotNumber(userInput);
        validDuplicateNumber(userInput);

        return userInput;
    }

    /**
     * 유저의 게임 재시작 여부를 입력받는 메소드
     * @return user의 콘솔 입력
     */
    public String userRestartInput(){
        String userInput = Console.readLine();
        validRestartNumber(userInput);

        return userInput;
    }

    /**
     * User가 입력한 번호의 각 자리수를 List에 담아 반환하는 메소드
     * @param userNumber User가 입력한 번호
     * @return 입력한 번호의 각 자리수를 담은 List
     */
    public List<Integer> getUserNumber(String userNumber){
        String[] split = userNumber.split("");

        return Arrays.stream(split).map(Integer::valueOf).collect(Collectors.toList());
    }
}
