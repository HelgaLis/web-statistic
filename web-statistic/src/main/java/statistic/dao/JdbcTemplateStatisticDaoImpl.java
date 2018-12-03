package statistic.dao;
import java.sql.ResultSet;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import statistic.domain.Statistic;
import statistic.domain.StatisticPeriod;
@Repository
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
		String sql=String.format("select count(user_id) from statistic where visit_date between '%s' AND '%s'", 
				period.getStartDate(),period.getEndDate());
		return jdbcTemplate.queryForObject(sql, Long.class);
	}

	@Override
	public long getPeriodUniqVisitorsAmount(StatisticPeriod period) {
		String sql=String.format("select count(distinct user_id) from statistic where visit_date between'%s' AND '%s'",
				period.getStartDate(),period.getEndDate());
		return jdbcTemplate.queryForObject(sql, Long.class);
	}

	@Override
	public long getPeriodRegularVisitorsAmount(StatisticPeriod period) {
		String sql=String.format("select user_id from statistic "
				+ "where visit_date between '%s' AND '%s' group by user_id  having count(distinct page_id)>=10 ",period.getStartDate(),period.getEndDate());
		return jdbcTemplate.queryForList(sql).size();
	}
	
}
