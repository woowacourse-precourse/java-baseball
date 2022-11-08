package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class GamePlay {
    static NumberCheck numberCheck=new NumberCheck();
    public static String gamePlay() {
        int checkstrike;
        String nextGame;
        List<Integer> answer = makeRandomNum();
        while (true) {
            String number = numberInput();
            if (number.length() != 3){
                throw new IllegalArgumentException("입력숫자 길이가 3자리가 아닙니다. 다시 입력해주세요.");
            }
            NumberCheck.sameNumberCheck(number);
            NumberCheck.nullCheck(number);
            checkstrike = NumberCheck.Check(number, answer);
            if (checkstrike == 3) {
                nextGame = readLine();
                break;
            }
        }
        return nextGame;
    }
    public static List<Integer> makeRandomNum() {
        List<Integer> list = new ArrayList<>();
        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }
        return list;
    }
    public static String numberInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String num = readLine();
        return num;
    }
}
