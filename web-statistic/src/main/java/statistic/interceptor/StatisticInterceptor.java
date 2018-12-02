package statistic.interceptor;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import statistic.domain.Statistic;
import statistic.service.StatisticService;

public class StatisticInterceptor implements HandlerInterceptor {
	@Autowired
	private StatisticService service;



	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String pageId = request.getRequestURL().toString();
		String userId = request.getRequestedSessionId();
		Statistic statistic = new Statistic(userId, pageId, LocalDate.now());
		
		if (!pageId.contains("save") && !pageId.contains("statistic")) {
			service.createStatisticEntry(statistic);
			response.sendRedirect("/save");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String pageId = request.getRequestURL().toString();
		String userId = request.getRequestedSessionId();
		Statistic statistic = new Statistic(userId, pageId, LocalDate.now());
		
		if (!pageId.contains("save") && !pageId.contains("statistic")) {
			service.createStatisticEntry(statistic);
			response.sendRedirect("/save");
		}

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		String pageId = request.getRequestURL().toString();
		String userId = request.getRequestedSessionId();
		Statistic statistic = new Statistic(userId, pageId, LocalDate.now());
		
		if (!pageId.contains("save") && !pageId.contains("statistic")) {
			service.createStatisticEntry(statistic);
			response.sendRedirect("/save");
		}

	}

}
