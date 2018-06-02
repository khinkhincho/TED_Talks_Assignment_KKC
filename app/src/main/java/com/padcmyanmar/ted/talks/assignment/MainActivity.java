package com.padcmyanmar.ted.talks.assignment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String []author={"Author 1","Author 2","Author 3"};
    String []title={"Title 1","Title 2","Title 3"};
    String []time={"10:11","11:14","11:30"};
    int [] images={R.drawable.index,R.drawable.index,R.drawable.index};
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);// default
        setContentView(R.layout.activity_main);// default

        lv= (ListView) findViewById(R.id.idListView);
        MyAdapter adapter=new MyAdapter(getApplicationContext(), author, title, time, images);
        lv.setAdapter(adapter);
    }
}

class MyAdapter extends ArrayAdapter {

    int[] imageArray;
    String[] authorArray;
    String[] titleArray;
    String[] timeArray;

    public MyAdapter(Context context, String[] strAuthor, String[] strTitle, String[] strTime, int[] image)
    {
        super(context,R.layout.main_list_item, R.id.txtTitle, strTitle);
        this.imageArray=image;
        this.authorArray=strAuthor;
        this.titleArray=strTitle;
        this.timeArray=strTime;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.main_list_item, parent,false);

        ImageView myImage=(ImageView) row.findViewById(R.id.imageView);
        TextView myAuthor=(TextView) row.findViewById(R.id.txtAuthor);
        TextView myTitle=(TextView) row.findViewById(R.id.txtTitle);
        TextView myTime=(TextView) row.findViewById(R.id.txtTime);

        myImage.setImageResource(imageArray[position]);
        myAuthor.setText(authorArray[position]);
        myTitle.setText(titleArray[position]);
        myTime.setText(timeArray[position]);

        //return super.getView(position, convertView, parent);
        return row;
    }
}
