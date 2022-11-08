package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    class Baseball {
        List<Integer> computerNum;
        int[] computerNumCheck = new int[10];
        int[] strikeResult = new int[3];

        public void clear(){}
        public boolean startGame() throws IOException {

        }
        public List<Integer> makeComputerNum() {
            List<Integer> computerNum = new ArrayList<>();

            while (computerNum.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computerNum.contains(randomNumber)) {
                    computerNum.add(randomNumber);
                    computerNumCheck[randomNumber] = 1;
                }
            }
            return computerNum;
        }
        public List<Integer> toInputNum(){}
        public int strike(){}
        public int ball(){}
        public boolean resultPrint(){}
    }

    public static void main(String[] args) {

    }
}
