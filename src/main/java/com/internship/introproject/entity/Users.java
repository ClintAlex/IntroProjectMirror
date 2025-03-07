package com.internship.introproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "username", nullable = false, length = 255)
    private String username;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Embedded
    private Address address;

    @Embeddable
    public static class Address {
        @Column(name = "street", nullable = false, length = 255)
        private String street;

        @Column(name = "suite", nullable = false, length = 255)
        private String suite;

        @Column(name = "city", nullable = false, length = 255)
        private String city;

        @Column(name = "zipcode", nullable = false, length = 255)
        private String zipcode;

        @Embedded
        private Geo geo;

        public Address() {
        }

        public Address(String street, String suite, String city, String zipcode, Geo geo) {
            this.street = street;
            this.suite = suite;
            this.city = city;
            this.zipcode = zipcode;
            this.geo = geo;
        }

        public String getStreet() {
            return street;
        }
        public void setStreet(String street) {
            this.street = street;
        }
        public String getSuite() {
            return suite;
        }
        public void setSuite(String suite) {
            this.suite = suite;
        }
        public String getCity() {
            return city;
        }
        public void setCity(String city) {
            this.city = city;
        }
        public String getZipcode() {
            return zipcode;
        }
        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }
        public Geo getGeo() {
            return geo;
        }
        public void setGeo(Geo geo) {
            this.geo = geo;
        }
    }

    @Embeddable
    public static class Geo {
        @Column(name = "lat", nullable = false, length = 255)
        private String lat;

        @Column(name = "lng", nullable = false, length = 255)
        private String lng;

        public Geo() {

        }

        public Geo(String lat, String lng) {
            this.lat = lat;
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }
        public void setLat(String lat) {
            this.lat = lat;
        }
        public String getLng() {
            return lng;
        }
        public void setLng(String lng) {
            this.lng = lng;
        }
    }
    @Column(name = "phone", nullable = false, length = 255)
    private String phone;

    @Column(name = "website", nullable = false, length = 255)
    private String website;

    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "company_name"))
    private Company company;

    @Embeddable
    public static class Company {
        @Column(name = "name", nullable = false, length = 255)
        private String name;
        @Column(name = "catchPhrase", nullable = false, length = 255)
        private String catchPhrase;
        @Column(name = "bs", nullable = false, length = 255)
        private String bs;

        public Company() {

        }

        public Company(String name, String catchPhrase, String bs) {
            this.name = name;
            this.catchPhrase = catchPhrase;
            this.bs = bs;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getCatchPhrase() {
            return catchPhrase;
        }
        public void setCatchPhrase(String catchPhrase) {
            this.catchPhrase = catchPhrase;
        }
        public String getBs() {
            return bs;
        }
        public void setBs(String bs) {
            this.bs = bs;
        }
    }

    public Users() {

    }

    public Users(Long id, String name, String username, String email, Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
}
