package com.basic.spribgboot.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.spribgboot.myapp.model.Admin;
import com.basic.spribgboot.myapp.repo.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public Admin addAdmin(Admin admin)
	{
		adminRepository.save(admin);
		return admin;
	}
	
	public Admin getAdmin(String email)
	{
		Admin byEmail = adminRepository.findByEmail(email);
		return byEmail;
	}

}
