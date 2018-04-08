package com.joaoibarra.ibarrabeer.model.search;

import com.google.gson.annotations.SerializedName;

/**
 * Created by joaoibarra on 08/04/18.
 */

public class SearchPoc {
    String algorithm;

    @SerializedName("lat")
    Double latitude;

    @SerializedName("long")
    Double longitude;

    String now;

    public String getAlgorithm() {
        return algorithm;
    }

    public SearchPoc setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public SearchPoc setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public SearchPoc setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getNow() {
        return now;
    }

    public SearchPoc setNow(String now) {
        this.now = now;
        return this;
    }
}
