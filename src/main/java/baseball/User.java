package baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userNumber;
    private String gameCoin;

    public void setUserNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();

        try{
            Validation validation = new Validation();
            validation.validateUserNumber(userNumber);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }

        this.userNumber = toList(userNumber);
    }

    public List<Integer> toList(String userNumber){
        List<Integer> userNumberList = new ArrayList<>();

        for(int userNumberIndex = 0; userNumberIndex<userNumber.length();userNumberIndex++){
            // validate를 통해 3글자 숫자임이 확정이므로 0의 아스키 코드 값이 48임을 이용해 문자를 숫자로 바꾸어준다.
            userNumberList.add(userNumber.charAt(userNumberIndex) - 48);
        }

        return userNumberList;
    }

    public List<Integer> getUserNumber(){
        return this.userNumber;
    }

    public void setGameCoin(){
        String gameCoin=Console.readLine();
        try{
            Validation validation = new Validation();
            validation.validateGameCoin(gameCoin);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }

        this.gameCoin=gameCoin;
    }

    public String getGameCoin(){
        return this.gameCoin;
    }

}
