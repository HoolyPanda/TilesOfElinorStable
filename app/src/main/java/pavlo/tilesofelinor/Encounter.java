package pavlo.tilesofelinor;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.pm.ActivityInfo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Pavlo on 11.03.2018.
 */

public class Encounter extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encounterdiscription);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        final AssetManager am =getApplicationContext().getAssets();
        //ListView list1 = findViewById(R.id.l1);
        final TextView text= findViewById(R.id.textView3);
        final TextView label = findViewById(R.id.textView5);
        InputStream input;
        label.setText("Описание События");

        final String p= getIntent().getStringExtra("newpath");
        String[] RawFiles = new String[0];
        try {
            RawFiles = am.list(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        final String[] Files = new String[4];
        final  Button b0,b1,b2,b3,check;
        check=findViewById(R.id.button23);
        b0= findViewById(R.id.button7);
        b1= findViewById(R.id.button8);
        b2= findViewById(R.id.button9);
        b3= findViewById(R.id.button10);
        final String[] summary= new String[4];


        try{

            String path= getIntent().getStringExtra("newpath");
            input =am.open(p+"/dis.txt") ;
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();
            final String str_data = new String(buffer, "UTF-8");

            text.setMovementMethod(new ScrollingMovementMethod());
            text.setText(str_data);

            check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    label.setText("Описание Развилки");
                    check.setVisibility(View.INVISIBLE);

                    String a0= p+"/"+Files[0]+"";
                    String a1= p+"/"+Files[1]+"";
                    String a2= p+"/"+Files[2]+"";
                    String a3= p+"/"+Files[3]+"";
                    //  Toast.makeText(Encounter.this ,a1,Toast.LENGTH_SHORT).show() ;
                    String[] RawFiles0 = new String[0];
                    try {
                        RawFiles0 = am.list(a0);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    String[] RawFiles1 = new String[0];
                    try {
                        RawFiles1 = am.list(a1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String[] RawFiles2 = new String[0];
                    try {
                        RawFiles2 = am.list(a2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String[] RawFiles3 = new String[0];
                    try {
                        RawFiles3 = am.list(a3);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(RawFiles0.length ==2){b0.setVisibility(View.VISIBLE);}
                    if(RawFiles1.length ==2){b1.setVisibility(View.VISIBLE);}
                    if(RawFiles2.length ==2){b2.setVisibility(View.VISIBLE);}
                    if(RawFiles3.length ==2){b3.setVisibility(View.VISIBLE);}


                    AssetManager am =getApplicationContext().getAssets();
                    String p= getIntent().getStringExtra("newpath");
                    String[] RawFiles = new String[0];
                    // String[] Files = new String[RawFiles.length-1];
                    // InputStream input;
                    // String [] ar= new String[3];
                    try {
                        RawFiles = am.list(p);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    for(Integer i=1;i<=RawFiles.length-1;i++){
                        //  Files[i-1]=RawFiles[i];
                    }

                    try {
                        InputStream input;
                        input =am.open(p+"/"+Files[0]+"/dis.txt") ;
                        int size = input.available();
                        byte[] buffer = new byte[size];
                        input.read(buffer);
                        input.close();
                        String str_data = new String(buffer, "UTF-8");
                        summary[0]=str_data;

                        try {
                            input =am.open(p+"/"+Files[1]+"/dis.txt") ;
                            size = input.available();
                            buffer = new byte[size];
                            input.read(buffer);
                            input.close();
                            str_data = new String(buffer, "UTF-8");
                            summary[1]=str_data ;
                            try {
                                input =am.open(p+"/"+Files[2]+"/dis.txt") ;
                                size = input.available();
                                buffer = new byte[size];
                                input.read(buffer);
                                input.close();
                                str_data = new String(buffer, "UTF-8");
                                summary[2]=str_data;
                                try {
                                    input =am.open(p+"/"+Files[3]+"/dis.txt") ;
                                    size = input.available();
                                    buffer = new byte[size];
                                    input.read(buffer);
                                    input.close();
                                    str_data = new String(buffer, "UTF-8");
                                    summary[3]=str_data;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    TextView text= findViewById(R.id.textView3);
                    String info= new String();
                    for(Integer i =0;i<=3;i++){
                        if(summary[i]!=null){
                            info +=summary[i];
                            info+="\n";
                        }



                    }
                    text.setText(info);
                }
            });


        }catch (IOException e){Toast.makeText(Encounter.this ,"nope0",Toast.LENGTH_SHORT).show() ;}

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView text= findViewById(R.id.textView3);
                String answer = p+"/"+Files[0]+"/cons.txt";
                text.setText(answer);
                InputStream input;
                try {
                    input =am.open(p+"/"+Files[0]+"/cons.txt") ;
                    int size = input.available();
                    byte[] buffer = new byte[size];
                    input.read(buffer);
                    input.close();
                    final String str_data = new String(buffer, "UTF-8");
                    text.setMovementMethod(new ScrollingMovementMethod());
                    text.setText(str_data);

                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView text= findViewById(R.id.textView3);
                String answer = p+"/"+Files[1]+"/cons.txt";
                text.setText(answer);
                InputStream input;
                try {
                    input =am.open(p+"/"+Files[1]+"/cons.txt") ;
                    int size = input.available();
                    byte[] buffer = new byte[size];
                    input.read(buffer);
                    input.close();
                    final String str_data = new String(buffer, "UTF-8");
                    text.setMovementMethod(new ScrollingMovementMethod());
                    text.setText(str_data);

                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView text= findViewById(R.id.textView3);
                String answer = p+"/"+Files[1]+"/cons.txt";
                text.setText(answer);
                InputStream input;
                try {
                    input =am.open(p+"/"+Files[2]+"/cons.txt") ;
                    int size = input.available();
                    byte[] buffer = new byte[size];
                    input.read(buffer);
                    input.close();
                    final String str_data = new String(buffer, "UTF-8");
                    text.setMovementMethod(new ScrollingMovementMethod());
                    text.setText(str_data);

                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView text= findViewById(R.id.textView3);
                String answer = p+"/"+Files[3]+"/cons.txt";
                text.setText(answer);
                InputStream input;
                try {
                    input =am.open(p+"/"+Files[3]+"/cons.txt") ;
                    int size = input.available();
                    byte[] buffer = new byte[size];
                    input.read(buffer);
                    input.close();
                    final String str_data = new String(buffer, "UTF-8");
                    text.setMovementMethod(new ScrollingMovementMethod());
                    text.setText(str_data);

                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        });
        // Toast.makeText(Encounter.this ,p,Toast.LENGTH_SHORT).show() ;
        for(Integer i=1;i<=RawFiles.length-1;i++){
            Files[i-1]=RawFiles[i];
        }
        // Toast.makeText(Encounter.this ,p+"/"+Files[0]+"/",Toast.LENGTH_SHORT).show() ;

    }

}