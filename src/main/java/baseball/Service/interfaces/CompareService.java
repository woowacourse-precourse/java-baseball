package baseball.Service.interfaces;

import baseball.Model.NumberItem;

import java.util.List;

public interface CompareService {

    int compare(NumberItem computerNumberItem, NumberItem userNumberItem);
}
