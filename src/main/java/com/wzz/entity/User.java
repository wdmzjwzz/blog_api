package com.wzz.entity;


import java.io.Serializable;

public class User implements Serializable {
        private String userName;
        private String password;
        private String userId;
        public String getUserName() {
            return userName;
        }
        public void setUserName(String username) {
            this.userName = username;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getUserId() {
            return userId;
        }
        public void setUserId(String userId) {
            this.userId = userId;
        }
    }