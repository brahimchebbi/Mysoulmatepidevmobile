/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Enum;

/**
 *
 * @author CorpseRoot
 */
public enum TypeQuestion {
    
    QuestVieCouple("QuestVieCouple",1), QuestSociale("QuestSociale",2), QuestPersonalite("QuestPersonalite",3) , QuestPhysique("QuestPhysique",4);
    
    private String NomDeType;
    private int TypeID;

    public String getNomDeType() {
        return NomDeType;
    }

    public void setNomDeType(String NomDeType) {
        this.NomDeType = NomDeType;
    }

    public int getTypeID() {
        return TypeID;
    }

    public void setTypeID(int TypeID) {
        this.TypeID = TypeID;
    }
    
    

    private TypeQuestion(String NomDeType, int TypeID)
    {
        this.NomDeType = NomDeType;
        this.TypeID = TypeID;
    }
    
    
    
}
