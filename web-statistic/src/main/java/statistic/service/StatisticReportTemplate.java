package statistic.service;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;

public class StatisticReportTemplate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8231986927691645592L;
	private String description;
	private long count;
	public StatisticReportTemplate() {
		// TODO Auto-generated constructor stub
	}
	//@JsonCreator
	public StatisticReportTemplate(String description, long count) {
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
