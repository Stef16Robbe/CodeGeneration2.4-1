package io.swagger.service;

import io.swagger.dao.SessionTokenRepository;
import io.swagger.model.SessionToken;
import io.swagger.model.User;
import org.springframework.stereotype.Service;

@Service
public class SessionTokenService {

    private SessionTokenRepository sessionTokenRepository;

    public SessionTokenService(SessionTokenRepository sessionTokenRepository) {
        this.sessionTokenRepository = sessionTokenRepository;
    }

    public void registerSessionToken(SessionToken sessionToken){
        SessionToken checkSessionToken = sessionTokenRepository.getByUserIdEquals(sessionToken.getUserId());
        if (checkSessionToken != null){
            sessionTokenRepository.delete(checkSessionToken.getId());
            sessionTokenRepository.save(sessionToken);
        } else{
            sessionTokenRepository.save(sessionToken);
        }
    }

    public SessionToken getSessionTokenByAuthKey(String authKey){
        return sessionTokenRepository.getByAuthKeyEquals(authKey);
    }

    public void logout(String authKey){
        SessionToken sessionToken = getSessionTokenByAuthKey(authKey);
        sessionTokenRepository.delete(sessionToken.getId());
    }



}