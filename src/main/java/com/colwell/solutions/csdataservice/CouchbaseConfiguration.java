package com.colwell.solutions.csdataservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.colwell.solutions.csdataservice"})
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

    @Override
    protected List<String> getBootstrapHosts(){
        return Arrays.asList("couchbase");
    }

    @Override
    protected String getBucketName(){
        return "default";
    }

    @Override
    protected String getBucketPassword(){
        return "default1234";
    }
}
