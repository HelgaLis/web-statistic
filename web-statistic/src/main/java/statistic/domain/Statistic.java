package statistic.domain;

import java.time.LocalDate;

public class Statistic {
	private String userId;
	private String pageId;
	private LocalDate visitDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	public LocalDate getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}
	public Statistic(String userId, String pageId, LocalDate visitDate) {
		super();
		this.userId = userId;
		this.pageId = pageId;
		this.visitDate = visitDate;
	}
	
}
