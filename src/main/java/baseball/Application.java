package baseball;

import java.util.List;

public class Application {
	private static List<Integer> select_Random_Number(){
		
	}
    private static void start_new_Baseball_Game() {
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	List<Integer> computer_num = select_Random_Number();
    }
	public static void main(String[] args) {
        start_new_Baseball_Game();
    }
}
