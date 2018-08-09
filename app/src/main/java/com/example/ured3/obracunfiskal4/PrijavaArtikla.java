package com.example.ured3.obracunfiskal4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ured3.obracunfiskal4.data.DatabaseHelper;

public class PrijavaArtikla extends AppCompatActivity {
    EditText editNaziv,editCijena,editPDV,editZaliha,editDonos,editOstatak,editUkupno,editIznos,editProdano;
    Button btnAdd,btnView;
   DatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prijava_artikla);
        editNaziv = (EditText) findViewById(R.id.editNaziv);
        editCijena = (EditText) findViewById(R.id.editCijena);
        editPDV = (EditText) findViewById(R.id.editPDV);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        editZaliha = (EditText) findViewById(R.id.editZaliha);
        editDonos = (EditText) findViewById(R.id.editDonos);
        editUkupno = (EditText) findViewById(R.id.editUkupno);
        editOstatak = (EditText) findViewById(R.id.editOstatak);
        editProdano= (EditText) findViewById(R.id.editProdano);
        editIznos = (EditText) findViewById(R.id.editIznos);
        myDB = new DatabaseHelper(this);


        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrijavaArtikla.this,ArticlesAdapter.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NazivA = editNaziv.getText().toString();
                String CijenaA = editCijena.getText().toString();
                String PDVA = editPDV.getText().toString();
                String ZalihA = editZaliha.getText().toString();
                String DonosA = editDonos.getText().toString();
                String UkupnoA = editUkupno.getText().toString();
                String OstatakA = editOstatak.getText().toString();
                String ProdanoA = editProdano.getText().toString();
                String IznosA = editIznos.getText().toString();
                if(NazivA.length() != 0   ){
                    AddData(NazivA,CijenaA, PDVA,ZalihA,DonosA,UkupnoA,OstatakA,ProdanoA,IznosA);
                    editNaziv.setText("");
                    editCijena.setText("");
                    editPDV.setText("");
                    editZaliha.setText("");
                    editDonos.setText("");
                    editUkupno.setText("");
                    editOstatak.setText("");
                    editProdano.setText("");
                    editIznos.setText("");
                }else{
                    Toast.makeText(PrijavaArtikla.this,"You must put something in the text field!",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void AddData(String NazivA,String CijenaAr, String PDVAr, String ZalihA, String DonosA, String UkupnoA, String OstatkaA, String ProdanoA, String IznosA ){
        boolean insertData = myDB.addData(NazivA,CijenaAr,PDVAr,ZalihA,DonosA,UkupnoA,OstatkaA,ProdanoA,IznosA);

        if(insertData==true){
            Toast.makeText(PrijavaArtikla.this,"Successfully Entered Data!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(PrijavaArtikla.this,"Something went wrong :(.",Toast.LENGTH_LONG).show();
        }
    }
}
