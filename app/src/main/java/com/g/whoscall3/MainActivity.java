package com.g.whoscall3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class  MainActivity extends AppCompatActivity {

     Button saveDataButton, loadDataButton;
     EditText nameEditText, numberEditText, ageEditText, genderEditText;
     DatabaseReference databaseSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseSave= FirebaseDatabase.getInstance().getReference("Person");

        saveDataButton = (Button) findViewById(R.id.saveDataButtonID);
        loadDataButton = (Button) findViewById(R.id.loadDataButtonID);
        nameEditText = (EditText) findViewById(R.id.nameID);
        numberEditText = (EditText) findViewById(R.id.numberID);
        ageEditText = (EditText) findViewById(R.id.ageId);
        genderEditText = (EditText) findViewById(R.id.genderID);

        loadDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(intent);
            }
        });

        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
saveData();
            }
        });

    }
    public void saveData()
    {
        String name = nameEditText.getText().toString().trim();
        String number = numberEditText.getText().toString().trim();
        String age = ageEditText.getText().toString().trim();
        String gender = genderEditText.getText().toString().trim();

        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(number) && !TextUtils.isEmpty(age) && !TextUtils.isEmpty(gender)){

            String id=databaseSave.push().getKey();
            Person person=new Person(id,name,number,gender,age);
            databaseSave.child(id).setValue(person);
            Toast.makeText(this,"Person Added",Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(this,"Please fill all option",Toast.LENGTH_SHORT).show();
        }


    }

    public static class CustomAdapter extends ArrayAdapter<Person> {
        private Activity context;
        private List<Person> personList;

        private CustomAdapter( Activity context,  List<Person> personList) {
            super(context, R.layout.sample_layout, personList);
            this.context = context;

        }

        @NonNull
        @Override
        public View getView(int position,  View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = context.getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.sample_layout,null,true);
            Person  Person = personList.get(position);
            TextView t1 = view.findViewById(R.id.nameTextViewId);
            TextView t2 = view.findViewById(R.id.numberTextViewID);
            TextView t3 = view.findViewById(R.id.ageTextViewID);
            TextView t4 = view.findViewById(R.id.genderTextViewID);

            return view;
        }
    }
}

