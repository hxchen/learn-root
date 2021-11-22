package com.a3fun.learn.dubbo.consumer.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author chx
 * @Date: 2021/11/4 17:31
 */
@Component
public class ZookeeperFactory implements FactoryBean<CuratorFramework> {
	private ZookeeperConfig zookeeperConfig;
	private CuratorFramework curatorClient;

	@PostConstruct
	public void init() {
		ExponentialBackoffRetry backoffRetry = new ExponentialBackoffRetry(zookeeperConfig.getMaxRetries(), zookeeperConfig.getBaseSleepTimeMs());
		curatorClient = CuratorFrameworkFactory.builder().connectString(zookeeperConfig.getConnectString()).retryPolicy(backoffRetry).build();
		curatorClient.start();
	}

	@Override
	public CuratorFramework getObject() throws Exception {
		return curatorClient;
	}

	@Override
	public Class<?> getObjectType() {
		return CuratorFramework.class;
	}

	@Autowired
	public void setZookeeperConfig(ZookeeperConfig zookeeperConfig) {
		this.zookeeperConfig = zookeeperConfig;
	}
}
