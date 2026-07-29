package com.in28minutes.springboot.rest_api.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

public interface UserDetailsRestRepository extends JpaRepository<UserDetails, Long> {

	List<UserDetails> findByRole(String roleName);
}
