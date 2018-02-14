package com.example.u4_14_02_activitiesparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Vicente FN on 14/02/2018.
 */

/*
PASOS CREAR PARCELABLE:
1-CREAR UNA CLASE
2-IMPLEMENTAR PARCELABLE
3-IMPLMENTAR METODOS DE PARCELABLE (BOBILLA O ALT+INS)
4-CREAR UN CONSTRUCTOR CON PARCEL

 */


//IMPLEMENTAR PARCELABLE
public class Persona implements Parcelable {

    String nombre;
    int edad;
    double sueldo;

    //CREATOR
    public static final Parcelable.Creator<Persona> CREATOR = new Parcelable.Creator<Persona>(){
        public Persona createFromParcel(Parcel in){
            return new Persona(in);
        }
        public Persona[] newArray(int size){
            return new Persona[size];
        }

    };

    //FIN CREATOR

    public Persona(String nombre, int edad, double sueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }

    //Crear constructor que reciba por parametros un Parcel
    public Persona(Parcel parcel){
        readFromParcel(parcel);
        //Llamamos al método readFromParcel

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    //METODOS IMPLEMENTADOS DE LA CLASE PARCELABLE

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeInt(this.edad);
        dest.writeDouble(this.sueldo);

    }

    //Creamos metodo readFromParcel que usaremos para llamarla en el constructor parecelable

private void readFromParcel (Parcel parcel){
        this.nombre = parcel.readString();
        this.edad = parcel.readInt();
        this.sueldo = parcel.readDouble();
}


}

