package com.g.whoscall3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Person> {


    private final LayoutInflater inflater;
    private Activity context;
    private List<Person> personList;

    public CustomAdapter(Context context,List<Person> personList, Activity context1) {
        super(context, R.layout.sample_layout, personList);
        this.context = context1;
        this.personList = personList;
        inflater = (LayoutInflater)context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @NonNull
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        View view=convertView;
        if(convertView==null)


        view = inflater.inflate(R.layout.sample_layout,null,true);
        Person person = personList.get(position);
        EditText t1 = (EditText)view.findViewById(R.id.nameTextViewId);
        EditText t2 = (EditText)view.findViewById(R.id.numberTextViewID);
        EditText t3 = (EditText)view.findViewById(R.id.ageTextViewID);
        EditText t4 = (EditText)view.findViewById(R.id.genderTextViewID);

        t1.setText(personList.get(position).getPersonName());
        t2.setText(personList.get(position).getPersonNumberId());
        t3.setText(personList.get(position).getPersonage());
        t4.setText(personList.get(position).getPersonGender());

        return view;
    }
}
