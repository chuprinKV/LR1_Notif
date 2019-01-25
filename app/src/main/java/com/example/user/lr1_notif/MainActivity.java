package com.example.user.lr1_notif;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    TextView text1;
    TextView text2;
    Button button1;
    Button button2;
    Context ctn;
    String click;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        text1 = (TextView) findViewById(R.id.text1);
        text2 =(TextView) findViewById(R.id.text2);

        View.OnClickListener clickBtn1 = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                text1.setText("Hello World");
                text2.setText("Click №" + new Integer(i).toString());
                i = i+1;
            }
        };

        button1.setOnClickListener(clickBtn1);
        click = String.valueOf(i);
        View.OnClickListener clickBtn2 = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(ctn)
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle("Количество нажатий")
                                .setContentText(click);

                Notification notification = builder.build();

                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(1, notification);
            }
        };
        button2.setOnClickListener(clickBtn2);

    }
}
