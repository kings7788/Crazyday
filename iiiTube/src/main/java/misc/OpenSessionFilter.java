//package misc;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.hibernate.HibernateException;
//import org.iii.ee10087.itube.HibernateSessionFactory.HibernateUtil;
//
//@WebFilter("/*")
//public class OpenSessionFilter implements Filter {
//	private FilterConfig filterConfig;
////testpush001
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		this.filterConfig = filterConfig;
//	}
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest request = (HttpServletRequest) req;
//		HttpServletResponse response = (HttpServletResponse) resp;
//		try {
//			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//			chain.doFilter(request, response);
//			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//			HibernateUtil.getSessionFactory().getCurrentSession().close();
//		} catch (Throwable e) {
//			e.printStackTrace();
//			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
//			HibernateUtil.getSessionFactory().getCurrentSession().close();
//			chain.doFilter(request, response);
//		}
//	}
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//
//	}
//
//}
