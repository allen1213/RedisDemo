package com.example.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {

    private static volatile JedisPool jedisPool;

    private JedisPoolUtil(){}

    public static JedisPool getInstance() {

        if (null == jedisPool) {
            synchronized (JedisPoolUtil.class) {
                if (null == jedisPool) {
                    JedisPoolConfig config = new JedisPoolConfig();
                    config.setMaxTotal(1000);
                    config.setMaxIdle(32);
                    config.setMaxWaitMillis(100*1000);
                    config.setTestOnBorrow(true);

                    jedisPool = new JedisPool(config,"127.0.0.1",6379);
                }
            }
        }
        return jedisPool;
    }


    public static void release(JedisPool jedisPool, Jedis jedis) {

        if (null != jedis) {
            jedisPool.returnResourceObject(jedis);
        }

    }



}
