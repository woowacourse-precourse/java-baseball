package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import net.bytebuddy.asm.Advice.Exit;

public class Application {	
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.gameStart(controller.getComputerNumbers());	
	}
}