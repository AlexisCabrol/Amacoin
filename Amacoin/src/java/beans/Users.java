/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Random;

/**
 *
 * @author Alexis
 */
public class Users {
    private int id;
    private String email;
    private String password;
    private String wallets_bts;
    private String wallets_xrp;
    private String wallets_ltc;
    private String wallets_eth;

    public String getWallets_bts() {
        return wallets_bts;
    }

    public void setWallets_bts(String wallets_bts) {
        this.wallets_bts = wallets_bts;
    }

    public String getWallets_xrp() {
        return wallets_xrp;
    }

    public void setWallets_xrp(String wallets_xrp) {
        this.wallets_xrp = wallets_xrp;
    }

    public String getWallets_ltc() {
        return wallets_ltc;
    }

    public void setWallets_ltc(String wallets_ltc) {
        this.wallets_ltc = wallets_ltc;
    }

    public String getWallets_eth() {
        return wallets_eth;
    }

    public void setWallets_eth(String wallets_eth) {
        this.wallets_eth = wallets_eth;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public static String generateWallet() {
        Random rand = new Random();
        String str = "";
        for(int i=0; i<25; i++) {
            char c = (char)(rand.nextInt(26)+97);
            str+=c;
        }
        return str;
    }
    
    
    
}
