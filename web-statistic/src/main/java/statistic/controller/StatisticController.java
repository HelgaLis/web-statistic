package statistic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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
	@Async
	@RequestMapping(value="save",method = RequestMethod.POST)
	public List<StatisticReportTemplate> create(@RequestBody Statistic entry){
		statisticService.createStatisticEntry(entry);
		return statisticService.getCurrentDateStatistic();
	}
	
	@RequestMapping(value="/statistic",method = RequestMethod.POST)
	public List<StatisticReportTemplate> getStatistic(@RequestBody StatisticPeriod period){
		return statisticService.getPeriodStatistic(period);
	}
	//@RequestMapping(value="/page/{id}")
	//public void anyPage(@PathVariable("id") int id) {
	//	
	//}
}
