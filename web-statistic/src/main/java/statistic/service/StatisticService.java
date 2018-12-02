package statistic.service;

import java.util.List;

import statistic.domain.Statistic;
import statistic.domain.StatisticPeriod;

public interface StatisticService {
	public void createStatisticEntry(Statistic statistic);
	public List<StatisticReportTemplate> getCurrentDateStatistic();
	public List<StatisticReportTemplate> getPeriodStatistic(StatisticPeriod period);
}
