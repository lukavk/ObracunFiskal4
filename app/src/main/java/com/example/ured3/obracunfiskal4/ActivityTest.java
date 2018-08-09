package com.example.ured3.obracunfiskal4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.ured3.obracunfiskal4.data.DatabaseHelper;

import java.util.List;

public class ActivityTest extends AppCompatActivity implements ArticlesAdapter.ArticlesListener {

    private DatabaseHelper myDB;

    private RecyclerView mArticlesRecyclerView;
    private ArticlesAdapter mArticlesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

        mArticlesRecyclerView = findViewById(R.id.rv_articles);
        mArticlesAdapter = new ArticlesAdapter(new ArticlesAdapter.ArticlesListener() {
            @Override
            public void onArticleClicked(Artikli artikl) {
                // ovo je prvi način
                // ovdje napišeš što će se dogoditi kad klikneš na neki od artikala
                // ovaj listener trenutno šalje samo artikl, tu ti možeš poslati što god tebi treba
                // to definiraš u adapteru na dnu gdje si napisao listener, odnosno interface
            }
        });

        // ako napraviš implementaciju interface-a u activitiyu, možeš na ovaj način kreirati objekt adaptera
        mArticlesAdapter = new ArticlesAdapter(this);

        myDB = new DatabaseHelper(this);
        List<Artikli> artikli = myDB.getAllArtikli("select * from artikli");

        // u ovom koraku će ti se popuniti adapter i imat ćeš prikaz artikala
        mArticlesAdapter.replaceData(artikli);

    }

    // ako napraviš implementaciju interface-a u activityu, moraš override-at sve metode koje on ima
    @Override
    public void onArticleClicked(Artikli artikl) {
        // ovo je identično kao u prvom načinu, ovdje pišeš što se dogodi na klik
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDB.close();
    }
}
