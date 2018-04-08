package com.joaoibarra.ibarrabeer.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by joaoibarra on 08/04/18.
 */

public class PocWorkDay {
    @SerializedName("__typename")
    String typename;
    String weekDay;
    boolean active;
    List<WorkingInterval> workingInterval;
}
