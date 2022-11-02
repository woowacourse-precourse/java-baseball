package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> computerNumber = computerRanmdomNumberExtract();

        String userNumber = Console.readLine();

        isInputAlright(userNumber);
        List<Integer> userNumberList = inputProcess(userNumber);


    }





    public static List<Integer> inputProcess(String userNumber) {
        return convertStringToIntegerList(userNumber);
    }

    public static List<Integer> convertStringToIntegerList(String userNumber) {
        List<Integer> userNumberList = new ArrayList<>();
        for(int i=0; i<3; i++){
            int putNumber = Character.getNumericValue(userNumber.charAt(i));
            userNumberList.add(putNumber);
        }
        return userNumberList;
    }

    public static List<Integer> computerRanmdomNumberExtract() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void isInputAlright(String user1) {
        if(user1.length()!=3){
            throw new IllegalArgumentException("입력 오류");
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                inputOverlapCheck(user1, i, j);
            }
        }
    }

    public static void inputOverlapCheck(String user1, int i, int j) {
        if(i == j){
            return;
        }
        if(user1.charAt(j) == user1.charAt(i))
        {
            throw new IllegalArgumentException("입력 숫자중 중복");
        }
    }
}
