package org.iii.ee10087.itube.ans.dao;

import java.sql.SQLException;
import java.util.List;

import org.iii.ee10087.itube.ans.bean.AnsBean;

public interface AnsDao {
	AnsBean insert(AnsBean bean) throws SQLException;

	AnsBean findbyPrimaryKey(AnsBean mem) throws SQLException;

	List<AnsBean> getALL() throws SQLException;
}
