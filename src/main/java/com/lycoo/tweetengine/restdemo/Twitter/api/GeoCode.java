package com.lycoo.tweetengine.restdemo.Twitter.api;

public class GeoCode {

    private double latitude;
    private double longitude;
    private int radius;
    private Unit unit;

    /**
     * Creates GeoCode object with the default unit of measure is Unit.KILOMETER
     *
     * @param latitude the location's latitude
     * @param longitude the location's longitude
     * @param radius the radius of the area to cover by this location
     */
    public GeoCode(double latitude, double longitude, int radius) {
        this(latitude, longitude, radius, Unit.KILOMETER);
    }

    public GeoCode(double latitude, double longitude, int radius, Unit unit) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.latitude).append(",")
                .append(this.longitude).append(",")
                .append(this.radius)
                .append(this.unit.toString())
                .toString();
    }

    public enum Unit {
        KILOMETER("km"), MILE("mi");

        private String unit;

        private Unit(String unit) {
            this.unit = unit;
        }

        @Override
        public String toString() {
            return this.unit;
        }
    }

}
