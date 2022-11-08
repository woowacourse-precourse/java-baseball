package baseball;

import java.util.ArrayList;

public class Inspector {
    int ball;
    int strike;
    String result = "";

    public ArrayList<Integer> insert_list(int ans, ArrayList<Integer> list){ //문자를 ArrayList에 넣는 메소드
        String str = String.valueOf(ans);
        for(int i=0; i<str.length(); i++){
            String num = str.substring(i, i+1);
            list.add(Integer.parseInt(num));
        }
        return list;
    }

    public String check(int correct_answer, String response){ //사용자의 답을 체크하는 기능
        int answer = Integer.parseInt(response);
        ArrayList<Integer> computer_list = new ArrayList<>();
        ArrayList<Integer> user_list = new ArrayList<>();
        ball = 0; strike = 0; result = "";

        if(correct_answer == answer) {
            result = "3스트라이크";
            return result;
        }

        insert_list(correct_answer, computer_list);
        insert_list(answer, user_list);

        for(int a:computer_list) {
            if(user_list.contains(a)) {
                ball++;
            }
            if(user_list.indexOf(a) == computer_list.indexOf(a)) {
                ball--;
                strike++;
            }
        }

        if(ball>0 && strike==0)
            result = (ball + "볼 ");
        if(ball==0 && strike>0)
            result = (strike + "스트라이크 ");
        if(ball>0 && strike>0)
            result = (ball + "볼 " + strike + "스트라이크");
        if(ball==0 && strike==0)
            result = "낫싱";

        return result;
    }
}
