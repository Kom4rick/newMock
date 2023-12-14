package com.example.newMock.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestDTO {
    private String rqUID;
    private String clientId;

//    public String getRqUID() {
//        return rqUID;
//    }
//
//    public void setRqUID(String rqUID) {
//        this.rqUID = rqUID;
//    }
//
//    public String getClientId() {
//        return clientId;
//    }
//
//    public void setClientId(String clientId) {
//        this.clientId = clientId;
//    }
//
//    public String getAccount() {
//        return account;
//    }
//
//    public void setAccount(String account) {
//        this.account = account;
//    }
//
//    public String getOpenDate() {
//        return openDate;
//    }
//
//    public void setOpenDate(String openDate) {
//        this.openDate = openDate;
//    }
//
//    public String getCloseDat() {
//        return closeDat;
//    }
//
//    public void setCloseDat(String closeDat) {
//        this.closeDat = closeDat;
//    }

    private String account;
    private String openDate;
    private String closeDat;
}
