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
public class rdv {
    
    private int idrdv;
    private  String nomrdv;
    private int capaciteacceuil;
    private  int nbrplacedispo;
    private float prix;
    private String description;
    private String disponibilite;
    private String adresse;
    private String altitude;
    private String longitude;
    private String ville;
    private String   etat;
    private int codepostal;
   private String image_name;
   private int idrdvuser;
  

    public rdv(int idrdv, String nomrdv, int capaciteacceuil, int nbrplacedispo, float prix, String description, String disponibilite, String adresse, String altitude, String longitude, String ville, String etat, int codepostal, String image_name, int idrdvuser) {
        this.idrdv = idrdv;
        this.nomrdv = nomrdv;
        this.capaciteacceuil = capaciteacceuil;
        this.nbrplacedispo = nbrplacedispo;
        this.prix = prix;
        this.description = description;
        this.disponibilite = disponibilite;
        this.adresse = adresse;
        this.altitude = altitude;
        this.longitude = longitude;
        this.ville = ville;
        this.etat = etat;
        this.codepostal = codepostal;
        this.image_name = image_name;
        this.idrdvuser = idrdvuser;
    }

    public rdv(String nomrdv, int capaciteacceuil, int nbrplacedispo, float prix, String description, String disponibilite, String adresse, String altitude, String longitude, String ville, String etat, int codepostal, String image_name, int idrdvuser) {
        this.nomrdv = nomrdv;
        this.capaciteacceuil = capaciteacceuil;
        this.nbrplacedispo = nbrplacedispo;
        this.prix = prix;
        this.description = description;
        this.disponibilite = disponibilite;
        this.adresse = adresse;
        this.altitude = altitude;
        this.longitude = longitude;
        this.ville = ville;
        this.etat = etat;
        this.codepostal = codepostal;
        this.image_name = image_name;
        this.idrdvuser = idrdvuser;
    }

    public rdv(int idrdv, String nomrdv, int capaciteacceuil, int nbrplacedispo, float prix, String description, String disponibilite, String adresse, String ville, String etat, int codepostal, String image_name) {
        this.idrdv = idrdv;
        this.nomrdv = nomrdv;
        this.capaciteacceuil = capaciteacceuil;
        this.nbrplacedispo = nbrplacedispo;
        this.prix = prix;
        this.description = description;
        this.disponibilite = disponibilite;
        this.adresse = adresse;
        this.ville = ville;
        this.etat = etat;
        this.codepostal = codepostal;
        this.image_name = image_name;
    }

    
    
    public rdv(int idrdv, String nomrdv, int capaciteacceuil, int nbrplacedispo, float prix, String description, String disponibilite, String adresse, String altitude, String longitude, String ville, String etat, int codepostal, String image_name) {
        this.idrdv = idrdv;
        this.nomrdv = nomrdv;
        this.capaciteacceuil = capaciteacceuil;
        this.nbrplacedispo = nbrplacedispo;
        this.prix = prix;
        this.description = description;
        this.disponibilite = disponibilite;
        this.adresse = adresse;
        this.altitude = altitude;
        this.longitude = longitude;
        this.ville = ville;
        this.etat = etat;
        this.codepostal = codepostal;
        this.image_name = image_name;
    }

    
    public rdv() {
    }

    public rdv(String nomrdv, int capaciteacceuil, int nbrplacedispo, float prix, String description, String disponibilite, String adresse, String altitude, String longitude, String ville, String etat, int codepostal, String image_name) {
        this.nomrdv = nomrdv;
        this.capaciteacceuil = capaciteacceuil;
        this.nbrplacedispo = nbrplacedispo;
        this.prix = prix;
        this.description = description;
        this.disponibilite = disponibilite;
        this.adresse = adresse;
        this.altitude = altitude;
        this.longitude = longitude;
        this.ville = ville;
        this.etat = etat;
        this.codepostal = codepostal;
        this.image_name = image_name;
    }

   
   
   
   
   
   
    public int getIdrdv() {
        return idrdv;
    }

    public void setIdrdv(int idrdv) {
        this.idrdv = idrdv;
    }

    public String getNomrdv() {
        return nomrdv;
    }

    public void setNomrdv(String nomrdv) {
        this.nomrdv = nomrdv;
    }

    public int getCapaciteacceuil() {
        return capaciteacceuil;
    }

    public void setCapaciteacceuil(int capaciteacceuil) {
        this.capaciteacceuil = capaciteacceuil;
    }

    public int getNbrplacedispo() {
        return nbrplacedispo;
    }

    public void setNbrplacedispo(int nbrplacedispo) {
        this.nbrplacedispo = nbrplacedispo;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(int codepostal) {
        this.codepostal = codepostal;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public int getIdrdvuser() {
        return idrdvuser;
    }

    public void setIdrdvuser(int idrdvuser) {
        this.idrdvuser = idrdvuser;
    }

    @Override
    public String toString() {
        return "rdv{" + "idrdv=" + idrdv + ", nomrdv=" + nomrdv + ", capaciteacceuil=" + capaciteacceuil + ", nbrplacedispo=" + nbrplacedispo + ", prix=" + prix + ", description=" + description + ", disponibilite=" + disponibilite + ", adresse=" + adresse + ", altitude=" + altitude + ", longitude=" + longitude + ", ville=" + ville + ", etat=" + etat + ", codepostal=" + codepostal + ", image_name=" + image_name + ", idrdvuser=" + idrdvuser + '}';
    }
   
   

   
    
}
