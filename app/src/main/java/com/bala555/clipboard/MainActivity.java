package com.bala555.clipboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    final static String WEBS = "https://";
//    final static String WEB = "http://";
//    private static final String TAG = "com.bala555.clipboard";
    TextView clipData, clipDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent service = new Intent(getApplicationContext(),HeadService.class);
        startService(service);

        clipData = (TextView) findViewById(R.id.clipText);
        clipDescription = (TextView) findViewById(R.id.clipdescription);

//        final ClipboardManager manager = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
//        ShowToUser();
//
//        manager.addPrimaryClipChangedListener(
//                new ClipboardManager.OnPrimaryClipChangedListener() {
//                    public void onPrimaryClipChanged() {
//                        String data = manager.getText().toString();
//                        clipData.setText(data);
//                    }
//                }
//        );
    }

//    public void captureScreenshot(View view) {
//
//        Date date = new Date();
//        android.text.format.DateFormat.format("yyyy-MM-dd-hh-mm-ss",date);
//
//        try
//        {
//            String path = Environment.getExternalStorageDirectory().toString()+"/"+date+".jpg";
//            View view = getWindow().getDecorView().getRootView();
//            view.setDrawingCacheEnabled(true);
//            Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
//            view.setDrawingCacheEnabled(false);
//
//           File imageFile = new File(path);
//
//           FileOutputStream file = new FileOutputStream(imageFile);
//            int quality = 100;
//            //bitmap.compress(Bitmap.CompressFormat.JPEG,quality,file);
//            file.flush();
//            file.close();
//
//        }catch (Throwable e)
//        {
//            e.printStackTrace();
//        }
//
//    }

//    public void ShowToUser() {
//        ClipboardManager manager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
//        ClipData.Item item = manager.getPrimaryClip().getItemAt(0);
//        String data = item.getText().toString();
//
//        startService(new Intent(getApplication(),HeadService.class));
//
//        if (data != null) {
//            clipData.setText(data);
//        } else {
//            clipData.setText("No Data");
//        }
//
//        Uri uri = item.getUri();
//        clipDescription.setText("uri"+uri);
//
//    }

}
