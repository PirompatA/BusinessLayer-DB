package com.kbtg.apidesign01.wallet;

import com.kbtg.apidesign01.exception.DuplicateWalletException;
import com.kbtg.apidesign01.exception.NotFoundException;
import com.kbtg.apidesign01.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    @Qualifier("googleMail")
    private MailService mailService;

    @Autowired
    private WalletRepository walletRepository;

//     List<Wallet> wallets = new ArrayList<>(
//             List.of(new Wallet(1,"AAA","AAA@email.com"),
//                     new Wallet(2,"BBB","BBB@email.com"),
//                     new Wallet(3,"CCC","CCC@email.com"))
//     );

    public List<Wallet> getWallets(){
        List<Wallet> walletList = walletRepository.findAll();
        return walletList;
    }

    public Wallet getWalletById(Integer id){
//        return wallets.stream().filter(wallet -> wallet.getId() == id)
//                .findFirst().orElseThrow(() -> new NotFoundException("Wallet not found by id: "+id) );

        return null;
    }

    public Wallet createWallet(WalletRequestDto requestDto) {
//        wallets.stream().filter(wallet -> wallet.getEmail().equals(requestDto.email()))
//                .findFirst()
//                .ifPresent(wallet -> {
//                    throw new DuplicateWalletException("Email: "+requestDto.email()+ " already exists in the system");
//                });
//        Optional<Integer> maxId = wallets.stream().map(Wallet::getId).max(Integer::compareTo);
//        int nextId = maxId.orElse(0) + 1;
//        Wallet wallet = new Wallet(nextId, requestDto.name(), requestDto.email());
//        wallets.add(wallet);
//        mailService.sendEmail("admin@wallet.com","new wallet created.");
//        return wallet;
        Wallet wallet = new Wallet();
        wallet.setWalletName(requestDto.name());
        wallet.setActive(true);
        walletRepository.save(wallet);
        return wallet;
    }

    public Wallet editWallet( Integer id, WalletUpdateRequestDto request) {
//        Wallet wallet = this.getWalletById(id);
//        wallet.setName(request.name());
//        return wallet;
        Optional<Wallet> optionalWallet = walletRepository.findById(Long.valueOf(id));
        if (optionalWallet.isEmpty()){
            throw new NotFoundException("Id: "+id+" doesn't exist in database.");
        }

        Wallet wallet = optionalWallet.get();
        wallet.setWalletName(request.name());
        walletRepository.save(wallet);
        return wallet;
    }

    public String deleteWallet(Integer id){
//        this.getWalletById(id);
//        wallets.removeIf(w -> w.getId()==id);
//        System.out.println("wallet id: "+id+" is removed.");
//        return "wallet id: "+id+" is removed.";
        walletRepository.deleteById(Long.valueOf(id));
        return "okie";
        }

    public void activeAllWalletsActive(){
        walletRepository.setAllWalletsActive();
        }

    public void deleteWalletsByIdBelow3(){
        walletRepository.deleteWalletsByIdBelow3();
    }
}
