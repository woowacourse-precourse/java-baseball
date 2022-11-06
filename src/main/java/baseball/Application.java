package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> disassembleDigitNumber(int number){
        List<Integer> disassembledNumber = new ArrayList<Integer>();
        for(int digit = 1; number > 0; number/=10, digit *= 10){
            int digitNum = number % 10;
            disassembledNumber.add(digitNum * digit);
        }

        return disassembledNumber;
    }

    public static int getRandomThreeDigitNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        int randomValue = 0;
        for(int i = 0, digit = 1; digit <= 100; i++, digit *= 10){
            randomValue += computer.get(i) * digit;
        }
        return randomValue;
    }
}
