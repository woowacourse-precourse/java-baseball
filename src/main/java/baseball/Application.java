package baseball;
import camp.nextstep.edu.missionutils.*;
import java.util.*;




public class Application {
    public static void main(String[] args) {
    }

     static ArrayList<Integer> randomComputer(ArrayList<Integer> computer){
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        } return computer;
    }

    static ArrayList<Integer> convertStringToInt(String user){
        ArrayList<Integer> intAnswer = new ArrayList<>();
        String[] splitNumber = user.split("");
        for ( String number : splitNumber ) {
            intAnswer.add(Integer.parseInt(number));
        }
        return intAnswer;
    }
}
