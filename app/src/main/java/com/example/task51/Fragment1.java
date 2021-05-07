package com.example.task51;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Fragment1 extends Fragment {

    ImageView imageView_one;
    TextView textView_title,textView_content;
    String title, content,image;
    Intent intent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View mainView = inflater.inflate(R.layout.fragment_1, container, false);


        imageView_one = mainView.findViewById(R.id.imageView_one);
        textView_content = mainView.findViewById(R.id.textView_content);
        textView_title = mainView.findViewById(R.id.textView_title);

        Bundle bundle = getArguments();

        title = bundle.getString("title");
        content = bundle.getString("content");
        imageView_one.setImageResource(bundle.getInt("image"));
        textView_title.setText(title);
        textView_content.setText(content);

        imageView_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });

        return mainView;
    }

}