package top.moyel.mayo.config;

import cn.hutool.json.JSONUtil;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.moyel.mayo.utils.RequestUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author moyel
 */
@Slf4j
@Component
public class MayoRecordInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        log.info("请求地址：{}\t请求客户端IP：{}\t{}", request.getRequestURL(), RequestUtil.getRequestIp(request), getHandleMethodMessage(request, handler));
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    public String getHandleMethodMessage(HttpServletRequest request, Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return null;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        return String.format("请求方法声明：%s，请求参数：%s", handlerMethod.getMethod().toGenericString(), JSONUtil.toJsonStr(request.getParameterMap()));
    }
}
