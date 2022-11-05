package baseball.Service;

import baseball.Model.Balls;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GameServiceImpl implements GameService {

    private Balls balls;

    public GameServiceImpl(){
        this.balls = new Balls();
    }

    @Override
    public void generateNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append(Randoms.pickNumberInRange(1,9));
        while(sb.length() != 3) sb.append(getUniqueNumber(sb.toString()));
        String answerNum = sb.toString();
        this.balls.setValue(0,answerNum.charAt(0) - '0');
        this.balls.setValue(1,answerNum.charAt(1) - '0');
        this.balls.setValue(2,answerNum.charAt(2) - '0');
    }

    @Override
    public int getUniqueNumber(String numStr) {
        int num;
        for(num = Randoms.pickNumberInRange(1,9); !numStr.contains(String.valueOf(num));){
            return num;
        }
        return 0;
    }

    @Override
    public int[] getInputs() {
        String intputNum = Console.readLine();
        if (intputNum.length() != 3) {
            throw new IllegalArgumentException();
        }

        try {
            Integer.parseInt(intputNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return new int[]{
                intputNum.charAt(0) - '0',
                intputNum.charAt(1) - '0',
                intputNum.charAt(2) - '0'
        };
    }


}
