package com.example.signin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.signin.model.Signin;
import com.example.signin.repository.SigninRepo;

@Service
public class SigninService {
    @Autowired
    private final SigninRepo signinrepo;

    public SigninService(SigninRepo signinrepo) {
        this.signinrepo = signinrepo;
    }

    public  Signin createSignin (Signin signin){
        return signinrepo.save(signin);

    }
    public List<Signin> getAllSignin(){
        return signinrepo.findAll();
    
    }
    public Signin getSigninId(int signinId){
        return signinrepo.findById(signinId).orElse(null);

    }
}

