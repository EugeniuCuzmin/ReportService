package ru.philit.bigdata.domain.reports;

import java.io.Serializable;

/**
 * Created by gennady on 25/07/17.
 */
public enum ReportStatus implements Serializable {
    in_production, ready;

    public String getStatus(){
        return this.name();
    }
}
