package com.example.aprentisageV4.modele;

import java.io.Serializable;
import java.util.Date;

public class Profil implements Serializable {

    private static final Integer minFemme = 15; //maigre si en dessous
    private static final Integer maxFemme = 30; //gros si au dessus
    private static final Integer minHomme = 10; //maigre si en dessous
    private static final Integer maxHomme = 25; //gros si au dessus



    //propriétés
    private Date dateMesure;
    private Integer poid, taille, age, sexe;
    private float img;
    private String message;

    public Profil(Date dateMesure, Integer poid, Integer taille, Integer age, Integer sexe) {
        this.dateMesure = dateMesure;
        this.poid = poid;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.calculIMG();
        this.resultIMG();
    }

    public Integer getPoid() {
        return poid;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSexe() {
        return sexe;
    }

    public float getImg() {
        return img;
    }

    public String getMessage() {
        return message;
    }

    public Date getDateMesure() {
        return dateMesure;
    }

    private void calculIMG(){
        float tailleM = ((float)taille)/100;
        this.img = (float)((1.2*poid / (tailleM*tailleM)) +  (0.23*age) - (10.83*sexe) - 5.4);
    }

    private void resultIMG(){
        Integer min, max;
        if(sexe==0){ //c'est une femme
            min = minFemme;
            max = maxFemme;
        }else{
            min = minHomme;
            max = maxHomme;
        }


        //message cresspondant
        if(img<min){
            message = "trop faible";
        }else if (img>max){
            message = "trop gros";
        }else{
            message = "normal";
        }
    }
}
