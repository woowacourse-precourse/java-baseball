package baseball;

import java.util.ArrayList;

public class Inspector {
    int ball=0;
    int strike=0;
    String result="";

    public ArrayList<Integer> insert_list(int ans, ArrayList<Integer> list){ //문자를 ArrayList에 넣는 메소드
        String str = String.valueOf(ans);
        for(int i=0; i<str.length(); i++){
            String num = str.substring(i, i+1);
            list.add(Integer.parseInt(num));
        }
        return list;
    }

    public String check(int correct_answer, int answer){ //사용자의 답을 체크하는 기능
        ArrayList<Integer> computer_list = new ArrayList<>();
        ArrayList<Integer> user_list = new ArrayList<>();

        if(correct_answer == answer) {
            result = "3스트라이크";
            return result;
        }

        insert_list(correct_answer, computer_list);
        insert_list(answer, user_list);

        for(int a:computer_list) {
            if(user_list.contains(a)){
                ball++;
            }else{
                result = "낫싱";
                return result;
            }

            if(user_list.indexOf(a) == computer_list.indexOf(a)) {
                ball--;
                strike++;
            }
        }

        if(ball>0)
            result += (ball + "볼 ");
        if(strike>0)
            result += (strike + "스트라이크 ");
        return result;

    }
}
