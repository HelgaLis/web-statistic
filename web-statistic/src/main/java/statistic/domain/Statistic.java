package statistic.domain;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Statistic implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3052508451218507877L;
	private String userId;
	private String pageId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate visitDate;
	
	public String getUserId() {
		return userId;
	}
	public String getPageId() {
		return pageId;
	}
	public LocalDate getVisitDate() {
		return visitDate;
	}

	public Statistic() {
		
	}
	//@JsonCreator
	public Statistic(String userId, String pageId, LocalDate visitDate) {
		super();
		this.userId = userId;
		this.pageId = pageId;
		this.visitDate = visitDate;
	}
	
}
