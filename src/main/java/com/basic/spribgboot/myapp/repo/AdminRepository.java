package com.basic.spribgboot.myapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.basic.spribgboot.myapp.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
    // String because your primary key is 'email' (VARCHAR in DB)
    
    // Example custom finder method
    Admin findByEmail(String email);
}
