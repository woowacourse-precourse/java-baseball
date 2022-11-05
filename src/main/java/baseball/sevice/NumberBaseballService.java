package baseball.sevice;

import baseball.repository.NumberBaseballRepository;

public class NumberBaseballService {

    private NumberBaseballRepository numberBaseballRepository = NumberBaseballRepository.getInstance();


    public void initNumber() {
        numberBaseballRepository.generateComputerNumber();
    }
}
