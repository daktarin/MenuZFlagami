package eu.huras.marcin.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.moje_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {

            case R.id.action_1:
                //Toast.makeText(MainActivity.this, "Pozycja menu 1", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                Notification notification = new Notification.Builder(MainActivity.this)
                        .setTicker("TickerTitle")
                        .setContentTitle("Umyj zęby zbóju Lamignacie!")
                        .setContentText("Kup komiks Kajka i kokosza i czy")
                        .setSmallIcon(R.drawable.burundi)
                        .setContentIntent(pendingIntent).getNotification();

                notification.flags = Notification.FLAG_AUTO_CANCEL;
                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0, notification);

                break;

            case R.id.action_2:
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.interia.pl"));

                startActivity(intent2);


                break;

            case R.id.action_3:
                Toast.makeText(MainActivity.this, "Pozycja menu 3", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }


}
