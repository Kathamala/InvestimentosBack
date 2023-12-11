package com.example.InvestimentosBack.controller;

import com.example.InvestimentosBack.domain.Wallet;
import com.example.InvestimentosBack.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wallet")
public class WalletController {
    @Autowired private WalletService service;

    @GetMapping("/getAll")
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<String>("hello", null, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Wallet> newWallet() {
        return new ResponseEntity<Wallet>(new Wallet(), null, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Wallet> getOne(@PathVariable Integer id) {
        return new ResponseEntity<Wallet>(new Wallet(), null, HttpStatus.OK);
    }
}
