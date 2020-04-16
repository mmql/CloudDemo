package com.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class ResultFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(ResultFilter.class);

    @Override
    public String filterType() {
        //类型为post,后置
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        //HttpServletResponse response = ctx.getResponse();

        log.info("进入结果处理的过滤器！");

        log.info("===============");

        return null;
    }

}
