package com.example.bootsolr;

import org.apache.solr.client.solrj.response.RangeFacet;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class SolrTest {

    @Autowired
    UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void index() {
        User test = new User("1002","test",10);
        User save = userRepository.save(test);
        logger.debug(" user document saved with id: ", save.getId());
    }

//    @Test
//    public void query(){
//        User user = userRepository.findById("1002");
//    }

//    @Test
//    public void update() {
//        User user = User.builder().id("1001").createDate(new RangeFacet.Date()).build();
//        userRepository.save(user);
//        logger.debug("user document updated  with id: ", user.getId());
//    }
//
//    @Test
//    public void delete() {
//        User user = User.builder().id("1001").build();
//        userRepository.delete(user);
//        logger.debug("user document deleted  with id: ", user.getId());
//    }

}
