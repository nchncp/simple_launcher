package com.example.elderly.simplelauncher;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

/**
 * Created by nicha on 9/16/16.
 */
public class CalendarActivity extends Activity{

    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        initializeCalendar();
    }

    private void initializeCalendar() {
        calendar = (CalendarView) findViewById(R.id.calendar);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(), dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
            }
        });

        calendar.setShowWeekNumber(false);

        calendar.setUnfocusedMonthDateColor(getResources().getColor(R.color.transparent));

//        calendar.setWeekSeparatorLineColor(getResources().getColor(R.color.transparent));

//        calendar.setSelectedWeekBackgroundColor(getResources().getColor(R.color.green));

    }
}
