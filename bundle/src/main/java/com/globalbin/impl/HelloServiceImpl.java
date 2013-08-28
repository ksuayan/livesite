package com.globalbin.impl;

import javax.jcr.Repository;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.globalbin.HelloService;
import com.globalbin.mongodb.MongoAccess;

/**
 * One implementation of the {@link HelloService}. Note that
 * the repository is injected, not retrieved.
 */
@Service
@Component(metatype = false)
public class HelloServiceImpl implements HelloService, BundleActivator {
    
    @Reference
    private SlingRepository repository;
    private MongoAccess mongo;

    public String getRepositoryName() {
        return repository.getDescriptor(Repository.REP_NAME_DESC);
    }

	public void start(BundleContext context) throws Exception {
		mongo.init();
		System.out.println("Start HelloService...");
	}

	public void stop(BundleContext context) throws Exception {
		mongo.shutdown();
		System.out.println("End HelloService...");
	}

	public String getDbInfo() {
		
		return mongo.getDbInfo();
	}

}
