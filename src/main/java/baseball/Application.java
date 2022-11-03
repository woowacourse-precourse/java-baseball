package baseball;

import java.util.LinkedList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
	private static List<Integer> select_Random_Number(){
		List<Integer> com_Random_Num = new LinkedList<>();
		while(com_Random_Num.size()<3){
			int now_num = pickNumberInRange(1,9);
			if(!com_Random_Num.contains(now_num)){
				com_Random_Num.add(now_num);
			}
		}
		return com_Random_Num;
	}
    private static void start_new_Baseball_Game() {
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	List<Integer> computer_num = select_Random_Number();
    }
	public static void main(String[] args) {
        start_new_Baseball_Game();
    }
}
