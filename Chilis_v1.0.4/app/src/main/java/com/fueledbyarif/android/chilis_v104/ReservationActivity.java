package com.fueledbyarif.android.chilis_v104;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class ReservationActivity extends AppCompatActivity {

    Button bDate, bTime, bConfirm;
    int year_x, month_x, day_x, hour_x, minute_x;
    static final int DIALOG_ID_DATE = 0;
    static final int DIALOG_ID_TIME = 1;

    EditText etDate, etTime, etPax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);

        showDialogButtonClick();
        showTimePickerDialog();
    }

    public void showTimePickerDialog(){
        bTime = (Button) findViewById(R.id.bTime);
        bTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID_TIME);
            }
        });
    }

    public void showDialogButtonClick(){
        bDate = (Button)findViewById(R.id.bDate);

        bDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID_DATE);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id){

        switch(id){
            case DIALOG_ID_TIME:
                return new TimePickerDialog(ReservationActivity.this, timePickerListener, hour_x, minute_x, false);
            case DIALOG_ID_DATE:
                return new DatePickerDialog(this, dpickerListener, year_x, month_x, day_x);
        }
        return null;

//        if (id == DIALOG_ID_TIME){
//            return new TimePickerDialog(ReservationActivity.this, timePickerListener, hour_x, minute_x, false);
//        }else{
//            return null;
//        }
//
//       if(id == DIALOG_ID_DATE){
//            return new DatePickerDialog(this, dpickerListener, year_x, month_x, day_x);
//        }else{
//            return null;
//        }
    };

    protected TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int minute) {
            hour_x = hour;
            minute_x = minute;
            etTime = (EditText) findViewById(R.id.etTime);
            etTime.setText(hour_x + ":" + minute_x);
            //Toast.makeText(ReservationActivity.this, hour_x + " : " + minute_x, Toast.LENGTH_SHORT).show();
        }
    };

    private DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear + 1;
            day_x = dayOfMonth;
            etDate = (EditText) findViewById(R.id.etDate);
            etDate.setText(day_x + " " + month_x + " " + year_x);
            //Toast.makeText(ReservationActivity.this, year_x + "/" + month_x + "/" + day_x, Toast.LENGTH_LONG).show();
        }
    };
}
