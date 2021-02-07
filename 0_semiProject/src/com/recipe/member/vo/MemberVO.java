package com.recipe.member.vo;

import java.sql.Date;

public class MemberVO {
   private int userNum;
   private String userId;
   private String userPw;
   private String userName;
   private String userEmail;
   private char userGender;
   private String userNickname;
   private String userBirth;
   private String userPhone;
   private char userDel;
   private Date userDate;
   
   public MemberVO() { }
   public MemberVO(int userNum, String userId, String userPw, String userName, String userEmail, char userGender,
         String userNickname, String userBirth, String userPhone, char userDel, Date userDate) {
      this.userNum = userNum;
      this.userId = userId;
      this.userPw = userPw;
      this.userName = userName;
      this.userEmail = userEmail;
      this.userGender = userGender;
      this.userNickname = userNickname;
      this.userBirth = userBirth;
      this.userPhone = userPhone;
      this.userDel = userDel;
      this.userDate = userDate;
   }

   public int getUserNum() {
      return userNum;
   }
   public void setUserNum(int userNum) {
      this.userNum = userNum;
   }
   public String getUserId() {
      return userId;
   }
   public void setUserId(String userId) {
      this.userId = userId;
   }
   public String getUserPw() {
      return userPw;
   }
   public void setUserPw(String userPw) {
      this.userPw = userPw;
   }
   public String getUserName() {
      return userName;
   }
   public void setUserName(String userName) {
      this.userName = userName;
   }
   public String getUserEmail() {
      return userEmail;
   }
   public void setUserEmail(String userEmail) {
      this.userEmail = userEmail;
   }
   public char getUserGender() {
      return userGender;
   }
   public void setUserGender(char userGender) {
      this.userGender = userGender;
   }
   public String getUserNickname() {
      return userNickname;
   }
   public void setUserNickname(String userNickname) {
      this.userNickname = userNickname;
   }
   public String getUserBirth() {
      return userBirth;
   }
   public void setUserBirth(String userBirth) {
      this.userBirth = userBirth;
   }
   public String getUserPhone() {
      return userPhone;
   }
   public void setUserPhone(String userPhone) {
      this.userPhone = userPhone;
   }
   public char getUserDel() {
      return userDel;
   }
   public void setUserDel(char userDel) {
      this.userDel = userDel;
   }
   public Date getUserDate() {
      return userDate;
   }
   public void setUserDate(Date userDate) {
      this.userDate = userDate;
   }
   
   @Override
   public String toString() {
      return "MemberVO [userNum=" + userNum + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
            + ", userEmail=" + userEmail + ", userGender=" + userGender + ", userNickname=" + userNickname
            + ", userBirth=" + userBirth + ", userPhone=" + userPhone + ", userDel=" + userDel + ", userDate="
            + userDate + "]";
   }
   
}