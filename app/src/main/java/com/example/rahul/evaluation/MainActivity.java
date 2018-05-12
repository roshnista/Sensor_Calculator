package com.example.rahul.evaluation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.*;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener
{
    SensorManager smgr;
    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);

        smgr = (SensorManager)this.getSystemService(SENSOR_SERVICE);
        Sensor accelerometer=smgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        smgr.registerListener(this, accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void onSensorChanged(SensorEvent event) {
        TextView tvw = (TextView) findViewById(R.id.textView);
        if (event.values[0] > 5) {
            final int a = Integer.parseInt(et1.getText().toString());
            final int b = Integer.parseInt(et2.getText().toString());
            int c = a*b;
            tvw.setText(String.valueOf(c));
        }
        else if (event.values[0] < -5) {
            final int a = Integer.parseInt(et1.getText().toString());
            final int b = Integer.parseInt(et2.getText().toString());
            float d = (float)a/b;
            tvw.setText(String.valueOf(d));
        }
        else if (event.values[1] < -5) {
            final int a = Integer.parseInt(et1.getText().toString());
            final int b = Integer.parseInt(et2.getText().toString());
            int e = a+b;
            tvw.setText(String.valueOf(e));
        }
        else if(event.values[1]>5)
        {
            final int a=Integer.parseInt(et1.getText().toString());
            final int b=Integer.parseInt(et2.getText().toString());
            int f=a-b;
            tvw.setText(String.valueOf(f));
        }
        else if(event.values[2]<-5)
        {
            final int a=Integer.parseInt(et1.getText().toString());
            final int b=Integer.parseInt(et2.getText().toString());
            float g= (float)a/b;
            //float h=(float)g*100;
            tvw.setText(String.valueOf(g*100));
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }
}

