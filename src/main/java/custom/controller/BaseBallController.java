package custom.controller;

import custom.dto.Response;
import custom.service.BaseBallService;
import custom.service.vo.ReTry;
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
        validateNumber(input);
        return baseBallService.matchNumber(input);
    }

    public Response isKeepGo(String input) {
        ReTry reTry = ReTry.nameOf(input);
        return baseBallService.isKeepGo(reTry);
    }


    private void validateNumber(String input) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("^\\d{3}$");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("숫자 형태의 3글자 입력만 가능합니다");
        }
    }
}
