package com.a3fun.learn.dubbo.consumer.zk;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author chx
 * @Date: 2021/11/4 17:30
 */
@Configuration
@ConfigurationProperties(prefix = "zookeeper")
public class ZookeeperConfig {
	private String connectString;
	private Integer maxRetries;
	private Integer baseSleepTimeMs;

	public String getConnectString() {
		return connectString;
	}

	public void setConnectString(String connectString) {
		this.connectString = connectString;
	}

	public Integer getMaxRetries() {
		return maxRetries;
	}

	public void setMaxRetries(Integer maxRetries) {
		this.maxRetries = maxRetries;
	}

	public Integer getBaseSleepTimeMs() {
		return baseSleepTimeMs;
	}

	public void setBaseSleepTimeMs(Integer baseSleepTimeMs) {
		this.baseSleepTimeMs = baseSleepTimeMs;
	}
}
