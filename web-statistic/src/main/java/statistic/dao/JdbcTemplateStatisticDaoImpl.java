package statistic.dao;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import statistic.domain.Statistic;
import statistic.domain.StatisticPeriod;

public class JdbcTemplateStatisticDaoImpl implements StatisticDao {
	private final JdbcTemplate jdbcTemplate;
	@Autowired
	public JdbcTemplateStatisticDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public void createStatisticEntry(Statistic statistic) {
		String sql=String.format("insert into statistic(page_id, user_id,visit_date) values('%s','%s','%s')", 
				statistic.getPageId(),statistic.getUserId(),statistic.getVisitDate());
		jdbcTemplate.execute(sql);

	}

	@Override
	public long getGurrentDayVisitorsAmount() {
		String sql=String.format("select count(user_id) from statistic where visit_date='%s'", LocalDate.now());
		return jdbcTemplate.queryForObject(sql, Long.class);
	}

	@Override
	public long getCurrentDayUniqVisitorsAmount() {
		String sql=String.format("select count(distinct user_id) from statistic where visit_date='%s'", LocalDate.now());
		return jdbcTemplate.queryForObject(sql, Long.class);
	}

	@Override
	public long getPeriodVisitorsAmount(StatisticPeriod period) {
		String sql=String.format("select count(user_id) from statistic where visit_date between'%s' AND '%s'", 
				period.getStartDate(),period.getEndDate());
		return jdbcTemplate.queryForObject(sql, Long.class);
	}

	@Override
	public long getPeriodUniqVisitorsAmount(StatisticPeriod period) {
		String sql=String.format("select count(user_id) from statistic where visit_datebetween'%s' AND '%s'",
				period.getStartDate(),period.getEndDate());
		return jdbcTemplate.queryForObject(sql, Long.class);
	}

	@Override
	public long getPeriodRegularVisitorsAmount(StatisticPeriod period) {
		String sql=String.format("SELECT count(distinct user_id), COUNT(page_id) from tempo "
				+ "where visit_datebetween'%s' AND '%s' having count(page_id)>=10",period.getStartDate(),period.getEndDate());
		return jdbcTemplate.queryForObject(sql, Long.class);
	}

	
}
