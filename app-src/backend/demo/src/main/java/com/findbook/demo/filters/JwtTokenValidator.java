package com.findbook.demo.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.findbook.demo.exception.InvalidTokenException;
import com.google.common.base.Preconditions;

import static java.util.Objects.isNull;

public class JwtTokenValidator {


    public AccessToken validateAuthorizationHeader(String authorizationHeader) throws InvalidTokenException {
        String tokenValue = subStringBearer(authorizationHeader);
        validateToken(tokenValue);
        return new AccessToken(tokenValue);
    }

    private String subStringBearer(String authorizationHeader) throws InvalidTokenException {
        try {
            return authorizationHeader.substring(AccessToken.BEARER.length());
        } catch (Exception ex) {
            throw new InvalidTokenException("There is no AccessToken in a request header");
        }
    }


    private void validateToken(String value) throws InvalidTokenException {
        DecodedJWT decodedJWT = decodeToken(value);
        verifyTokenHeader(decodedJWT);
        verifySignature(decodedJWT);
        verifyPayload(decodedJWT);
    }

    private DecodedJWT decodeToken(String value) throws InvalidTokenException {
        if (isNull(value)) {
            throw new InvalidTokenException("Token has not been provided");
        }

        DecodedJWT decodedJWT = JWT.decode(value);
        log.debug("Token decoded successfully");
        return decodedJWT;
    }


    private void verifyTokenHeader(DecodedJWT decodedJWT) throws InvalidTokenException {
        try {
            Preconditions.checkArgument(decodedJWT.getType().equals("JWT"));
            log.debug("Token's header is correct");
        } catch (IllegalArgumentException ex) {
            throw new InvalidTokenException("Token is not JWT type", ex);
        }
    }
}