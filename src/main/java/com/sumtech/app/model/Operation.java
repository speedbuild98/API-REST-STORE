package com.sumtech.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "operation")
public class Operation {

      @Id
      @GeneratedValue
      private long id;

      @Column(name = "first_name_customer")
      private String firstNameCustomer;

      @Column(name = "last_name_customer")
      private String lastNameCustomer;

      @Column(name = "products")
      private String products; 

      @Column(name = "quantity")
      private int quantity;

      @Column(name = "total")
      private long total;

      @Column(name = "date")
      private String date;    
      
      public Operation(){

      }


      public Operation(long id, String firstNameCustomer, String lastNameCustomer, String products, int quantity, long total, String date) {
            super();
            this.firstNameCustomer = firstNameCustomer;
            this.lastNameCustomer = lastNameCustomer;
            this.products = products;
            this.quantity = quantity;
            this.total = total;
            this.date = date;
      }



      public long getId() {
            return this.id;
      }

      public void setId(long id) {
            this.id = id;
      }

      public String getFirstNameCustomer() {
            return this.firstNameCustomer;
      }

      public void setFirstNameCustomer(String firstNameCustomer) {
            this.firstNameCustomer = firstNameCustomer;
      }

      public String getLastNameCustomer() {
            return this.lastNameCustomer;
      }

      public void setLastNameCustomer(String lastNameCustomer) {
            this.lastNameCustomer = lastNameCustomer;
      }

      public String getProducts() {
            return this.products;
      }

      public void setProducts(String products) {
            this.products = products;
      }

      public int getQuantity() {
            return this.quantity;
      }

      public void setQuantity(int quantity) {
            this.quantity = quantity;
      }

      public long getTotal() {
            return this.total;
      }

      public void setTotal(long total) {
            this.total = total;
      }

      public String getDate() {
            return this.date;
      }

      public void setDate(String date) {
            this.date = date;
      }

}
