package com.codekam.javaiterop;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private int age;

    private List<Address> addresses=new ArrayList<Address>();

    @NotNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        //return "$firstName $lastName";
        // UserExtensionsKt = UserExtensions.kt file
        //return UserExtensionsKt.getFullName(this);
        // UserExtensions => @file:JvmName("UserExtensions")
        return UserExtensions.getFullName(this)+" - Addresses: "+
                addresses.size()
                +" \n "+allAddresses();
    }

    @Nullable
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String allAddresses(){
        StringBuilder builder= new StringBuilder();
        for(Address address:addresses){
            builder.append(address.getAddressType().name() +" address:\n");
            builder.append(LabelPrinterKt.labelFor(this,address.getAddressType()));
        }
        return builder.toString();
    }
}
