package com.sumtech.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long id;

      @Column(name = "first_name")
      private String firstName;

      @Column(name = "last_name")
      private String Lastname;

      @Column(name = "email")
      private String email;
      
      public Customer(){

      }


      public Customer(String firstName, String Lastname, String email) {
            super();
            this.firstName = firstName;
            this.Lastname = Lastname;
            this.email = email;
      }

      public long getId() {
            return this.id;
      }

      public void setId(long id) {
            this.id = id;
      }

      public String getFirstName() {
            return this.firstName;
      }

      public void setFirstName(String firstName) {
            this.firstName = firstName;
      }

      public String getLastname() {
            return this.Lastname;
      }

      public void setLastname(String Lastname) {
            this.Lastname = Lastname;
      }

      public String getEmail() {
            return this.email;
      }

      public void setEmail(String email) {
            this.email = email;
      }
}
