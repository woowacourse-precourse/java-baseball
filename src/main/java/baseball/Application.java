package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import java.util.stream.Stream;

public class Application {


    public static void game(){

        int value;
        String str = "";
        Random random = new Random();
        //서로 다른 수 세자리 만들기
        while (true) {
            if (str.length() == 3) {
                break;
            }
            //요구사항에 맞게 수정
            value = Randoms.pickNumberInRange(1, 9);

            if (!str.contains(Integer.toString(value))) {

                str += value;

            }
        }
        int num = 0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (str != Integer.toString(num)) {


            int strike = 0;
            int ball = 0;

            System.out.print("숫자를 입력해주세요 : ");

            try{ num = Integer.parseInt(Console.readLine());}
            catch (InputMismatchException ime){
                throw new IllegalArgumentException();
            }
            //동일한 경우 게임 종료
            if (Integer.parseInt(str) == num) {

                break;

            }
            //서로다른 숫자 3숫자 입력이 아닐시 예외처리
            if(Integer.toString(num).length()!=3){
                throw new IllegalArgumentException();

            }
            int[] digits = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
            List<Integer> intList = new ArrayList<>();
            for (int element : digits) {
                intList.add(element);
            }
            Set<Integer> set = new HashSet<Integer>(intList);

            if(set.size()!=intList.size()){
                throw new IllegalArgumentException();
            }


            String num_str = Integer.toString(num);

            for (int i = 0; i < 3; i++) {
                if (num_str.charAt(i) == str.charAt(i)) {
                    strike += 1;
                    continue;
                }
                if (str.contains(String.valueOf(num_str.charAt(i)))) {

                    ball += 1;
                }
            }
            if(ball==0 && strike==0){
                System.out.println("낫싱");
                continue;
            }
            String answer="";
            String ball2= (ball==0) ? "": ball+"볼"+" ";
            answer+=ball2;
            String strike2= (strike==0) ? "": strike+"스트라이크";
            answer+=strike2;
            System.out.println(answer);



        }



    }
    public static void main(String[] args) {
        //컴퓨터 숫자 선언

        int num2=1;


        while(true){

            game();

            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            try {
                num2 = Integer.parseInt(Console.readLine());
            }
            catch (NoSuchElementException e){
                continue;
            }

            if(num2==1){

            }
            else if (num2==2){
                break;
            }
            else{
                throw new IllegalArgumentException();
            }

        }




        }


    }


