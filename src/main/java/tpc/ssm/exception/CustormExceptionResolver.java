package tpc.ssm.exception;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustormExceptionResolver implements HandlerExceptionResolver {
    @Nullable
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @Nullable Object o, Exception ex) {
        //异常处理逻辑
        String message;
        if (ex instanceof CustormException) {
            message = ((CustormException) ex).getMsg();
        } else {
            message = "未知错误";
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("message",message);
        return mv;
    }
}
