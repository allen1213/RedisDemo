package com.example.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Test {

    public static void main(String[] args) {

        JedisPool jedisPool = JedisPoolUtil.getInstance();

        Jedis jedis = jedisPool.getResource();

    }
}
