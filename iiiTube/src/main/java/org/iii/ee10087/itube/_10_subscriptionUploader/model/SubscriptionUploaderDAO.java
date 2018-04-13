package org.iii.ee10087.itube._10_subscriptionUploader.model;

import java.sql.SQLException;
import java.util.List;

public interface SubscriptionUploaderDAO {
	List<SubscriptionUploaderBean> queryAllSubscriptionUploader(String userAccount) throws SQLException;

	int insertSubscriptionUploader(SubscriptionUploaderBean sub) throws SQLException;
	
	SubscriptionUploaderBean querySubscriptionUploader(String videoUploaderAccount, String userAccount) throws SQLException;
	
	int updateSubscriptionUploader(SubscriptionUploaderBean sub) throws SQLException;
	
	List<ShowSubscriptionUploaderBean> querySubscriptionUploaderByAccount(String userAccount) throws SQLException;
}
