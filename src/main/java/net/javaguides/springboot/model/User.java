package net.javaguides.springboot.model;

import jakarta.persistence.*;

/**
 * Entity class representing a User.
 */
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;
    private String role;
    private String fullname;
    private String name;
    private String lastname;
    private int money;
    private String userName;
    private int phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    /**
     * Default constructor.
     */
    public User() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param email      the email of the user.
     * @param password   the password of the user.
     * @param role       the role of the user.
     * @param fullname   the full name of the user.
     * @param name       the first name of the user.
     * @param lastname   the last name of the user.
     * @param money      the amount of money the user has.
     * @param userName   the username of the user.
     * @param phoneNumber the phone number of the user.
     */
    public User(String email, String password, String role, String fullname, String name, String lastname, int money, String userName, int phoneNumber) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.fullname = fullname;
        this.name = name;
        this.lastname = lastname;
        this.money = money;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the ID of the user.
     *
     * @return the ID of the user.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     *
     * @param id the ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the email of the user.
     *
     * @return the email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email the email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the role of the user.
     *
     * @return the role of the user.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     *
     * @param role the role to set.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets the full name of the user.
     *
     * @return the full name of the user.
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Sets the full name of the user.
     *
     * @param fullname the full name to set.
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * Gets the first name of the user.
     *
     * @return the first name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the first name of the user.
     *
     * @param name the first name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the last name of the user.
     *
     * @return the last name of the user.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastname the last name to set.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the amount of money the user has.
     *
     * @return the amount of money the user has.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Sets the amount of money the user has.
     *
     * @param money the amount of money to set.
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Gets the username of the user.
     *
     * @return the username of the user.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username of the user.
     *
     * @param userName the username to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the phone number of the user.
     *
     * @return the phone number of the user.
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param phoneNumber the phone number to set.
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the gender of the user.
     *
     * @return the gender of the user.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the gender of the user.
     *
     * @param gender the gender to set.
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
