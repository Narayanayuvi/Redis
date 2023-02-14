package com.example.redis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.redis.entity.product;


@Repository
public class ProductDao 
{
	
  public static final String HASH_Key="product";
  
  @Autowired
  private RedisTemplate template;
  
  public product save(product product)
  {	 
	 template.opsForHash().put(HASH_Key, product.getId(), product);
	 return product;
  }
  
  public List<product> findall()
  {
	  return template.opsForHash().values(HASH_Key);
  }
  
  public product findProductById(int id)
  {
	  
	  return (product) template.opsForHash().get(HASH_Key,id);
  }
  
  public String deleteproduct(int id)
  {
	  template.opsForHash().delete(HASH_Key, id);
	  return "product removed !!";
  }
}
