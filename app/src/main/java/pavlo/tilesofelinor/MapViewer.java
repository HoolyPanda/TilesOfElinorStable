package pavlo.tilesofelinor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by Pavlo on 11.03.2018.
 */

public class MapViewer extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapviewer);
        WebView Map= findViewById(R.id.map);
        String res = getIntent().getStringExtra("path");
        //Toast.makeText(getApplicationContext(),res,Toast.LENGTH_LONG ).show() ;
        // FloatingActionButton fab2= findViewById(R.id.floatingActionButton3);
        String file= "file:///android_asset/"+res+"/Map"+"/map.html";
        Map.getSettings().setSupportZoom(true);
        Map.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        Map.getSettings().setBuiltInZoomControls(true);

        if (res.equals("Dungeons")==true){
            Map.loadUrl("file:///android_asset/Maps/map.html");
            // fab2.hide();
        }else{
            Map.loadUrl(file);
        }

        // fab2.setOnClickListener(new View.OnClickListener() {
        //   @Override
        // public void onClick(View view) {
        //   String res = getIntent().getStringExtra("path");
        // Intent intent = new Intent(MapViewer.this, EncounterList.class);
        //intent.putExtra("dungeon", res);
        //startActivity(intent);
        // }
        //});
    }

}
