package com.farmacia;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class telaprodutos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telaprodutos);
        dbcontroller db= new dbcontroller(getBaseContext());
        List<produtos> p= db.retornaProduto();
        ListView lv= (ListView)findViewById(R.id.listaProdutos);
        ArrayAdapter<produtos> adapter= new ArrayAdapter<produtos>(this,R.layout.support_simple_spinner_dropdown_item,p);
        lv.setAdapter(adapter);
        Button btnMaps=(Button)findViewById(R.id.btnMaps);




         Button btnAddProduto=(Button) findViewById(R.id.btnAddProduto);


         btnAddProduto.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent tela=new Intent(telaprodutos.this,cadastrarproduto.class);
                 startActivity(tela);
             }
         });
         btnMaps.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent tela=new Intent(telaprodutos.this,MapsActivity.class);
                 startActivity(tela);
             }
         });
    }
}
