package com.example.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class RedisTransaction {
    public static void main(String[] args) {
        RedisTransaction r = new RedisTransaction();
        System.out.println(r.transactionMethod());
    }

    private static boolean transactionMethod() {
        Jedis jedis = new Jedis("localhost", 6379);
       /* jedis.set("balance","100");
        jedis.set("debt","0");*/

        int balance,debt,amount = 10;

        jedis.watch("balance");

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        balance = Integer.parseInt(jedis.get("balance"));

        if (balance < amount) {
            jedis.unwatch();
            System.out.println("balance < amount  -> unwatch");
            return false;
        } else {
            System.out.println("begin transaction");
            Transaction transaction = jedis.multi();
            transaction.decrBy("balance",amount);
            transaction.incrBy("debt",amount);
            transaction.exec();

            balance = Integer.parseInt(jedis.get("balance"));
            debt = Integer.parseInt(jedis.get("debt"));

            System.out.println("balance = " + balance + ", debt = " + debt);
            return true;
        }

    }


    private static void test01() {
        Jedis jedis = new Jedis("localhost", 6379);

        Transaction transaction = jedis.multi();

        transaction.set("handsome","allen");
        transaction.set("k1","k1");
        transaction.set("k2","k2");

        transaction.exec();
    }
}
