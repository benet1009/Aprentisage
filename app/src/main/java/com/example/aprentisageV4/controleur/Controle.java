package com.example.aprentisageV4.controleur;

import android.content.Context;

import com.example.aprentisageV4.modele.AccesLocal;
import com.example.aprentisageV4.modele.Profil;
import com.example.aprentisageV4.outils.Serializer;

import java.util.Date;

public class Controle {
    private static Controle instance = null;
    private static Profil profil;
    private static String nomFic = "saveprofil";
    private static AccesLocal accesLocal;

    /**
     * constructeur priver
     */
    private Controle(){
        super();
    }

    /**
     * création de l'instance
     * @return
     */
    public static final Controle getInstance(Context contexte){
        if(Controle.instance == null) {
            Controle.instance = new Controle();
            accesLocal = new AccesLocal(contexte);
            profil = accesLocal.recupDernier();
//            recupSerialize(contexte);
        }
        return Controle.instance;
    }

    /**
     * Création de profil
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1 pour un homme 0 pour une femme
     */
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe, Context contexte){
        profil = new Profil(new Date(), poids, taille, age, sexe);
        accesLocal.ajout(profil);
//        Serializer.serialize(nomFic, profil, contexte);
    }

    /**
     * recupération IMG
     * @return img
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     * recupération Message
     * @return message
     */
    public String getMessage(){
        return profil.getMessage();
    }

    /**
     * récupération de l'objet serialisé (le profil)
     * @param contexte
     */
    private static void recupSerialize(Context contexte){
        profil = (Profil)Serializer.deSerialize(nomFic, contexte);
    }

    public Integer getPoids(){
        if (profil==null){
            return null;
        }else{
            return profil.getPoid();
        }
    }

    public Integer getAge(){
        if (profil==null){
            return null;
        }else{
            return profil.getAge();
        }
    }

    public Integer getSexe(){
        if (profil==null){
            return null;
        }else{
            return profil.getSexe();
        }
    }

    public Integer getTaille(){
        if (profil==null){
            return null;
        }else{
            return profil.getTaille();
        }
    }
}
