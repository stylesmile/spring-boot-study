package com.example.bootsolr;

import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface UserRepository extends SolrCrudRepository<User, String> {
    /**
     * find user by username
     *
     * @param username
     * @return
     */
    public List<User> findByUsernameContains(String username);

    

}
