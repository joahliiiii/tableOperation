package com.joah.tableOperation.entity;

public class Customer {
    private String id;
    private String name ;
    private String sex ;
    private String birthday ;
    private String phoneNumber;
    private String email;
    private String description;
    private int isDelete;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (isDelete != customer.isDelete) return false;
        if (!id.equals(customer.id)) return false;
        if (!name.equals(customer.name)) return false;
        if (!sex.equals(customer.sex)) return false;
        if (!birthday.equals(customer.birthday)) return false;
        if (!phoneNumber.equals(customer.phoneNumber)) return false;
        if (!email.equals(customer.email)) return false;
        return description.equals(customer.description);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + sex.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + isDelete;
        return result;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public Customer(String id, String name, String sex, String birthday, String phoneNumber, String email, String description, int isDelete) {

        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.description = description;
        this.isDelete = isDelete;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
