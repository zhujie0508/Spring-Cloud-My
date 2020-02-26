package cn.cib.configuration.controller;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author lianjie Zhu
 * @Date 2020/2/24 14:19
 * @Version 1.0
 *      网关统一拦截器  对所有 url 请求进行拦截
 */
@Component
@Slf4j(topic = "MyFilter-->网关过滤器-->")
public class MyFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
//        对登录接口不进行拦截
        if("http://localhost:8009/admin/myAdminLogin/v1/adminLogin".equals(request.getRequestURL().toString())){
            return false;
        }
        return true ;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        String tocken = request.getHeader("token");
        if (tocken==null||tocken.isEmpty()){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("token is null，please add tocken !");
            log.error("token验证失败");
        }else {
            log.info("token验证通过");

        }
        return null;

    }
}
