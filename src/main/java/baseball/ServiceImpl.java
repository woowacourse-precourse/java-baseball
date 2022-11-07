
package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Service {
    GetInput getInput = new GetInput();
    ChangeToChar changeToChar = new ChangeToChar();
    public ServiceImpl() {
    }
    @Override
    public void readyGame() {
        int strike = 0;
        char[] number = changeToChar.changetoChar(randNumGenerate(1, 9));

        while(strike != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            char[] input = changeToChar.changetoChar(getInput.getInput());
            int[] count = baseBall(number,input);
            strike = count[0];
        }
    }
    @Override
    public int[] baseBall(char[] number, char[] input) {
        int[] count = new int[]{0, 0};

        for(int i = 0; i < 3; ++i) {
            check(number,input[i],i,count);
        }
        return count;
    }
    @Override
    public int randNumGenerate(int minNum, int maxNum) {
        int number = 0;
        List<Integer> numList = new ArrayList();
        int digit = 100;

        do {
            int tempnumber;
            do {
                tempnumber = Randoms.pickNumberInRange(minNum, maxNum);
            } while(numList.contains(tempnumber));

            numList.add(tempnumber);
            number += tempnumber * digit;
            digit /= 10;
        } while(digit != 0);

        return number;
    }
    @Override
    public void check(char[] number, char input, int cur, int[] count) {
        for(int i = 0; i < 3; ++i) {
            if (number[i] == input && i==cur) {
                count[0]++;
                return;
            }else if(number[i]==input){
                count[1]++;
                return;
            }
        }
    }
}
