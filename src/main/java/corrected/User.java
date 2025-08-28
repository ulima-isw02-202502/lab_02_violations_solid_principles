/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corrected;

import java.util.regex.Pattern;

/**
 *
 * @author jacks
 */
public class User {

    protected String name;
    protected String email;
    protected String userType; // "PREMIUM", "REGULAR", "VIP"
    protected double totalPurchases;

    public User(String name, String email, String userType, double totalPurchases) {
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.totalPurchases = totalPurchases;
    }

    public User(String userType, double totalPurchases) {
        this.userType = userType;
        this.totalPurchases = totalPurchases;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public double getTotalPurchases() {
        return totalPurchases;
    }

    public void setTotalPurchases(double totalPurchases) {
        this.totalPurchases = totalPurchases;
    }





}
