package baseball.mvc.structure;

public interface Adapter {

    boolean supports(Object handler);

    ModelAndView handle(Object handler, Request request);
}
