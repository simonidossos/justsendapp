package com.justsendapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class OpenSender extends Activity {
  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
    sendIntent.setClassName("com.google.android.gm","com.google.android.gm.ComposeActivityGmail");
    sendIntent.setType("plain/text");
    sendIntent.putExtra(Intent.EXTRA_TEXT, "---\nSent distraction free with\nwww.justsendapp.com\n");
    startActivity(sendIntent);
    finish();

  }
}
