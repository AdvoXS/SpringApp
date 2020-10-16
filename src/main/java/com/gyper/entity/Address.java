package com.gyper.entity;

import javax.persistence.*;

    @Entity
    @Table(name = "ADDRESS")
    public class Address {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private String city;

        @Column
        private String street;

        @Column(name = "home_number")
        private String homeNumber;

        public Address(String city, String street, String homeNumber) {
            this.city = city;
            this.street = street;
            this.homeNumber = homeNumber;
        }

        public Address() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getHomeNumber() {
            return homeNumber;
        }

        public void setHomeNumber(String homeNumber) {
            this.homeNumber = homeNumber;
        }
    }
