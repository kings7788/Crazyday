package util00;


import java.sql.SQLException;

import org.iii.ee10087.itube.HibernateSessionFactory.HibernateUtil;
import org.iii.ee10087.itube._16_.FAQ.bean.*;
import org.iii.ee10087.itube._16_.FAQ.dao.*;
import org.iii.ee10087.itube._16_.FAQ.service.*;


public class GetImageImpl implements GetImageDao {
	

	
	@Override
	public MemberFAQBean getQAImage(MemberFAQBean mem) {
		
		MemberFAQBean mb = null;
		MemberFAQService service = new MemberFAQService();
		try {
			mb = service.select(mem);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mb;
	}

}
