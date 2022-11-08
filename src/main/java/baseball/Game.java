package baseball;
import java.util.*;


public class Game {

    public void startGame(String[] input) throws IllegalAccessException {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 사용자가 잘못된 값을 입력할 경우
        if(input.length != 3){
            throw new IllegalAccessException();
        }

        List<Integer> user = new ArrayList<>();
        for(int i = 0; i < input.length; i++){
            user.add(Integer.parseInt(input[i]));
        }


    }

}
