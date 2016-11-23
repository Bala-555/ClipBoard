package com.bala555.clipboard;

import android.app.Service;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class HeadService extends Service {

    WindowManager windowManager;
    ImageView chatHead;
    WindowManager.LayoutParams params;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //create clipboard listener
        ClipboardManager manager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        manager.addPrimaryClipChangedListener(
                new ClipboardManager.OnPrimaryClipChangedListener() {
                    public void onPrimaryClipChanged() {
                        createHead();
                    }
                });

        //if service is stopped, it will automatically restarted
        return START_STICKY;
    }

    public void createHead() {
        chatHead = new ImageView(this);
        chatHead.setImageResource(R.mipmap.ic_launcher);

        params = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_TOAST,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
        );

        //Place the chat head in the screen
        params.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        params.x = 0;
        params.y = 100;


        //onclick listener for the chathead
        chatHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager manager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData.Item data = manager.getPrimaryClip().getItemAt(0);
                Toast.makeText(getBaseContext(), data.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        windowManager.addView(chatHead, params);

        //automatically close the chat head
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    //thread for 2 sec
                    Thread.sleep(2000);
                    if (chatHead.isShown()) {
//                        chatHead.setVisibility(View.GONE);
//                         windowManager.removeView(chatHead);
                        onDestroy();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(r);
        thread.start();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (chatHead != null) {
            //this code is not working
            windowManager.removeView(chatHead);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
