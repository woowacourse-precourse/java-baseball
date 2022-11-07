package custom.controller;

import custom.dto.Response;
import custom.service.BaseBallService;
import custom.service.vo.ReTry;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseBallController {

    private final BaseBallService baseBallService;

    public BaseBallController(BaseBallService baseBallService) {
        this.baseBallService = baseBallService;
    }

    public Response init() {
        return baseBallService.init();
    }

    public Response matchNumber(String input) {
        validateNumberFormat(input);
        validateDuplicateNumber(input);
        return baseBallService.matchNumber(input);
    }

    public Response isKeepGo(String input) {
        ReTry reTry = ReTry.nameOf(input);
        return baseBallService.isKeepGo(reTry);
    }


    private void validateNumberFormat(String input) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("^\\d{3}$");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("숫자 형태의 3글자 입력만 가능합니다");
        }
    }

    private void validateDuplicateNumber(String input)  {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < input.length(); ++i) {
            if (list.contains(input.charAt(i))) {
                throw new IllegalArgumentException("중복된 숫자는 입력이 불가능합니다");
            }
            list.add(input.charAt(i));
        }
    }
}
