package baseball.mvc.structure;

import java.util.Map;

public interface Adapter {

    boolean supports(Object handler);

    ModelAndView handle(Object handler, Map<String, Object> request);
}
