package baseball.mvc.structure;

import baseball.mvc.model.Request;

public interface Adapter {

    boolean supports(Object handler);

    ModelAndView handle(Object handler, Request request);
}
