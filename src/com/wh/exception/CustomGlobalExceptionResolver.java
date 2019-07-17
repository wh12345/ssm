package com.wh.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomGlobalExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
	                    Exception exception) {
		String msg = "";
		if(exception instanceof CustomException) {
			msg = ((CustomException)exception).getMessage();
		}else {
			msg="系统异常,请联系管理员老王";
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", msg);
		mv.setViewName("error");
		return mv;
	}

}
