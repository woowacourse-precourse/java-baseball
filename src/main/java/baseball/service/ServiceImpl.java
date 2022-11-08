package baseball.service;
import baseball.utils.ChangeToChar;
import baseball.utils.GetInput;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
public class ServiceImpl implements Service {
    GetInput getInput = new GetInput();
    ChangeToChar changeToChar = new ChangeToChar();
    public ServiceImpl() {
    }
    @Override
    public void readyGame() throws IllegalArgumentException{
        int strike = 0;
        char[] number = changeToChar.changetoChar(randNumGenerate(1, 9));
        while(strike != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            int inputNumber = getInput.getInput();
            errorCheck(inputNumber);
            char[] input = changeToChar.changetoChar(inputNumber);
            int[] count = baseBall(number,input);
            strike = count[0];
            printBaseBallCount(count);
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
        List<Integer> numList = new ArrayList<>();
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
    @Override
    public void printBaseBallCount(int[] count) {
        if (count[0] == 3) {
            System.out.println("3스트라이크");
        } else if (count[0] == 0 && count[1] == 0) {
            System.out.println("낫싱");
        } else if (count[0] != 0 && count[1] != 0) {
            System.out.println(count[1] + "볼 " + count[0] + "스트라이크");
        } else if (count[0] != 0 && count[1] == 0) {
            System.out.println(count[0] + "스트라이크");
        } else if (count[0] == 0 && count[1] != 0) {
            System.out.println(count[1] + "볼");
        }
    }
    @Override
    public void errorCheck(int number) throws IllegalArgumentException{
        if (number< 123) throw new IllegalArgumentException();
        List<Integer> numList = new ArrayList<>();
        int digit = 100;
        for(int i =0; i< 3; i++) {
            if (numList.contains(number)==true){
                throw new IllegalArgumentException();
            }
            numList.add(number%10);
            number = number/10;
        }
    }
}
