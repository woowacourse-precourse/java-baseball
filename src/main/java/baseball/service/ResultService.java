package baseball.service;

import java.util.List;

import baseball.respository.AnswerRepository;

public class ResultService {
    private static ResultService instance;
    private static AnswerRepository answerRepository;

    private ResultService() {
    }

    public static ResultService getInstance() {
        if (instance == null) {
            instance = new ResultService();
            answerRepository = AnswerRepository.getInstance();
        }
        return instance;
    }

    public int[] calculateResult(String guessAnswer) {
        List<Integer> correctAnswer = answerRepository.getCorrectAnswer();
        int strike = 0;
        int ball = 0;
        for (int idx = 0; idx < correctAnswer.size(); idx++) {
            Integer correctNumber = correctAnswer.get(idx);
            Integer guessNumber = guessAnswer.charAt(idx) - '0';
            if (correctNumber.equals(guessNumber)) {
                strike++;
                continue;
            }
            if (correctAnswer.contains(guessNumber)) {
                ball++;
            }
        }
        return new int[]{strike, ball};
    }
}
