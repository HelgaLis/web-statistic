package statistic.dao;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import statistic.domain.Statistic;
import statistic.domain.StatisticPeriod;

public interface StatisticDao {
	public void createStatisticEntry(Statistic statistic);
	public long getGurrentDayVisitorsAmount();
	public long getCurrentDayUniqVisitorsAmount();
	public long getPeriodVisitorsAmount(StatisticPeriod period);
	public long getPeriodUniqVisitorsAmount(StatisticPeriod period);
	public long getPeriodRegularVisitorsAmount(StatisticPeriod period);
}
