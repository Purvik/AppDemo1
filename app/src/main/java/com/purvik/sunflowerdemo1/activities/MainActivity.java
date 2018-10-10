package com.purvik.sunflowerdemo1.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.purvik.sunflowerdemo1.R;
import com.purvik.sunflowerdemo1.adapters.ItemListAddapter;
import com.purvik.sunflowerdemo1.singleton.SingleItem;
import com.purvik.sunflowerdemo1.sqlite.DBHandler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ItemListAddapter itemListAddapter;

    EditText editText;
    TextView tvDisplay;
    Button btnSubmit;

    DBHandler db;
    List<SingleItem> singleItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHandler(this);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        singleItemList = new ArrayList<>();

        singleItemList = db.getAllItemList();
        itemListAddapter = new ItemListAddapter(singleItemList);
        recyclerView.setAdapter(itemListAddapter);

        tvDisplay = findViewById(R.id.tvDisplay);
        btnSubmit = findViewById(R.id.btnSubmit);
        editText = findViewById(R.id.input);


        //loadRecyclerView();


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editText.getText().toString().trim().length() != 0) {

                    int item = Integer.parseInt(editText.getText().toString());

                    db.addNewItem(new SingleItem(item));

                    Toast.makeText(getApplicationContext(), "New Item Added", Toast.LENGTH_LONG).show();
                    singleItemList = db.getAllItemList();
                    itemListAddapter.addItemList(singleItemList);
                    editText.setText("");
                    // itemListAddapter.notifyDataSetChanged();

                }

            }
        });
    }

    private void loadRecyclerView() {

        if (singleItemList.size() == 0) {
            Toast.makeText(getApplicationContext(), "List is Empty", Toast.LENGTH_LONG).show();
        } else {

        }


    }
}
