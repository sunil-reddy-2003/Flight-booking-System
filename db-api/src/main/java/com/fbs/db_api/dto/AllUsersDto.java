package com.fbs.db_api.dto;

import com.fbs.db_api.models.AppUser;

import java.util.List;

public class AllUsersDto {
    List<AppUser> appUsers;

    public AllUsersDto() {
    }

    public AllUsersDto(List<AppUser> appUsers) {
        this.appUsers = appUsers;
    }

    public List<AppUser> getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(List<AppUser> appUsers) {
        this.appUsers = appUsers;
    }

    @Override
    public String toString() {
        return "AllUsersDto{" +
                "appUsers=" + appUsers +
                '}';
    }
}
