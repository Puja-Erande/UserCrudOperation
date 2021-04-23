package com.kpi.ninja.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.kpi.ninja.assignment.model.User;
//repository that extends CrudRepository

public interface UserRepository extends JpaRepository<User, Integer> {
}
