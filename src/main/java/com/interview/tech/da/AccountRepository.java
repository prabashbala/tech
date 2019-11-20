package com.interview.tech.da;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<AccountDA, Long>
{
}
