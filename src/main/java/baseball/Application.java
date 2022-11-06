package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


public class Application {
    public static void makeRandomValue(List<Integer> computer){
        computer.clear();
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static void checkInputNumber(String input){
        if(input.matches("[0-9]+"))
            throw new IllegalArgumentException("숫자로 이루어진 입력이 아닙니다.");
        if(input.length() != 3)
            throw new IllegalArgumentException("길이가 3인 숫자 입력이 아닙니다.");
        HashSet<Integer> checkHastSet = new HashSet<>();
        for(int i=0; i<3; i++)
            checkHastSet.add(Integer.parseInt(input.substring(i,i+1)));
        if(checkHastSet.size() != 3)
            throw new IllegalArgumentException("중복된 숫자가 포함된 숫자 입력입니다.");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        makeRandomValue(computer);

        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String input = scan.nextLine();
            checkInputNumber(input);

        }
    }
}
