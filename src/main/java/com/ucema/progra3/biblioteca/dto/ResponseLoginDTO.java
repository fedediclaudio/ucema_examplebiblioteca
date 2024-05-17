package com.ucema.progra3.biblioteca.dto;

public class ResponseLoginDTO {

    private String token;

    public ResponseLoginDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
