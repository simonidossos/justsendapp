package com.justsendapp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class OpenSender extends Activity {
  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Intent sendIntent = new Intent(Intent.ACTION_SEND);
      // Check whether gmail is installed
      if ( appInstalled("com.google.android.gm")) {
          sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
          sendIntent.putExtra(Intent.EXTRA_TEXT, "\n\n---\nSent distraction free with\nwww.justsendapp.com\n");
          startActivity(sendIntent);
      } else {
          Toast.makeText(this, "This app requires gmail to be installed", Toast.LENGTH_SHORT).show();
      }
      finish();
  }
    private boolean appInstalled(String uri)
    {
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try
        {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }
        catch (PackageManager.NameNotFoundException e)
        {
            app_installed = false;
        }
        return app_installed ;
    }

}