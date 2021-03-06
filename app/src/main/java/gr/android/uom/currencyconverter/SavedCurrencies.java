package gr.android.uom.currencyconverter;

import android.content.Intent;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import static com.facebook.FacebookSdk.getApplicationContext;


public class SavedCurrencies extends AppCompatActivity {
    private double rate;
    private String curr1,curr2;
    private String date;
    FirebaseFirestore fs;
    DocumentReference dr;
    CollectionReference dr1;
    ArrayList<String> data;
    public SavedCurrencies(double aRate,String aCurr1,String aCurr2,String aDate){
        rate = aRate;
        curr1 = aCurr1;
        curr2 = aCurr2;
        date = aDate;


    }
    public void Save(SavedCurrencies aSave){
        Log.d("edww", "Save: "+FirebaseAuth.getInstance().getCurrentUser().getEmail());
        fs = FirebaseFirestore.getInstance();
        dr1 = fs.collection(FirebaseAuth.getInstance().getCurrentUser().getEmail());


        dr1= fs.collection(FirebaseAuth.getInstance().getCurrentUser().getEmail());

        dr= fs.collection("Saves").document(FirebaseAuth.getInstance().getCurrentUser().getEmail());
        HashMap<String,String> hs = new HashMap<>();

        hs.put("SavedCurrency","  "+aSave.curr1 + " to " + aSave.curr2 +" " +"Rate: "+aSave.rate+"\n "+ aSave.date);
        hs.put("Details","Saving Details");



        dr1.add(hs);

    }



}
