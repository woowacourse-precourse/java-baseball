package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static int opponent1;
    public static int opponent2;
    public static int opponent3;

    public static void initOpponentNumber(){
        // num1 ~ num3까지 랜덤한 숫자를 넣는다.
        opponent1 = Randoms.pickNumberInRange(1, 9);
        while (true){
            opponent2 = Randoms.pickNumberInRange(1, 9);
            if (opponent1 != opponent2)
                break;
        }
        while (true){
            opponent3 = Randoms.pickNumberInRange(1, 9);
            if (opponent2 != opponent3 && opponent1 != opponent3)
                break;
        }
    }

    public static void main(String[] args) {
        initOpponentNumber();
    }
}