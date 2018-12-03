package statistic.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.function.BiFunction;

import org.springframework.format.datetime.DateFormatter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

public class StatisticPeriod implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3928943396251589254L;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	public StatisticPeriod() {
		// TODO Auto-generated constructor stub
	}
	//@JsonCreator
	public StatisticPeriod(LocalDate startDate, LocalDate endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public StatisticPeriod(String startDate, String endDate) {

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
