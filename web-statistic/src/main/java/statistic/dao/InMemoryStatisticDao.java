package statistic.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import statistic.domain.Statistic;
import statistic.domain.StatisticPeriod;

public class InMemoryStatisticDao implements StatisticDao {
	private static final List<Statistic> statisticList = new ArrayList<>();

	@Override
	public void createStatisticEntry(Statistic statistic) {
		statisticList.add(statistic);
	}
	@Override
	public long getGurrentDayVisitorsAmount() {
		return statisticList.stream().map(Statistic::getVisitDate).filter(d->d==LocalDate.now()).count();
	}

	@Override
	public long getCurrentDayUniqVisitorsAmount() {
		return statisticList.stream().filter(s->s.getVisitDate()==LocalDate.now()).map(Statistic::getUserId).distinct().count();
	}
	@Override
	public long getPeriodVisitorsAmount(StatisticPeriod period) {
		return statisticList.stream().map(Statistic::getVisitDate)
				.filter(d->StatisticPeriod.isDateInPeriod.apply(d, period)).count();
	}

	@Override
	public long getPeriodUniqVisitorsAmount(StatisticPeriod period) {
		return statisticList.stream().filter(s->StatisticPeriod.isDateInPeriod.apply(s.getVisitDate(),period))
				.map(Statistic::getUserId).distinct().count();
	}

	@Override
	public long getPeriodRegularVisitorsAmount(StatisticPeriod period) {
		Map<String, Long> userMap = statisticList.stream().filter(s->StatisticPeriod.isDateInPeriod.apply(s.getVisitDate(),period))
		.collect(Collectors.groupingBy(Statistic::getUserId,Collectors.counting()));
		return userMap.values().stream().filter(u->u>=10).count();
	}

}
