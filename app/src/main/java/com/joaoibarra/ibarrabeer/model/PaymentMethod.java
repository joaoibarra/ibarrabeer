package com.joaoibarra.ibarrabeer.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by joaoibarra on 08/04/18.
 */

public class PaymentMethod {
    @SerializedName("__typename")
    String __typename;
    String pocPaymentMethodId;
    String paymentMethodId;
    String title;
    String subtitle;
    boolean active;
}
