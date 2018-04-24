package org.iii.ee10087.itube.memberRegister.dao;

import java.sql.SQLException;
import java.util.List;

import org.iii.ee10087.itube.memberRegister.bean.MemberBean;



public interface MemberDAO {

	MemberBean select(String account);

	List<MemberBean> select();

	MemberBean insert(MemberBean bean) throws SQLException;

	void delete(String account);

	MemberBean update(MemberBean bean) throws SQLException;

}