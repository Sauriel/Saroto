package de.sauriel.nexus.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import de.sauriel.nexus.service.GlobalModelAttributes;

public class GlobalAttributeHandlerInterceptor extends HandlerInterceptorAdapter {

	private GlobalModelAttributes attributes;

	@Autowired
	private GlobalAttributeHandlerInterceptor(GlobalModelAttributes attributes) {
		this.attributes = attributes;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView == null) {
			return;
		}

		boolean isRedirectView = modelAndView.getView() instanceof RedirectView;
		boolean isViewObject = modelAndView.getView() != null;
		boolean viewNameStartsWithRedirect = (modelAndView.getViewName() == null ? true
				: modelAndView.getViewName().startsWith(UrlBasedViewResolver.REDIRECT_URL_PREFIX));

		if (modelAndView.hasView()
				&& ((isViewObject && !isRedirectView) || (!isViewObject && !viewNameStartsWithRedirect))) {
			addGlobalAttributes(modelAndView);
		}
	}

	private void addGlobalAttributes(ModelAndView modelAndView) {
		modelAndView.getModel().putAll(attributes.getAttributes());
	}

}
