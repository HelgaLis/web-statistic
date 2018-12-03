package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import statistic.configuration.RootApplicationContextConfig;
import statistic.dao.StatisticDao;
import statistic.domain.Statistic;
import statistic.domain.StatisticPeriod;
@Testable
public class TestStatisticDaoJdbcImpl {
	private static StatisticDao dao;
	private static ApplicationContext context;
	static {
		context = new AnnotationConfigApplicationContext(RootApplicationContextConfig.class);
		dao = context.getBean(StatisticDao.class);

	}
	@BeforeAll
	public static void initialize() {
		String user_id1 = "ivan";
		String user_id2="sveta";
		String user_id3="kostya";
		for(int i = 0; i<=9; i++) {
			Statistic entry = new Statistic(user_id1,new Random().toString(),LocalDate.now());
			dao.createStatisticEntry(entry);
		}
		for(int i=0; i<=4;i++) {
			String randomPageId=new Random().toString();
			Statistic entry = new Statistic(user_id2,randomPageId,LocalDate.now());
			dao.createStatisticEntry(entry);
			dao.createStatisticEntry(entry);
		}
		for(int i=0; i<=3; i++) {
			Statistic entry = new Statistic(user_id3,new Random().toString(),LocalDate.now());
			dao.createStatisticEntry(entry);
		}
	}
	
	@Test
	public void testCurrentDayVisitors() {
		long count = dao.getGurrentDayVisitorsAmount();
		assertEquals(24, count);
	}
	@Test
	public void testCurrentDayUniqueVisitors() {
		long count = dao.getCurrentDayUniqVisitorsAmount();
		assertEquals(3, count);
	}
	@Test
	public void testPeriodVisirors() {
		StatisticPeriod period = new StatisticPeriod(LocalDate.now(), LocalDate.now());
		long count = dao.getPeriodVisitorsAmount(period);
		assertEquals(24, count);
	}
	@Test
	public void testPeriodUniqueVisitors() {
		StatisticPeriod period = new StatisticPeriod(LocalDate.now(), LocalDate.now());
		long count = dao.getPeriodUniqVisitorsAmount(period);
		assertEquals(3, count);
	}
	@Test
	public void testPeriodRegularVisitors() {
		StatisticPeriod period = new StatisticPeriod(LocalDate.now(), LocalDate.now());
		long count = dao.getPeriodRegularVisitorsAmount(period);
		assertEquals(1, count);
		
	}
}
