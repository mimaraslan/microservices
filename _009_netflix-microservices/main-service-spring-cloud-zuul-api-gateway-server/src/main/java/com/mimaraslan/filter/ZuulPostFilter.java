package com.mimaraslan.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulPostFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext requestContext = RequestContext.getCurrentContext();
		System.out.println("FilterConstants.SEND_RESPONSE_FILTER_ORDER ---- " + FilterConstants.SEND_RESPONSE_FILTER_ORDER);
		System.out.println("FilterConstants.SEND_FORWARD_FILTER_ORDER ---- " + FilterConstants.SEND_FORWARD_FILTER_ORDER);
		System.out.println("FilterConstants.SEND_ERROR_FILTER_ORDER ---- " + FilterConstants.SEND_ERROR_FILTER_ORDER);
		System.out.println("FilterConstants.PRE_DECORATION_FILTER_ORDER ---- " + FilterConstants.PRE_DECORATION_FILTER_ORDER);
		HttpServletRequest httpServletRequest = requestContext.getRequest();
		return null;
	}
}
