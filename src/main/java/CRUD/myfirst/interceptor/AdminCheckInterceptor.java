package CRUD.myfirst.interceptor;

import CRUD.myfirst.config.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class AdminCheckInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        HttpSession session=request.getSession();

        if(session==null||session.getAttribute(SessionConst.ADMIN_MEMBER)==null){
            log.info("dlqslek!!!!"+requestURI);
            response.sendRedirect("/login?redirectURL"+requestURI);
            return false;
        }
        return true;
    }
}
