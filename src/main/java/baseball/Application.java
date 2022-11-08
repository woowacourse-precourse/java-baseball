package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    static List<Integer> computer = new ArrayList<>();
    static List<Integer> player = new ArrayList<>();

    private static void computerNumber(List<Integer> list){
        while(list.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!list.contains(randomNumber)){
                list.add(randomNumber);
            }
        }
    }

    private static void playerNumber(List<Integer> list){
        int i = 0;
        System.out.print("숫자를 입력해주세요 : ");
        String value = Console.readLine();
        if(value.length() != 3){
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요");
        } else {
            while(list.size() < 3){
                list.add(Integer.parseInt(value.split("")[i]));
                i++;
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        computer.clear();
        computerNumber(computer);

        player.clear();
        playerNumber(player);

        System.out.println("게임 종료");
    }
}
