/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author CorpseRoot
 */
public class Client {
    
    private int ID;
    private String Nom;
    private int Age;
    private String Sexe;
    private String Mail;
    private String Adresse;
    private String Telephone;
    private String MDP;
    private int Etat;
    private String Verifié;
    private String IP;
    private String Photo;
    private int PourcentagePhy;
    private int PourcentagePerso;
    private int PourcentageSoc;
    private int PourcentageVieC;

    @Override
    public String toString() {
        return "Client{" + "ID=" + ID + ", Nom=" + Nom + ", Age=" + Age + ", Sexe=" + Sexe + ", Mail=" + Mail + ", Adresse=" + Adresse + ", Telephone=" + Telephone + ", MDP=" + MDP + ", Etat=" + Etat + ", Verifi\u00e9=" + Verifié + ", IP=" + IP + ", Photo=" + Photo + ", PourcentagePhy=" + PourcentagePhy + ", PourcentagePerso=" + PourcentagePerso + ", PourcentageSoc=" + PourcentageSoc + ", PourcentageVieC=" + PourcentageVieC + '}';
    }



    public Client() {
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public String getMDP() {
        return MDP;
    }

    public void setMDP(String MDP) {
        this.MDP = MDP;
    }

    public int getEtat() {
        return Etat;
    }

    public void setEtat(int Etat) {
        this.Etat = Etat;
    }

    public String getVerifié() {
        return Verifié;
    }

    public void setVerifié(String Verifié) {
        this.Verifié = Verifié;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    
    

    public int getPourcentagePhy() {
        return PourcentagePhy;
    }

    public void setPourcentagePhy(int PourcentagePhy) {
        this.PourcentagePhy = PourcentagePhy;
    }

    public int getPourcentagePerso() {
        return PourcentagePerso;
    }

    public void setPourcentagePerso(int PourcentagePerso) {
        this.PourcentagePerso = PourcentagePerso;
    }

    public int getPourcentageSoc() {
        return PourcentageSoc;
    }

    public void setPourcentageSoc(int PourcentageSoc) {
        this.PourcentageSoc = PourcentageSoc;
    }

    public int getPourcentageVieC() {
        return PourcentageVieC;
    }

    public void setPourcentageVieC(int PourcentageVieC) {
        this.PourcentageVieC = PourcentageVieC;
    }
    

    
    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }
    
    
    
}
