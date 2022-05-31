package CRUD.myfirst.interceptor;

import CRUD.myfirst.config.SessionConst;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckInterceptor implements HandlerInterceptor {
    // 로그인 인터셉터임

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        HttpSession session=request.getSession();

        if(session==null||session.getAttribute(SessionConst.LOGIN_MEMBER)==null){

            response.sendRedirect("/login?redirectURL"+requestURI);
            return false;
        }

        return true;
    }
}
