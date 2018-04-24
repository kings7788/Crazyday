package org.iii.ee10087.itube._16_.Manager.dao;

import java.sql.SQLException;
import java.util.List;

import org.iii.ee10087.itube._16_.Manager.bean.*;

public interface ManageDao {
	ManageBean insert(ManageBean bean) throws SQLException;

	ManageBean update(ManageBean mem) throws SQLException ;

	ManageBean delete(ManageBean mem) throws SQLException;

	ManageBean findbyPrimaryKey(String account) throws SQLException;

	List<ManageBean> getALL() throws SQLException;

}
