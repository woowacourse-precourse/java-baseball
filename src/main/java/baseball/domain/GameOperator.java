package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import baseball.constants.ComparingResults;
import baseball.constants.GuideSentences;
import camp.nextstep.edu.missionutils.Console;

public class GameOperator {
	private QuestionNumberSetter questionNumberSetter;
	private Map<ComparingResults, Integer> resultMap = new HashMap<>();
	private final String threeStrike = "3스트라이크";
	private String resultString = "";

	public GameOperator() {
		questionNumberSetter = new QuestionNumberSetter();
	}

	public void numberBaseballGame() {
		System.out.println(GuideSentences.START_GUIDE.getSentence());
		while (true) {
			questionNumberSetter.pickThreeRandomNumbers();

			while (!resultString.equals(threeStrike)) {
				System.out.print(GuideSentences.INPUT_GUIDE.getSentence());

				List<Integer> inputNumbers = new ArrayList<>();


				String input = Console.readLine();
				Arrays.stream(input.split(""))
						.map(Integer::parseInt)
						.forEach(inputNumbers::add);

				resultMap =	questionNumberSetter.compareWithRandomNumbers(inputNumbers);

				List<String> resultList = new ArrayList<>();

				if (resultMap.containsKey(ComparingResults.NOTHING)) {
					String nothingSentence = ComparingResults.NOTHING.getResult();

					resultList.add(nothingSentence);
				} else {
					if (resultMap.containsKey(ComparingResults.BALL)) {
						String ballSentence = resultMap.get(ComparingResults.BALL).toString() +
								ComparingResults.BALL.getResult();

						resultList.add(ballSentence);
					}

					if (resultMap.containsKey(ComparingResults.STRIKE)) {
						String strikeSentence = resultMap.get(ComparingResults.STRIKE).toString() +
								ComparingResults.STRIKE.getResult();

						resultList.add(strikeSentence);
					}
				}

				resultString = String.join(" ", resultList);

				System.out.println(resultString);
				resultMap.clear();
			}

			System.out.println(GuideSentences.END_GUIDE.getSentence());
			System.out.println(GuideSentences.RESTART_GUIDE.getSentence());

			String restartInput = Console.readLine();

			if (restartInput.equals("1")) {
				resultString = "";
			} else if (restartInput.equals("2")) {
				break;
			}
		}
	}
}
