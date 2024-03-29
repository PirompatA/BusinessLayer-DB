package com.kbtg.apidesign01.profile;

import com.kbtg.apidesign01.wallet.Wallet;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="profile")
public class Profile {
    @Id
    private String email;
    private String name;

    @OneToMany(mappedBy = "profile")
    private List<Wallet> wallets;
}
