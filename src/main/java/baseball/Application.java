package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int answer = answerNum();
        boolean result = false;
        while (!result) {
            int input = inputNumber();
            result = compareNum(answer, input);

        }

    }
    // 서로 다른 임의의 수 3개 선택
    public static int answerNum(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<String> ansL = new ArrayList<>();

        int count=0;
        while(count!=3){
            int randpick = Randoms.pickNumberInRange(1,9);
            if(!ansL.contains(String.valueOf(randpick))) {
                ansL.add(String.valueOf(randpick));
                count++;
            }
        }
        String str = "";
        for(int i=0;i<ansL.size();i++){
            str += ansL.get(i);
        }
        int answer = Integer.parseInt(str);
        return answer;
    }
    public static int inputNumber() throws NullPointerException {
        System.out.print("숫자를 입력해주세요 : ");
        int input = 0;

        try{
            input = Integer.parseInt(Console.readLine());
            String str = String.valueOf(input);
            if(input<100 || input>999){
                throw new IllegalArgumentException();
            }
        }
        catch (NullPointerException e){

        }
        return input;

    }
    public static boolean compareNum(int ans, int input){
        String result="";
        boolean pass = false;
        int ball=0,strike=0;

        List<Character> ansList = new ArrayList<>();
        List<Character> inputList = new ArrayList<>();
        for(int i=0;i<3;i++){
            inputList.add(String.valueOf(input).charAt(i));
            ansList.add(String.valueOf(ans).charAt(i));
        }
        String str="";
        for(int i=0;i<ansList.size();i++){
            for(int j=0;j<inputList.size();j++){
                str += compare(inputList,ansList,i,j);
            }
        }
        StringTokenizer stz = new StringTokenizer(str, " ");
        while(stz.hasMoreTokens()){
            String token = stz.nextToken();
            if(token.equals("10")){
                strike++;
            }
            if(token.equals("01")){
                ball++;
            }
        }
        if(ball!=0){
            result+= ball+"볼 ";
        }
        if(strike!=0){
            result += strike+"스트라이크";
        }

        if(strike==3){
            result += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
            pass = true;
        }
        if(ball == 0 && strike ==0){
            result = "낫싱";
        }
        System.out.println(result);

        return pass;
    }

    // 스트라이크와 볼을 판별하는 함수
    public static String compare(List<Character> list1, List<Character> list2, int i, int j ){
        String str = "";
        if(Objects.equals(list1.get(i), list2.get(j))){
            if(i==j){
                str += "10 ";
            }
            else{
                str += "01 ";
            }
        }
        return str;
    }

}
