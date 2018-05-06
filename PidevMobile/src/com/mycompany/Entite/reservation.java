/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Date;

/**
 *
 * @author USER
 */
public class reservation {
     private int idreservation;
    
    private int idreservationrdv;
    
    private Date datedebut;
    
    private Date datefin;
    private int nbrplacereserver;
   
private int idguest;    

    public reservation() {
    }

    public reservation(int idreservation, int idreservationrdv, Date datedebut, Date datefin, int idguest) {
        this.idreservation = idreservation;
        this.idreservationrdv = idreservationrdv;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.idguest = idguest;
    }

    public reservation(Date datedebut, Date datefin, int nbrplacereserver) {
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.nbrplacereserver = nbrplacereserver;
    }

    public reservation(Date datedebut, Date datefin) {
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public reservation(int idreservationrdv, Date datedebut, Date datefin, int idguest) {
        this.idreservationrdv = idreservationrdv;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.idguest = idguest;
    }

   





    public int getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(int idreservation) {
        this.idreservation = idreservation;
    }

    public int getIdreservationrdv() {
        return idreservationrdv;
    }

    public void setIdreservationrdv(int idreservationrdv) {
        this.idreservationrdv = idreservationrdv;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public int getIdguest() {
        return idguest;
    }

    public void setIdguest(int idguest) {
        this.idguest = idguest;
    }

    public int getNbrplacereserver() {
        return nbrplacereserver;
    }

    public void setNbrplacereserver(int nbrplacereserver) {
        this.nbrplacereserver = nbrplacereserver;
    }

   
    
}
