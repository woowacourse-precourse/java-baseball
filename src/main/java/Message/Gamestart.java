package Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gamestart {
    public List<Integer> playerNumber(){
        System.out.println("숫자를 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        List<Integer> playerNum = new ArrayList<>();
        String input = scanner.next();
        if(input.length() != 3) throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        for(String number: input.split("")){
            playerNum.add(Integer.parseInt(number));
        }
        return playerNum;
    }
}
