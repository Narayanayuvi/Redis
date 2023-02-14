package com.example.redis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.entity.product;
import com.example.redis.repository.ProductDao;


@SpringBootApplication
@RestController
@RequestMapping("/product")

public class SpringbootRedisApplication 
{
    @Autowired
	private ProductDao dao;
	
    @PostMapping
	public product save(@RequestBody product product)
	{
		return dao.save(product);
	}
	
    @GetMapping
	public List<product> getAllproducts()
	{
		return dao.findall();
	}
	
	@GetMapping("/{id}")
	public product findProductById(@PathVariable int id)
	{
		return dao.findProductById( id);
	}
	
	@DeleteMapping("/{id}")
	 public String deleteproduct(@PathVariable int id)
	 {
		 return dao.deleteproduct(id);
	 }
  
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRedisApplication.class, args);
	}

}
