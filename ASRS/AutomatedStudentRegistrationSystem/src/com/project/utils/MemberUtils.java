package com.project.utils;

public interface MemberUtils {

	public boolean authenticate(String email, String password, String designation);

	public boolean changePassword(String email, String password, String newPassword);
	
}
