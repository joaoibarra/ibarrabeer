package com.joaoibarra.ibarrabeer.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by joaoibarra on 08/04/18.
 */

public class WorkingInterval {
    @SerializedName("__typename")
    String typename;
    String openingTime;
    String closingTime;
}
