package com.sumtech.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long id;

      @Column(name = "name")
      private String name;

      @Column(name = "code")
      private String code;

      @Column(name = "stock")
      private long stock;

      @Column(name = "price")
      private long price;

      public Product(){

      }

      public Product(String name, String code, long stock, long price) {
            super();
            this.name = name;
            this.code = code;
            this.stock = stock;
            this.price = price;
      }

      public long getId() {
            return this.id;
      }

      public void setId(long id) {
            this.id = id;
      }

      public String getName() {
            return this.name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public String getCode() {
            return this.code;
      }

      public void setCode(String code) {
            this.code = code;
      }

      public long getStock() {
            return this.stock;
      }

      public void setStock(long stock) {
            this.stock = stock;
      }

      public long getPrice() {
            return this.price;
      }

      public void setPrice(long price) {
            this.price = price;
      }

}
