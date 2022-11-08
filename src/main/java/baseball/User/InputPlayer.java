package baseball.User;

import static baseball.User.Game.InputSt;

public class InputPlayer {


    public int[] enterAnswer() {
        String strNumber;

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            strNumber = InputSt();
            if (strNumber.length() != 3) {

                throw new IllegalArgumentException();


            }

                break;
        }


        String[] temp = (strNumber).split("");
        int[] userNumber = new int[3];

        for (int i = 0; i < 3; i++) {
            userNumber[i] = Integer.parseInt(temp[i]);
        }

        return userNumber;
    }

}
