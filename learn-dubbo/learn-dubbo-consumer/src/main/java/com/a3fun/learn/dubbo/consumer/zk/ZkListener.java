package com.a3fun.learn.dubbo.consumer.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

/**
 * @author chx
 * @Date: 2021/11/4 17:15
 */
@Component
public class ZkListener {
	@Resource
	private CuratorFramework curatorClient;

	@PostConstruct
	public void init(){
		String path = "/zktest1";

		//当前节点
		CuratorCache curatorCache = CuratorCache.builder(curatorClient, path).build();
		CuratorCacheListener listener = CuratorCacheListener
				.builder()
				.forNodeCache(() -> {
					Optional<ChildData> childData = curatorCache.get(path);
					if(childData.isPresent()) {
						String data = new String(childData.get().getData());
						System.out.println("--------【NodeCacheListener--------】---------nodePath:" + path + " data:" + data);
					}
				})
				.build();
		curatorCache.listenable().addListener(listener);

		//监听子节点，不监听当前节点
		CuratorCacheListener pathCacheListener = CuratorCacheListener
				.builder()
				.forPathChildrenCache(path, curatorClient, (client, event) -> {
					String type = event.getType().name();
					System.out.println("--------【PathChildrenCacheListener】-------- type:" + type);
					Optional.ofNullable(event.getData()).ifPresent(childata -> {
						String nodePath = childata.getPath();
						String data = "";
						if(Objects.nonNull(childata.getData())) {
							data = new String(childata.getData());
						}
						System.out.println("--------【PathChildrenCacheListener】-------- nodePath:" + nodePath + " data:" + data + " type:" + type);
					});
				})
				.build();
		curatorCache.listenable().addListener(pathCacheListener);

		CuratorCacheListener treeListener = CuratorCacheListener
				.builder()
				.forTreeCache(curatorClient, (client, event) -> {
					String type = event.getType().name();
					System.out.println("--------【TreeCacheListener--------】-------- type:" + type);
					Optional.ofNullable(event.getData()).ifPresent(childata -> {
						String nodePath = childata.getPath();
						String data = "";
						if(Objects.nonNull(childata.getData())) {
							data = new String(childata.getData());
						}
						System.out.println("--------【TreeCacheListener--------】-------- nodePath:" + nodePath + " data:" + data + " type:" + type);
					});
				})
				.build();
		curatorCache.listenable().addListener(treeListener);

		curatorCache.start();
	}
}
