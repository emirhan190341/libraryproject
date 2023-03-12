package com.emirhanarici.Library.repository;

import com.emirhanarici.Library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
