package com.nb.daipengfei.conf;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.nb.daipengfei.annotation.Retry;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/*********************************
 *                               *
 Created by daipengfei on 16/9/11.
 *                               *
 ********************************/
@Configuration
@ConfigurationProperties(prefix = "my")
public class RedisConfig {


    @Bean
    public JedisPool jedisPool() {
//        System.out.println("init pool");
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(3);
        config.setMaxIdle(2);
        config.setTestOnBorrow(true);
        config.setMaxWaitMillis(20000);
        return new JedisPool(config, "localhost", 6379, 2000);
    }

    @Bean
    public JedisCluster jedisCluster(){
        HostAndPort hostAndPort = new HostAndPort("127.0.0.1",2180);
        return new JedisCluster(hostAndPort,1000);
    }

}
