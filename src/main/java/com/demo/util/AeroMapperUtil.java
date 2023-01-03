package com.demo.util;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.mapper.tools.AeroMapper;
//import com.htek.configuration.AerospikeConfiguration;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class AeroMapperUtil {
//	@Inject
//    AerospikeConfiguration config;

	AeroMapper mapper = null;
	
//	  private static final Logger LOGGER = LogManager.getLogger(AeroMapperUtil.class.getName());
	
	@PostConstruct
	public void setupAerospikeClient() {
//		LOGGER.info("In class " + getClass().getSimpleName() + ".setupAerospikeClient()");
		ClientPolicy policy = new ClientPolicy();
		policy.readPolicyDefault.socketTimeout = 50;
		policy.readPolicyDefault.totalTimeout = 110;
		policy.readPolicyDefault.sleepBetweenRetries = 10;
		policy.writePolicyDefault.socketTimeout = 200;
		policy.writePolicyDefault.totalTimeout = 450;
		policy.writePolicyDefault.sleepBetweenRetries = 50;

		AerospikeClient client = new AerospikeClient(policy, "127.0.0.1", 3000);
		mapper = new AeroMapper.Builder(client).build();
	}
	public AeroMapper getMapper() {
//		LOGGER.info("In class " + getClass().getSimpleName() + ".getMapper()");
		return this.mapper;
	}
}
