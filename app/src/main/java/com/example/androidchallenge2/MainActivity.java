package com.example.androidchallenge2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String POST_TITLE = "POST_TITLE";
    public static final String POST_ID= "POST_ID";
    public static final String POST_CATEGORY = "POST_CATEGORY";
    public static final String POST_CONTENT = "POST_CONTENT";
    public static final String POST_TIME = "POST_TIME";

    ListView listViewPosts;
    DatabaseReference dbReference;
    final Format dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    List<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbReference = FirebaseDatabase.getInstance().getReference("post");
        listViewPosts = findViewById(R.id.postsLv);


        posts = new ArrayList<>();

        listViewPosts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Post post = posts.get(i);
                String timestamp_string = dateFormat.format(post.getDate());
                Intent intent = new Intent(getApplicationContext(), PostActivity.class);
                intent.putExtra(POST_ID,post.getId());
                intent.putExtra(POST_TITLE, post.getTitle());
                intent.putExtra(POST_CONTENT,post.getContent());
                intent.putExtra(POST_CATEGORY,post.getCategory());
                intent.putExtra(POST_TIME, timestamp_string);
                startActivity(intent);
            }
        });

    }

    protected void onStart() {
        super.onStart();
//        dbReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                posts.clear();
//                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                    Post post = postSnapshot.getValue(Post.class);
//                    posts.add(post);
//                }
//
//                PostList postAdapter = new PostList(MainActivity.this,posts);
//                listViewPosts.setAdapter(postAdapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
    }
    public void addPost(View v){
        Intent intent = new Intent(this, AddPost.class);
        startActivity(intent);
    }

    public void addCategory(View v){
        Intent intent = new Intent(this, AddCategory.class);
        startActivityForResult(intent, 2);
    }

    public class TimeStampComparator implements Comparator<Post> {
        @Override
        public int compare(Post earlypost, Post latepost) {
            return latepost.getDate().compareTo(earlypost.getDate());
        }

    }
    public void sort(View v){

    }
}