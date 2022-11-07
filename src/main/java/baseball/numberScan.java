package baseball;

import java.util.*;

public class numberScan {
    public List<Integer> playerGames(){
        System.out.println("숫자를 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        List<Integer> Game = new ArrayList<>();
        String input = scanner.next();

        for(String number: input.split("")){
            Game.add(Integer.parseInt(number));
        }
        return Game;
    }
}
