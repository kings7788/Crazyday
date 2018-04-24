package org.iii.ee10087.itube._16_.FAQ.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.*;

import org.iii.ee10087.itube._16_.FAQ.bean.*;

public interface MemberFAQDao{

	MemberFAQBean insert(MemberFAQBean mem) throws SQLException;

	MemberFAQBean update(MemberFAQBean mem) throws SQLException;

	MemberFAQBean delete(MemberFAQBean mem) throws SQLException;

	MemberFAQBean findbyPrimaryKey(MemberFAQBean mem) throws SQLException;

	List<MemberFAQBean> getALL() throws SQLException;

}