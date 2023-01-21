package com.example.project_akhir_bp3;

import android.os.Parcel;
import android.os.Parcelable;

public class Account implements Parcelable {

    private String id;
    private String username;
    private String email;
    private String password;

    public Account(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.username);
        dest.writeString(this.email);
        dest.writeString(this.password);
    }

    protected Account(Parcel parcel){
        this.id = parcel.readString();
        this.username = parcel.readString();
        this.email = parcel.readString();
        this.password = parcel.readString();
    }

    public static final Parcelable.Creator<Account> CREATOR = new Parcelable.Creator<Account>(){
        public Account createFromParcel(Parcel parcel){
            return new Account(parcel);
        }
      public Account[] newArray(int size){
            return new Account[size];
      }
    };
}
