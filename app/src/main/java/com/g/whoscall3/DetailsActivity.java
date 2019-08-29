package com.g.whoscall3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
     public ListView listView;
    // private ValueEventListener valueEventListener;
     private  DatabaseReference databaseReference;

     private CustomAdapter customAdapter;
     public List<Person> personList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        databaseReference = FirebaseDatabase.getInstance().getReference("Person");


        Toast.makeText(getApplicationContext(),"Hello   "+personList.size(),Toast.LENGTH_SHORT).show();
       // ArrayAdapter<Person> customAdapter = new CustomAdapter(getApplicationContext(),R.layout.sample_layout,personList);
       //listView = findViewById(R.id.listViewID);

    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {



              for(DataSnapshot personData:dataSnapshot.getChildren()){

                 Person person= personData.getValue(Person.class);
                 personList.add(person);

                 Log.d("Person Name",""+person.getPersonName());


              }
                Log.d("Person Count",""+personList.size());
                listView = findViewById(R.id.listViewID);
            ArrayAdapter<Person> customAdapter = new CustomAdapter(getApplicationContext(),personList,DetailsActivity.this);
            listView.setAdapter(customAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Error","Error");
                System.out.println("ERROR");
            }
        });


        super.onStart();
    }



}
