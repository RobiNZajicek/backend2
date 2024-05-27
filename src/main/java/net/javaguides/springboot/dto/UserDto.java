package net.javaguides.springboot.dto;

import net.javaguides.springboot.model.Gender;

/**
 * Data Transfer Object (DTO) for User information.
 */
public class UserDto {

    private String fullname;
    private String email;
    private String password;

    // New fields
    private String name;
    private String lastname;
    private double money;
    private String userName;
    private int phoneNumber;
    private Gender gender;

    /**
     * Gets the user's phone number.
     *
     * @return the phone number of the user.
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the user's phone number.
     *
     * @param phoneNumber the phone number to set.
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the user's full name.
     *
     * @return the full name of the user.
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Sets the user's full name.
     *
     * @param fullname the full name to set.
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * Gets the user's email.
     *
     * @return the email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email.
     *
     * @param email the email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user's password.
     *
     * @return the password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     *
     * @param password the password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the user's first name.
     *
     * @return the first name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's first name.
     *
     * @param name the first name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the user's last name.
     *
     * @return the last name of the user.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the user's last name.
     *
     * @param lastname the last name to set.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the user's available money.
     *
     * @return the amount of money the user has.
     */
    public double getMoney() {
        return money;
    }

    /**
     * Sets the user's available money.
     *
     * @param money the amount of money to set.
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * Gets the user's username.
     *
     * @return the username of the user.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user's username.
     *
     * @param userName the username to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the user's gender.
     *
     * @return the gender of the user.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the user's gender.
     *
     * @param gender the gender to set.
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
