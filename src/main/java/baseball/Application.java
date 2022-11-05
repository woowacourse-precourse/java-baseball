package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {

    // 2번 랜덤으로 computer에서 제공하는 정답을 얻어내는 메소드
    public static String baseball_random() {

        String baseball = "";

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        for (int i : computer){
            baseball += Integer.toString(i);}

        return baseball;
    }

    // 3번 사용자의 input를 받는 메소드
    public static String baseball_input() {
        System.out.print("숫자를 입력해주세요 : ");

        String user_input = Console.readLine();
        List<String> overlap_check = Arrays.asList(user_input.split(""));
        try{
            int error_check = Integer.parseInt(user_input);
            if (!(error_check > 111 && error_check < 999)){
                throw new IllegalArgumentException();
            }

            int not_overlap_first = Collections.frequency(overlap_check, overlap_check.get(0));
            int not_overlap_second = Collections.frequency(overlap_check, overlap_check.get(1));
            int not_overlap_third = Collections.frequency(overlap_check, overlap_check.get(2));

            if (not_overlap_first > 1 || not_overlap_second > 1 || not_overlap_third > 1){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e){
            String error = "error";
            return error;
        }

        return user_input;
    }



    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
