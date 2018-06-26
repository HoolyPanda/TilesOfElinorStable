package pavlo.tilesofelinor;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.text.method.ScrollingMovementMethod;
import android.view.DragEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.content.pm.ActivityInfo;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static android.view.DragEvent.ACTION_DRAG_STARTED;

/**
 * Created by Pavlo on 11.03.2018.
 */

public class EnterTheDungeon extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enterthedungeon);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TextView MainDiscription, ToEnter;
        MainDiscription = findViewById(R.id.textView);
        ToEnter = findViewById(R.id.textView2);
        InputStream input;
        AssetManager am = getApplicationContext().getAssets();
        Button button= findViewById(R.id.button);
        FloatingActionButton fab= findViewById(R.id.floatingActionButton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{

                    setContentView(R.layout.dascript);
                    InputStream input;
                    String path = getIntent().getStringExtra("newpath1");
                    String s1= path;
                    TextView  Script = findViewById(R.id.script);
                    AssetManager am = getApplicationContext().getAssets();

                    input =am.open(s1+"/script.txt") ;
                    int size = input.available();
                    byte[] buffer = new byte[size];
                    input.read(buffer);
                    input.close();
                    String str_data = new String(buffer, "windows-1251");
                    Script.setMovementMethod(new ScrollingMovementMethod());
                    Script.setText(str_data);

                    Button button= findViewById(R.id.button2);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String path = getIntent().getStringExtra("newpath1");
                            String a= getIntent().getStringExtra("dungeon");
                            Intent intent = new Intent(EnterTheDungeon .this, EncounterList.class);
                            intent.putExtra("chousendungeon", getIntent().getStringExtra("chousendungeon"));
                            intent.putExtra("dungeon",a);
                            intent.putExtra("path",path);
                            startActivity(intent);
                        }
                    });

                }catch (IOException e){
                    String path = getIntent().getStringExtra("newpath1");
                    String a= getIntent().getStringExtra("dungeon");
                    Toast.makeText(EnterTheDungeon.this, "Для этого подземельня нет сценария", Toast.LENGTH_LONG ).show();
                    Intent intent = new Intent(EnterTheDungeon .this, EncounterList.class);
                    intent.putExtra("chousendungeon", getIntent().getStringExtra("chousendungeon"));
                    intent.putExtra("dungeon",a);
                    intent.putExtra("path",path);
                    startActivity(intent);
                }
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String path = getIntent().getStringExtra("newpath1");
                    InputStream input;
                    String s1= path;
                    AssetManager am = getApplicationContext().getAssets();
                    input =am.open(s1+"/answer.txt") ;
                    int size = input.available();
                    byte[] buffer = new byte[size];
                    input.read(buffer);
                    input.close();
                    String str_data = new String(buffer, "UTF-8");
                    Toast.makeText(EnterTheDungeon.this, str_data, Toast.LENGTH_LONG ).show();
                }catch (IOException e){
                    Toast.makeText(EnterTheDungeon.this, "str_data", Toast.LENGTH_SHORT );
                }
            }
        });
        //выводим описание
        try{
            String path = getIntent().getStringExtra("newpath1");
            String s= path;
            input =am.open(s+"/description.txt") ;
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();
            String str_data = new String(buffer, "UTF-8");
            MainDiscription.setMovementMethod(new ScrollingMovementMethod());
            MainDiscription.setText(str_data);
        }catch (IOException e){}
        //выводим экнтранс
        try{
            String path = getIntent().getStringExtra("newpath1");
            String s= path;
            input =am.open(s+"/entrance.txt") ;
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();


            String str_data = new String(buffer, "UTF-8");
            ToEnter.setMovementMethod(new ScrollingMovementMethod());
            ToEnter.setText(str_data);
        }
        catch(IOException e){}
    }

}

