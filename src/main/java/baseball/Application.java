package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static int strike=0,ball=0;
    public static int gameSwitch=1;
    public static ArrayList<Integer> opponentNumber=new ArrayList<Integer>();
    public static ArrayList<Integer> playerNumber=new ArrayList<Integer>();

    public static void pickRandomNumber(){
        opponentNumber.clear();
        while (opponentNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!opponentNumber.contains(randomNumber)) {
                opponentNumber.add(randomNumber);
            }
        }
    }

    public static void inputPlayerNumber(){
        playerNumber.clear();
        System.out.println("숫자를 입력해주세요 : ");
        String inputNumber=Console.readLine();

        for(int i=0;i<3;++i){
            playerNumber.add(inputNumber.charAt(i)-'0');
        }
    }

    public static void main(String[] args) {
    }
}
