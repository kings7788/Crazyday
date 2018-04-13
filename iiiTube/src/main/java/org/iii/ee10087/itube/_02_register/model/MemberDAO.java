package org.iii.ee10087.itube._02_register.model;



public interface MemberDAO {
	public int saveMember(MemberBean mb) ;

	public boolean accountExists(String account);
	
	public MemberBean queryMember(String account);
	
	
	public int updateMember(MemberBean mb) ;
}
