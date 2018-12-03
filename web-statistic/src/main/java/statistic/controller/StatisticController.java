package statistic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import statistic.domain.Statistic;
import statistic.domain.StatisticPeriod;
import statistic.service.StatisticReportTemplate;
import statistic.service.StatisticService;

@RestController
public class StatisticController {
	private final StatisticService statisticService;
	@Autowired
	public StatisticController(StatisticService statisticService) {
		this.statisticService = statisticService;
	}
	@RequestMapping(value="/save",method = RequestMethod.POST,consumes=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<StatisticReportTemplate> create(@RequestBody Statistic entry){
		statisticService.createStatisticEntry(entry);
		return statisticService.getCurrentDateStatistic();
	}
	
	@RequestMapping(value="/statistic", method=RequestMethod.POST, consumes=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<StatisticReportTemplate> getStatistic(@RequestBody StatisticPeriod period){
		return statisticService.getPeriodStatistic(period);
	}
}
