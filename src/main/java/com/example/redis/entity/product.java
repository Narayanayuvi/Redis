package com.example.redis.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("product")
public class product implements Serializable
{
 @Id
  private int id;
  private String name;
  private int qty;
  private long price;
}