package statistic.domain;

import java.time.LocalDate;
import java.util.function.BiFunction;

public class StatisticPeriod {
	private LocalDate startDate;
	private LocalDate endDate;
	public StatisticPeriod(LocalDate startDate, LocalDate endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public static BiFunction<LocalDate, StatisticPeriod, Boolean> isDateInPeriod = (LocalDate date, StatisticPeriod period)->
	date.isEqual(period.startDate)||date.isAfter(period.startDate)||date.isEqual(period.endDate)||date.isBefore(period.endDate);
	@Override
	public String toString() {
		return startDate + "- " + endDate;
	}
}
