/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import com.mycompany.Enum.TypeQuestion;

/**
 *
 * @author CorpseRoot
 */
public class Question {
    
    private int ID;
    private String Question;
    private String Type;
    private String Reponse1;
    private String Reponse2;
    private String Reponse3;
    private int ScoreRep1;
    private int ScoreRep2;
    private int ScoreRep3;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getReponse1() {
        return Reponse1;
    }

    public void setReponse1(String Reponse1) {
        this.Reponse1 = Reponse1;
    }

    public String getReponse2() {
        return Reponse2;
    }

    public void setReponse2(String Reponse2) {
        this.Reponse2 = Reponse2;
    }

    public String getReponse3() {
        return Reponse3;
    }

    public void setReponse3(String Reponse3) {
        this.Reponse3 = Reponse3;
    }

    public int getScoreRep1() {
        return ScoreRep1;
    }

    public void setScoreRep1(int ScoreRep1) {
        this.ScoreRep1 = ScoreRep1;
    }

    public int getScoreRep2() {
        return ScoreRep2;
    }

    public void setScoreRep2(int ScoreRep2) {
        this.ScoreRep2 = ScoreRep2;
    }

    public int getScoreRep3() {
        return ScoreRep3;
    }

    public void setScoreRep3(int ScoreRep3) {
        this.ScoreRep3 = ScoreRep3;
    }

    
    public Question() 
    {
        this.Question = "";
        this.Type = null;
        this.Reponse1 = "";
        this.Reponse2 = "";
        this.Reponse3 = "";
        this.ScoreRep1 = 0;
        this.ScoreRep2 = 0;
        this.ScoreRep3 = 0;
    }

    public Question(String Question, String Type, String Reponse1, String Reponse2, String Reponse3, int ScoreRep1, int ScoreRep2, int ScoreRep3)
    {
        this.Question = Question;
        this.Type = Type;
        this.Reponse1 = Reponse1;
        this.Reponse2 = Reponse2;
        this.Reponse3 = Reponse3;
        this.ScoreRep1 = ScoreRep1;
        this.ScoreRep2 = ScoreRep2;
        this.ScoreRep3 = ScoreRep3;
    }

    @Override
    public String toString() {
        return "Question{" + "ID=" + ID + ", Question=" + Question + ", Type=" + Type + ", Reponse1=" + Reponse1 + ", Reponse2=" + Reponse2 + ", Reponse3=" + Reponse3 + ", ScoreRep1=" + ScoreRep1 + ", ScoreRep2=" + ScoreRep2 + ", ScoreRep3=" + ScoreRep3 + '}';
    }
    
    
    
            
    
    
}
