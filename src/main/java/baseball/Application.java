package baseball;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static List<Integer> set_computer(){
        List<Integer> computer=new ArrayList<>();
        while(computer.size()<3){
            int randomNumber= Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    static boolean overlap_number(String user){
        char first_num=user.charAt(0);
        char second_num=user.charAt(1);
        char third_num=user.charAt(2);

        if(first_num==second_num||first_num==third_num||second_num==third_num){
            return true;
        }
        else {
            return false;
        }
    }
    static void exception_check(String user){
        if(user.length()!=3||overlap_number(user)){
            IllegalArgumentException e=new IllegalArgumentException("입력 오류");
            throw e;
        }
    }
    static int[] user_check(String user,List<Integer> computer){
        int [] answer=new int[2]; //[0]:strike,[1]:ball

        for(int idx=0;idx<3;idx++){
            int user_at=user.charAt(idx)-'0';
            if(user_at==computer.get(idx)) {
                answer[0]++;
            }
            else if(computer.contains(user_at)){
                answer[1]++;
            }
        }
        return answer;
    }
    static boolean print_problem(int []answer){
        StringBuilder print=new StringBuilder();

        if(answer[1]>0){
            print.append(answer[1]+"볼 ");
        }
        if(answer[0]>0){
            print.append(answer[0]+"스트라이크 ");
        }
        if(print.length()==0){
            print.append("낫싱");
        }

        System.out.println(print);

        if(answer[0]==3) {
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            List<Integer> computer = set_computer();
            boolean problem_correct=false;

            while(!problem_correct){
                System.out.print("숫자를 입력해주세요 : ");
                String user=Console.readLine();

                exception_check(user);

                int[] answer=new int[2];
                answer=user_check(user,computer);
                problem_correct=print_problem(answer);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String restart=Console.readLine();

            if(restart.equals("2")){
                break;
            }
            else if(!restart.equals("1")){
                IllegalArgumentException e=new IllegalArgumentException("재시작 입력 오류");
                throw e;
            }
        }

    }
}
