package baseball;

public class Game {
	
	private static Status status;
	private static Result result;
	private static Computer computer;
		    
	final static String START_MSG = "Start baseball game!";
	final static String INPUT_MSG = "enter 3 digit number";
	final static String MATCH_MSG = "correct!";
	final static String END_MSG = "end the game";
	
	
	private Game() {}
	
	
	public static void start() {
		
	    status = Status.PROCEEDING;
	    
		try {
            // Game loop
            while (status != Status.EXIT) {
                
            	//init
                initialize();

                // 3. Computer와 User 정보를 이용해 Result가 THREESTRIKE가 아닐 동안 게임 진행
                proceedGame();

                System.out.println(MATCH_MSG);

                // 4. 사용자 입력에 따라 게임 재개 혹은 종료를 위한 Status 변경
                changeStatus(User.getGameOption());
            }
            
            //condition 1
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            throw new IllegalArgumentException();
        }
		
		//EXIT
        System.out.println(END_MSG);
 
	}
	
	//init
	private static void initialize() {
        computer = new Computer();
        result = Result.NOTHING;
    }
	
	private static void proceedGame() {
        while (result != Result.THREESTRIKE) {
            result = Result.getResult(
                    Calculator.calculateScore(computer, User.getGameNumber())
            );
            System.out.println(result.getMessage());
        }
    }
	
	//create random number
	public static void generate_random{
		 
	}
	
	private static void changeStatus(int gameOption) {
        status = Status.getStatus(gameOption);
    }
}
