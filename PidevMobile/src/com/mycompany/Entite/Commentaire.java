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
public class Commentaire {
    
    private int id ;
    private String commentaire;
    private int idUser;
    private int idPub;
    private int signalercount;

    public Commentaire(int id, String commentaire, int idUser, int idPub) {
        this.id = id;
        this.commentaire = commentaire;
        this.idUser = idUser;
        this.idPub = idPub;
    }

    public Commentaire(String commentaire, int idPub) {
        this.commentaire = commentaire;
        this.idPub = idPub;
    }

    public Commentaire() {
    }

    
    public Commentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Commentaire(String commentaire, int idUser, int idPub) {
        this.commentaire = commentaire;
        this.idUser = idUser;
        this.idPub = idPub;
    }

    public Commentaire(int aInt, String string) {
    }

    public int getSignalercount() {
        return signalercount;
    }

    public void setSignalercount(int signalercount) {
        this.signalercount = signalercount;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPub() {
        return idPub;
    }

    public void setIdPub(int idPub) {
        this.idPub = idPub;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", commentaire=" + commentaire + '}';
    }

    
    
    
    
}
