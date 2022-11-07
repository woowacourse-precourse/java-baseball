package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {/*
    static boolean overlap_number(String user){
        char first_num=user.charAt(0);
        char second_num=user.charAt(1);
        char third_num=user.charAt(2);

        if(first_num==second_num||first_num==third_num||second_num==third_num){
            return true;
        }
        return false;

    }
    static void exception_check(String user){
        if(user.length()!=3||overlap_number(user)){
            IllegalArgumentException e=new IllegalArgumentException("입력 오류");
            throw e;
        }
    }
    static int[] user_check(User user,Computer computer){
        int [] answer=new int[2]; //[0]:strike,[1]:ball

        for(int idx=0;idx<3;idx++){
            int user_at=user.value.charAt(idx)-'0';
            if(user_at==computer.computer.get(idx)) {
                answer[0]++;
            }
            else if(computer.computer.contains(user_at)){
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
    }*/
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        GameChecker checker=new GameChecker();
        do {
            checker.startGame();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            checker.askContinue();
        }while(checker.restartGame);
/*
        while(true) {
            Computer com=new Computer();
            boolean problem_correct=false;

            while(!problem_correct){
                int[] answer=new int[2];
                User user=new User();

                answer=user_check(user,com);
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

 */

    }
}
