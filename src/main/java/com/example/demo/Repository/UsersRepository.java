package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>  {

	public Users findByEmail(String email);
}
