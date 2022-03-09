package com.yildizan.newsfrom.api.entity;

public enum LocationType {

    COUNTRY(null),
    CITY(COUNTRY),
    COUNTY(CITY),
    VILLAGE(COUNTY),
    STATE(COUNTRY),
    REGION(COUNTRY),
    CAPITAL(COUNTRY);

    public final LocationType parent;

    LocationType(LocationType parent) {
        this.parent = parent;
    }

}
