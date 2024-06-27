package org.x3codes.sportsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private RecyclerView recyclerView;

    private List<Sport> sportList;

    private SportAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        sportList = new ArrayList<>();

        sportList.add(new Sport("Football", R.drawable.football));
        sportList.add(new Sport("Basketball", R.drawable.basketball));
        sportList.add(new Sport("VolleyBall", R.drawable.volley));
        sportList.add(new Sport("Tennis", R.drawable.tennis));
        sportList.add(new Sport("Ping Pong", R.drawable.ping));

        adapter = new SportAdapter(sportList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

        adapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
        Toast.makeText(
            this,
            "Item Selected: " + sportList.get(position).getSportName(),
            Toast.LENGTH_SHORT
        ).show();
    }
}