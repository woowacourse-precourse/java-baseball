package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
            if(!filterUserNumbers.contains(userNumber) && numberInRange(userNumber, 1, 9)){
                filterUserNumbers.add(userNumber);
            }
        }

        return filterUserNumbers.size() == 3;
    }

    public static boolean numberInRange(Integer number, Integer startPoint, Integer endPoint){
        return startPoint <= number && number <= endPoint;
    }

    public static List<Integer> compare(List<Integer> computers, List<Integer> users){
        int ball = 0;
        int strike = 0;
        int nothing = 0;

        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i<computers.size(); i++){
            if(computers.get(i) == users.get(i)){
                strike++;
            }else if(users.contains(computers.get(i))){
                ball++;
            }else {
                nothing++;
            }
        }

        answer.add(ball);
        answer.add(strike);
        answer.add(nothing);

        return answer;
    }

    public static String getAnswer(List<Integer> compareList){
        List<String> hint = new ArrayList<>();
        hint.add("볼");
        hint.add("스트라이크");
        hint.add("낫싱");
        hint.add("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        StringBuilder answer = new StringBuilder();

        if(compareList.get(2) == 3){
            return hint.get(2);
        }

        if(compareList.get(1) == 3){
            answer.append(compareList.get(1).toString()).append(hint.get(1)).append(hint.get(3));
            return answer.toString();
        }

        for(int i = 0; i < compareList.size()-1; i++){
            if(compareList.get(i) > 0){
                answer.append(compareList.get(i).toString()).append(hint.get(i));
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        args = Console.readLine().split("");
        List<Integer> computer_numbers = getComputerNumbers();
        List<Integer> user_numbers = Arrays.stream(args).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        if(isException(user_numbers)){
            List<Integer> compare_list = compare(computer_numbers, user_numbers);
            getAnswer(compare_list);
        }

    }
}
