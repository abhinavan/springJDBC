package JDBCSimpleTemplate.JdbcOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public class StudentDao 
{
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) 
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	public int saveStudent(Student s)
	{
		String name=s.getName();
		String course=s.getCourse();
		int roll=s.getRoll();
		String query="insert into student values("+roll+",'"+name+"','"+course+"')";
		System.out.println("Query is: "+query);
		return jdbcTemplate.update(query);
	}
	
	public Boolean updateStudent(final Student s)
	{
	
		String query="update student  set roll=?,name=?,course=? where roll=?";
		return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>() 
		{

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException 
			{
				ps.setInt(1,23);
				ps.setString(2,s.getName());
				ps.setString(3,s.getCourse());
				
				ps.setInt(4,s.getRoll());
				return ps.execute();
			}
			
		});
	}
	public List<Student> getAllStudent()
	{
		return jdbcTemplate.query("select * from student" , new ResultSetExtractor<List<Student>> ()
				{

					public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException 
					{
						List<Student> list=new ArrayList<Student>();
						while(rs.next())
						{
							Student s=new Student();
							s.setRoll(rs.getInt("roll"));
							s.setName(rs.getString("name"));
							s.setCourse(rs.getString("course"));
							
							list.add(s);
						}
						return list;
					}
			
				});
	}

}
