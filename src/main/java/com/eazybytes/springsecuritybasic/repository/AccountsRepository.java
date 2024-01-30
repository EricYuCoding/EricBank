package com.eazybytes.springsecuritybasic.repository;

import com.eazybytes.springsecuritybasic.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {

    Accounts findByCustomerId(int customerId);
}
