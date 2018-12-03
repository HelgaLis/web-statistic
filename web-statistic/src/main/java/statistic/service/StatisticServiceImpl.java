package statistic.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import statistic.dao.StatisticDao;
import statistic.domain.Statistic;
import statistic.domain.StatisticPeriod;
@Transactional
//@Service
public class StatisticServiceImpl implements StatisticService {

	private final StatisticDao dao;
	@Autowired
	public StatisticServiceImpl(StatisticDao dao) {
		this.dao=dao;
	}
	@Override
	public void createStatisticEntry(Statistic statistic) {
		dao.createStatisticEntry(statistic);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<StatisticReportTemplate> getCurrentDateStatistic() {
		List<StatisticReportTemplate> template = new ArrayList<>();
		template.add(new StatisticReportTemplate("Общее количество посещений за текущие сутки", dao.getGurrentDayVisitorsAmount()));
		template.add(new StatisticReportTemplate("Количество уникальных пользователей за текущие сутки", dao.getCurrentDayUniqVisitorsAmount()));
		return template;
	}

	@Override
	@Transactional(readOnly=true)
	public List<StatisticReportTemplate> getPeriodStatistic(StatisticPeriod period) {
		List<StatisticReportTemplate> template = new ArrayList<>();
		template.add(new StatisticReportTemplate(String.format("Общее количество посещений за период %s",period), dao.getGurrentDayVisitorsAmount()));
		template.add(new StatisticReportTemplate(String.format("Количество уникальных пользователей за период %s",period), dao.getGurrentDayVisitorsAmount()));
		template.add(new StatisticReportTemplate(String.format("Количество постоянных пользователей  за период %s",period), dao.getGurrentDayVisitorsAmount()));
		return template;
	}

}
