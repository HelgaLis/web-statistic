package statistic.service;

public class StatisticReportTemplate {
	private String description;
	private long count;
	public StatisticReportTemplate(String description, long count) {
		super();
		this.description = description;
		this.count = count;
	}
	public String getDescription() {
		return description;
	}
	public long getCount() {
		return count;
	}
}
