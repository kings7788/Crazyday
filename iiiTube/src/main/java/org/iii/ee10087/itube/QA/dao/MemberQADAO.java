package org.iii.ee10087.itube.QA.dao;

import java.sql.SQLException;
import java.util.List;

import org.iii.ee10087.itube.QA.bean.MemberQABean;

public interface MemberQADAO {

	MemberQABean insert(MemberQABean mem) throws SQLException;

	MemberQABean update(MemberQABean mem) throws SQLException;

	MemberQABean delete(MemberQABean mem) throws SQLException;

	MemberQABean findbyPrimaryKey(MemberQABean mem) throws SQLException;

	List<MemberQABean> getALL() throws SQLException;

}