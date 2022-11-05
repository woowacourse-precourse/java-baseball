package baseball.repository;

import baseball.domain.ComputerNumber;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseBallRepository {
    private static final NumberBaseBallRepository instance = new NumberBaseBallRepository();
    private static final List<ComputerNumber> numberStore = new ArrayList<>();
}
