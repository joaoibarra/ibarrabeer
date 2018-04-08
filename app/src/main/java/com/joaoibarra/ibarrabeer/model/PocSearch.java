package com.joaoibarra.ibarrabeer.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by joaoibarra on 08/04/18.
 */

public class PocSearch {
    @SerializedName("__typename")
    String typename;
    String id;
    String status;
    String tradingName;
    String officialName;
    List<DeliveryType> deliveryTypes;
    List<PaymentMethod> paymentMethods;
    List<PocWorkDay> pocWorkDay;
    Address address;

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTradingName() {
        return tradingName;
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public List<DeliveryType> getDeliveryTypes() {
        return deliveryTypes;
    }

    public void setDeliveryTypes(List<DeliveryType> deliveryTypes) {
        this.deliveryTypes = deliveryTypes;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public List<PocWorkDay> getPocWorkDay() {
        return pocWorkDay;
    }

    public void setPocWorkDay(List<PocWorkDay> pocWorkDay) {
        this.pocWorkDay = pocWorkDay;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
