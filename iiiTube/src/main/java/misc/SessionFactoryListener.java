//package misc;
//
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
//import org.iii.ee10087.itube.HibernateSessionFactory.HibernateUtil;
//@WebListener
//public class SessionFactoryListener implements ServletContextListener {
//
//	@Override
//	public void contextInitialized(ServletContextEvent event) {
//		System.out.println("hello world");
//		HibernateUtil.getSessionFactory();
//	}
//
//	@Override
//	public void contextDestroyed(ServletContextEvent event) {		
//		HibernateUtil.closeSessionFactory();
//		System.out.println("goodbye world");
//	}
//
//}
