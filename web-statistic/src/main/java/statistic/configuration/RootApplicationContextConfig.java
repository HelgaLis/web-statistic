package statistic.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
/*import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;*/
import org.springframework.stereotype.Controller;

import statistic.dao.JdbcTemplateStatisticDaoImpl;
import statistic.dao.StatisticDao;
import statistic.service.StatisticService;
import statistic.service.StatisticServiceImpl;

@Controller
@ComponentScan("statistic")


public class RootApplicationContextConfig {
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL).addScript("/db/sql/create-table.sql").build();
		return db;
	}
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	@Bean
	public StatisticDao statisticDao() {
		return new JdbcTemplateStatisticDaoImpl(getJdbcTemplate());
	}
	@Bean StatisticService statisticService() {
		return new StatisticServiceImpl(statisticDao());
	}

}
