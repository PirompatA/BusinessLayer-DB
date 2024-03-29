package com.kbtg.apidesign01.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
@RequestMapping("/api/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping("")
//    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public List<Wallet> getWallets(){
        return walletService.getWallets();
    }

    @GetMapping("/{id}")
    public Wallet getWalletById(@PathVariable Integer id){
        return walletService.getWalletById(id);
    }

    @PostMapping("")
    public Wallet createWallet(
            @RequestBody WalletRequestDto requestDto){
        return walletService.createWallet(requestDto);
    }

    @PutMapping("/{id}")
    public Wallet editWallet(@PathVariable Integer id,
                             @Validated
                             @RequestBody WalletUpdateRequestDto request) {
        return walletService.editWallet(id,request);
    }

    @DeleteMapping("/{id}")
    public String deleteWallet(@PathVariable Integer id){
        return walletService.deleteWallet(id);
    }
}
