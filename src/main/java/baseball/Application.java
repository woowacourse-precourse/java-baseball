package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<Integer> getComputerNumbers(){
        List<Integer> computer_numbers = new ArrayList<>();

        while(computer_numbers.size() < 3){
            int random_number = Randoms.pickNumberInRange(1, 9);

            if(!computer_numbers.contains(random_number)){
                computer_numbers.add(random_number);
            }
        }

        return computer_numbers;
    }

    public static boolean isException(List<Integer> userNumbers){
        List<Integer> filterUserNumbers = new ArrayList<>();

        // userNumbers 필터링: 겹치지 않는 다면 필터링리스트에 추가.
        for(int userNumber: userNumbers){
            if(!filterUserNumbers.contains(userNumber)){
                filterUserNumbers.add(userNumber);
            }
        }

        return filterUserNumbers.size() == 3;
    }

    public static boolean numberInRange(Integer number, Integer startPoint, Integer endPoint){
        return startPoint <= number && number <= endPoint;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
