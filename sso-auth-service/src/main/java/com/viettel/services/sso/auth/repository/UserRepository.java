package com.viettel.services.sso.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viettel.services.sso.auth.model.UsersEntity;

/**
 * @author TungBoom
 */
@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {

	/**
	 *
	 * @param username
	 * @return @{@link UsersEntity}
	 */
	UsersEntity findOneByUsername(String username);
}
