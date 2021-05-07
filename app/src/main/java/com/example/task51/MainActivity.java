package com.example.task51;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView, recyclerView2;
    RecyclerView.LayoutManager mLayoutManager;
    int[] image = new int[]{R.drawable.great_barrier_reef,
            R.drawable.great_ocean_road,
            R.drawable.bondi_beach,
            R.drawable.uluru,
            R.drawable.sydney_opera_house,
            R.drawable.kakadu_national_park,
            R.drawable.twelve_apostles,
            R.drawable.whitehaven_beach,
            R.drawable.freycinet_national_park,
            R.drawable.mona};
    String title[], content[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerView_vertical);
        recyclerView2 = findViewById(R.id.RecyclerView_horizontal);
        title = getResources().getStringArray(R.array.title);
        content = getResources().getStringArray(R.array.content);

        MyAdapter myAdapter = new MyAdapter(this,title,content,image);
        recyclerView.setAdapter(myAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        MyAdapter_one myAdapter_one = new MyAdapter_one(this,image);
        recyclerView2.setAdapter(myAdapter_one);
        LinearLayoutManager managers = new LinearLayoutManager(this);
        managers.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(managers);

    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        String Title_data[], Content_data[];
        int images[];
        Context context;

        class MyViewHolder extends RecyclerView.ViewHolder{

            View itemView;
            TextView title, content,textView_title,textView_content;
            ImageView images,imageView_one;

            public MyViewHolder(View v){
                super(v);
                itemView = v;

                title = itemView.findViewById(R.id.title);
                content = itemView.findViewById(R.id.content);
                images = itemView.findViewById(R.id.images);
                imageView_one = findViewById(R.id.imageView_one);
                textView_content = findViewById(R.id.textView_content);
                textView_title = findViewById(R.id.textView_title);

            }
        }

        public MyAdapter(Context ct, String title[], String content[], int image[]){
            context = ct;
            Title_data = title;
            Content_data =content;
            images = image;
        }

        @NonNull
        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item, parent,false);
             MyViewHolder MyVH = new MyViewHolder(itemView);
            return MyVH;
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
            holder.title.setText(title[position]);
            holder.content.setText(content[position]);
            holder.images.setImageResource(images[position]);

            holder.images.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    Fragment1 fragment1 = new Fragment1();
                    transaction.replace(R.id.container, fragment1);

                    Bundle bundle = new Bundle();
                    bundle.putString("title", title[position]);
                    bundle.putString("content", content[position]);
                    bundle.putInt("image", images[position]);
                    fragment1.setArguments(bundle);

                    transaction.commit();

                }
            });
        }

        @Override
        public int getItemCount() {
            return images.length;
        }
    }


    private class MyAdapter_one extends RecyclerView.Adapter<MyAdapter_one.MyViewHolder>{

        int images[];
        Context context;
        class MyViewHolder extends RecyclerView.ViewHolder{

            View item;
            ImageView images,image2,image3;

            public MyViewHolder(View v){
                super(v);
                item = v;
                images = item.findViewById(R.id.image2);

            }

        }

        public MyAdapter_one(Context conText,int image[]){
            context = conText;
            images = image;
        }

        @NonNull
        @Override
        public MyAdapter_one.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View item = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item2, parent,false);
            MyViewHolder MyVH1 = new MyViewHolder(item);
            return MyVH1;
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter_one.MyViewHolder holder, int position) {
            holder.images.setImageResource(images[position]);
        }

        @Override
        public int getItemCount() {
            return images.length;
        }
    }
}