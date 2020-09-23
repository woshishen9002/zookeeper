package com.demo.client.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * @program: ZooKeeper
 * @description:
 * @author: wanghui
 * @create: 2020-09-23 11:01
 */
public class ZookeeperTest {

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 10000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("client watch回调了");
            }
        });
        String path = "/test1";
        String s = zooKeeper.create(path, "aa".getBytes(), null, CreateMode.PERSISTENT);
        System.out.println("-----s:"+s);

        System.in.read();
    }

}
