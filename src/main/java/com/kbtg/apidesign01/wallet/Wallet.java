package com.kbtg.apidesign01.wallet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kbtg.apidesign01.profile.Profile;
import jakarta.persistence.*;

@Entity
@Table(name="wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String walletName;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "profile_email")
    private Profile profile;

    public Wallet() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
