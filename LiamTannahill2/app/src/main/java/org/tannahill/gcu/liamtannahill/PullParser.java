//Student Name:Liam Tannahill
//Student ID: 200702799
package org.tannahill.gcu.liamtannahill;


import java.io.Serializable;

public class PullParser implements Serializable {
    private String title;
    private String description;
    private String link;
    private String pubDate;
    private String category;
    private String geolat;
    private String geolong;
    private String depth;
    private String location;
    private String magnitude;

    public PullParser() {
        title = "";
        description = "";
        link = "";
        pubDate = "";
        category = "";
        geolat = "";
        geolong = "";
    }

    public PullParser(String atitle, String adescription, String alink, String apubDate, String acategory, String ageolat, String ageolong) {
        title = atitle;
        description = adescription;
        link = alink;
        pubDate = apubDate;
        category = acategory;
        geolat = ageolat;
        geolong = ageolong;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String atitle) {
        title = atitle;
    }

    public String getDescription() {
        return description;
    }

    //Split descrpition elements based every time a ";" or ":" based on the XML formatt.
    public void setDescription(String adescription) {
        description = adescription;
        String[] split = adescription.split(";|: ");
        for (int i = 0; i < split.length; i++) {
            if (i == 3) {
                this.setLocation(split[i].trim());
            } else if (i == 7) {
                this.setDepth(split[i].trim());
            } else if (i == 9) {
                this.setMagnitude(split[i].trim());
            }
        }
    }

    public String toString() {
        String temp;

        temp = title + " " + description + " " + link + " " + pubDate + " " + category + " " + geolat + " " + geolong;

        return temp;
    }

    //Getters and Setters for work beyond initial list.
    public String getLink() {
        return link;
    }

    public void setLink(String alink) {
        link = alink;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String apubDate) {
        pubDate = apubDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String acategory) {
        category = acategory;
    }

    public String getLatitude() {
        return geolat;
    }

    public void setLatitude(String ageolat) {
        geolat = ageolat;
    }

    public String getLongitude() {
        return geolong;
    }

    public void setLongitude(String ageolong) {
        geolong = ageolong;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDepth() {
        return depth;
    }

    //set Depth and remove the "km" unit that is present on the XML, this allows code
    //in the search class to loop through to determmine shallowest and deepest quakes.
    public void setDepth(String aDepth) {
        depth = aDepth.replace("km", "");
    }


    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }
}
