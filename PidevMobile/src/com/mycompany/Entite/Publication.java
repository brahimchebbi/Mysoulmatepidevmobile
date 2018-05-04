/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author USER
 */
public class Publication {
    
    private int id_pub ;
    protected String text;
    protected String image;
    private String video;
    private int id_user ;
    protected String adresse;
    private String altitude;

    

    private String longitude;
    
    public Publication(String text, String image, String video, int id_user) {
        this.text = text;
        this.image = image;
        this.video = video;
        this.id_user = id_user;
    }

    public Publication(int id_pub, String text, String image, String video, String adresse, String altitude, String longitude) {
        this.id_pub = id_pub;
        this.text = text;
        this.image = image;
        this.video = video;
        this.adresse = adresse;
        this.altitude = altitude;
        this.longitude = longitude;
    }
    

    public Publication(String text, String image, String video, int id_user, String adresse, String altitude, String longitude) {
        this.text = text;
        this.image = image;
        this.video = video;
        this.id_user = id_user;
        this.adresse = adresse;
        this.altitude = altitude;
        this.longitude = longitude;
    }

    public Publication(String text, String image, String video, String adresse, String altitude, String longitude) {
        this.text = text;
        this.image = image;
        this.video = video;
        this.adresse = adresse;
        this.altitude = altitude;
        this.longitude = longitude;
    }

    public Publication(String text, String image) {
        this.text = text;
        this.image = image;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Publication(int id_pub, String text, String image, String video) {
        this.id_pub = id_pub;
        this.text = text;
        this.image = image;
        this.video = video;
    }

    public Publication(String text, String image, String video) {
        this.text = text;
        this.image = image;
        this.video = video;
    }

    public Publication() {
    }

    public Publication(String text) {
        this.text = text;
    }

    
    
    

    public int getId_pub() {
        return id_pub;
    }

    public void setId_pub(int id_pub) {
        this.id_pub = id_pub;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Publication{" + "id_pub=" + id_pub + ", text=" + text + ", image=" + image + ", adresse=" + adresse + '}';
    }

   
    
    
    
    

    
}
