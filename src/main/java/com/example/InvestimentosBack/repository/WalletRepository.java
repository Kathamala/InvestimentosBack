package com.example.InvestimentosBack.repository;

import com.example.InvestimentosBack.domain.Wallet;

import java.util.ArrayList;

public class WalletRepository {
    static ArrayList<Wallet> wallet = new ArrayList<Wallet>();
    public static ArrayList<Wallet> getAll() {
        return wallet;
    }
    public static Wallet add(Wallet newWallet) {
        if(getOne(newWallet.getId()) != null) return null;
        wallet.add(newWallet);
        return newWallet;
    }
    public static Wallet getOne(Integer id) {
        if(id == null) return null;
        for(Wallet w : wallet){
            if(w.getId() == id){
                return w;
            }
        }
        return null;
    }

    public static boolean delete(Integer id) {
        for(Wallet w : wallet){
            if(w.getId() == id){
                wallet.remove(w);
                return true;
            }
        }
        return false;
    }
    public static Wallet update(Wallet updatedWallet) {
        for(int i = 0; i < wallet.size(); i++){
            if(wallet.get(i).getId() == updatedWallet.getId()){
                wallet.set(i, updatedWallet);
                return wallet.get(i);
            }
        }
        return null;
    }
}
