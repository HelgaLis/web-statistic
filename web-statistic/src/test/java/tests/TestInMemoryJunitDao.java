package tests;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import statistic.dao.InMemoryStatisticDao;
import statistic.domain.Statistic;

public class TestInMemoryJunitDao {
	private static final InMemoryStatisticDao dao = new InMemoryStatisticDao();
	@BeforeAll
	public static void addStatistic() {
		dao.createStatisticEntry(new Statistic("1111", "9990", LocalDate.now()));
	}
	@AfterAll
	public static void clearStatistic() {
		dao.removeAll();
	}
}
