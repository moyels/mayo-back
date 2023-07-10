package top.moyel.mayo.utils;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.StrUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author moyel
 */
public class RequestUtil {
    private static final String[] NGINX_PROXY_IP_HEADER_KEY = {"X-Forwarded-For", "X-Real-IP"};

    private static final Set<String> LOCAL_IPS = NetUtil.localIps();

    public static String getRequestIp(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        String headerIp = getFirstNotBlankIp(request);

        boolean isInnerRemoteAddr = LOCAL_IPS.contains(remoteAddr), isBlankHeaderIp = StrUtil.isBlank(headerIp);

        return isInnerRemoteAddr ? isBlankHeaderIp ? remoteAddr : headerIp : remoteAddr;
    }

    public static String getFirstNotBlankIp(HttpServletRequest request) {
        return getFirst(request, StrUtil::isNotBlank, Arrays.stream(NGINX_PROXY_IP_HEADER_KEY).map((Function<String, ItemGet<HttpServletRequest, String>>) s -> param -> request.getHeader(s)).collect(Collectors.toList()));
    }

    public static <E, IN> E getFirst(IN param, DetermineCondition<E> determineCondition, List<ItemGet<IN, E>> itemGetArgs) {
        for (ItemGet<IN, E> itemGetArg : itemGetArgs) {
            E elem = itemGetArg.get(param);
            if (determineCondition.determine(elem)) {
                return elem;
            }
        }

        return null;
    }

    public interface DetermineCondition<E> {
        boolean determine(E elem);
    }

    public interface ItemGet<IN, E> {
        E get(IN param);
    }
}
