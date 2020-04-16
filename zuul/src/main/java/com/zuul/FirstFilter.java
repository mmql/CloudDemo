package com.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

public class FirstFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(FirstFilter.class);

    @Override
    public String filterType() {
        // 类型为pre,前置
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 无条件执行
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        // 实现自己需要的过滤逻辑
        log.info("第一级过滤器！");

        log.info("===============");

        return null;
    }

}
