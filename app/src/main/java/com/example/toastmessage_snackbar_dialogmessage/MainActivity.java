package com.example.toastmessage_snackbar_dialogmessage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView result;

    Button ok1;
    Button ok2;

    Button ok3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ok1 = findViewById(R.id.okButton1);
        ok2 = findViewById(R.id.okButton2);
        ok3 = findViewById(R.id.okButton3);

        //for SnackBar we need to find the linear layout that's why

        linearLayout = findViewById(R.id.linear);

        //textview
        result = findViewById(R.id.textViewResult);




//Toast Message

        //Here we set on clickListener on ok Button because when we click on Ok Button it the Toast Message will be Pop-up
        ok1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Set Toast message
                Toast.makeText(getApplicationContext(),"This is Toast Message",Toast.LENGTH_SHORT).show();
            }
        });


//SnackBar

        ok2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SnackBar
                Snackbar.make(linearLayout,"This is SnackBar message",Snackbar.LENGTH_INDEFINITE).setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
            }
        });

//Dialog Message

        ok3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //functionShowDialogMessage
//type this and make methods from it.
                showDialogMessage();
            }
        });
    }
    //method 
    private void showDialogMessage() {

        AlertDialog.Builder alertDialog  = new AlertDialog.Builder(this);
        alertDialog.setTitle("Delete")
                .setMessage("Do you want to Delete Text ?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();

                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        result.setText("Text will we Deleted");

                    }
                }).show();
        alertDialog.create();

        
    }
}