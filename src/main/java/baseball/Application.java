package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    static int[] number = new int[3];
    public static int getRandomNumber()
    {
        return Randoms.pickNumberInRange(1, 9);
    }
    public static void gameInitialize()
    {
        for (int i = 0 ; i< 3; i++)
            number[i] = getRandomNumber();
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //gameInitialize();
        //System.out.println(number[0]);
        //System.out.println(number[1]);
        //System.out.println(number[2]);

    }
}
