package pavlo.tilesofelinor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    static String path ="Dungeons";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.Districts);

        AssetManager am =getApplicationContext().getAssets();

        FloatingActionButton fab = findViewById(R.id.abb);

        fab.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View view) {
               // Intent intent = new Intent(MainActivity .this, DungeonSelect.class);
                Intent intent = new Intent(MainActivity .this,MapViewer.class);
                intent.putExtra("path", path);
                startActivity(intent);
                Toast.makeText(MainActivity.this ,"",Toast.LENGTH_SHORT);
                Log.e("Hello", "Hello");
            }
        });

        try {

            String[] Files = am.list(path);
            final ArrayAdapter ar =  new ArrayAdapter(this, android.R.layout.simple_list_item_1,Files) ;
            list.setAdapter(ar);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @SuppressLint("ShowToast")
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    TextView txt= (TextView) view;
                    String s = path+ "/"+txt.getText().toString();
                    Toast.makeText(MainActivity.this ,s,Toast.LENGTH_SHORT);
                    Intent intent = new Intent(MainActivity .this, DungeonSelect.class);
                    intent.putExtra("newpath",s);
                    intent.putExtra("newpath1",s+"1234");
                    startActivity(intent);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}