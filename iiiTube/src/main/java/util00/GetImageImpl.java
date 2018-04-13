package util00;


import java.sql.SQLException;

import org.iii.ee10087.itube.HibernateSessionFactory.HibernateUtil;
import org.iii.ee10087.itube.QA.bean.MemberQABean;
import org.iii.ee10087.itube.QA.dao.MemberQADAO;
import org.iii.ee10087.itube.QA.dao.MemeberQAHibernate;
import org.iii.ee10087.itube.QA.service.MemberQAService;


public class GetImageImpl implements GetImageDao {
	

	
	@Override
	public MemberQABean getQAImage(MemberQABean mem) {
		
		MemberQABean mb = null;
		MemberQAService service = new MemberQAService();
		try {
			mb = service.select(mem);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mb;
	}

}
