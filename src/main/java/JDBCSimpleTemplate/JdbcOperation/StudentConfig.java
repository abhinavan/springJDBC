package JDBCSimpleTemplate.JdbcOperation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class StudentConfig 
{
	public DriverManagerDataSource dbProperties()
	{
		DriverManagerDataSource dnd=new DriverManagerDataSource();
		dnd.setDriverClassName("com.mysql.jdbc.Driver");
		dnd.setUrl("jdbc:mysql://localhost/test");
		dnd.setUsername("root");
		dnd.setPassword("root");
		
		return dnd;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		JdbcTemplate j=new JdbcTemplate();
		j.setDataSource(new StudentConfig().dbProperties());
		return j;
	}
}
