package baseball.service;

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
        return Console.readLine();
    }

    /**
     * User가 입력한 번호의 각 자리수를 List에 담아 반환하는 메소드
     * @param userNumber User가 입력한 번호
     * @return 입력한 번호의 각 자리수를 담은 List
     */
    public List<Integer> getUserNumber(String userNumber){
        String[] split = userNumber.split("");

        return Arrays.stream(split).map(c->Integer.valueOf(c)).collect(Collectors.toList());
    }
}
