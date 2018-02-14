package com.example.u4_14_02_activitiesparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String EXTRA_PERSONA = "PERSONA";
    EditText etNombre, etEdad, etSueldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText)findViewById(R.id.mainEtNombre);
        etEdad = (EditText)findViewById(R.id.mainEtEdad);
        etSueldo = (EditText)findViewById(R.id.mainEtSueldo);





    }//FIN ON CREATE


    public void MainClickAceptar (View v){

        String nombre = etNombre.getText().toString();
        String cajaedad = etEdad.getText().toString();
        String cajasueldo = etSueldo.getText().toString();

        if (nombre.equals("")||cajaedad.equals("")||cajasueldo.equals("")){
            Toast.makeText(getApplicationContext(),"Debes rellenar los campos",Toast.LENGTH_LONG).show();
        }else{
            int edad = Integer.parseInt(cajaedad);
            double sueldo = Double.parseDouble(cajasueldo);
            //Creamos el objeto tipo persona con los valores recogidos del formulario
            Persona persona = new Persona(nombre,edad,sueldo);
            //Creamos el objeto Intent para enviar nuestra persona a otra activity
            Intent i=new Intent(getApplicationContext(),PersonaActivity.class);
            //Añadimos el objeto Persona que queremos enviar al activity de destino
            i.putExtra(EXTRA_PERSONA, persona);
            //Iniciamos el nuevo activiti
            startActivity(i);

        }

    }






}//FIN MAINACTIVITY
