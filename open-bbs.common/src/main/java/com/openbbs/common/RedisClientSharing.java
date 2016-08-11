package com.openbbs.common;

import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisClientSharing {
	
	private static ShardedJedisPool pool; 
	static {  
	    ResourceBundle bundle = ResourceBundle.getBundle("config/redis/redis");  
	    if (bundle == null) {  
	        throw new IllegalArgumentException(  
	                "[redis.properties] is not found!");  
	    }  
	    JedisPoolConfig config = new JedisPoolConfig();  
	    config.setMaxActive(Integer.valueOf(bundle  
	            .getString("redis.pool.maxActive")));  
	    config.setMaxIdle(Integer.valueOf(bundle  
	            .getString("redis.pool.maxIdle")));  
	    config.setMaxWait(Long.valueOf(bundle.getString("redis.pool.maxWait")));  
	    config.setTestOnBorrow(Boolean.valueOf(bundle  
	            .getString("redis.pool.testOnBorrow")));  
	    config.setTestOnReturn(Boolean.valueOf(bundle  
	            .getString("redis.pool.testOnReturn")));  
	    
		JedisShardInfo jedisShardInfo1 = new JedisShardInfo(bundle.getString("redis1.ip"),
				Integer.valueOf(bundle.getString("redis.port")));
		JedisShardInfo jedisShardInfo2 = new JedisShardInfo(bundle.getString("redis2.ip"),
				Integer.valueOf(bundle.getString("redis.port")));

		List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
		list.add(jedisShardInfo1);
		list.add(jedisShardInfo2);
		
	    pool = new ShardedJedisPool(config, list);
	}  

	public static void main(String[] args) {
		// 从池中获取一个Jedis对象  
		ShardedJedis jedis = pool.getResource();  
		String keys = "name";  
		  
		// 删数据  
		jedis.del(keys);  
		// 存数据  
		jedis.set(keys, "snowolf");  
		// 取数据  
		String value = jedis.get(keys);  
		  
		System.out.println(value);  
		  
		// 释放对象池  
		pool.returnResource(jedis);  
	}
}
