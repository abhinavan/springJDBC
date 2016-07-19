package JDBCSimpleTemplate.JdbcOperation;



import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	
	
    public static void main( String[] args )
    {
  	ApplicationContext ap=new ClassPathXmlApplicationContext("spring.xml");
  
//    	ApplicationContext ap=new AnnotationConfigApplicationContext(StudentConfig.class);
    	StudentDao st=(StudentDao)ap.getBean("sdao");
    	//int status=st.saveStudent(new Student(04,"abhinav","dac"));
    	//boolean flag=st.updateStudent(new Student (03,"neymar","dac"));
    	//System.out.println(flag);
    	
    	System.out.println(st.getAllStudent());
    }
}
