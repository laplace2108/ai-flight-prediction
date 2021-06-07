
package com.middleware.nationalweatherservices.station.observation.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WindGust {

    @SerializedName("value")
    @Expose
    private Object value;
    @SerializedName("unitCode")
    @Expose
    private String unitCode;
    @SerializedName("qualityControl")
    @Expose
    private String qualityControl;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getQualityControl() {
        return qualityControl;
    }

    public void setQualityControl(String qualityControl) {
        this.qualityControl = qualityControl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(WindGust.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("value");
        sb.append('=');
        sb.append(((this.value == null)?"<null>":this.value));
        sb.append(',');
        sb.append("unitCode");
        sb.append('=');
        sb.append(((this.unitCode == null)?"<null>":this.unitCode));
        sb.append(',');
        sb.append("qualityControl");
        sb.append('=');
        sb.append(((this.qualityControl == null)?"<null>":this.qualityControl));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
