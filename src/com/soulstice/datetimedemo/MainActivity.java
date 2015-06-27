package com.soulstice.datetimedemo;

import java.text.DateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {
	DateFormat fmtDateAndTime = DateFormat.getDateTimeInstance();
	TextView startDateAndTime, endDateAndTime;
	Calendar myCalendar = Calendar.getInstance();

	DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
	myCalendar.set(Calendar.YEAR, year);
	myCalendar.set(Calendar.MONTH, monthOfYear);
	myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
	updatestartLabel();
	//updateendLabel();
	}
	};

	TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
		myCalendar.set(Calendar.MINUTE, minute);
		updatestartLabel();
		//updateendLabel();
	}
	};

	private void updatestartLabel() {
		startDateAndTime.setText(fmtDateAndTime.format(myCalendar.getTime()));
	}
	private void updateendLabel()
	{
		endDateAndTime.setText(fmtDateAndTime.format(myCalendar.getTime()));
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startDateAndTime = (TextView) findViewById(R.id.startDateAndTime);
		endDateAndTime=(TextView)findViewById(R.id.endDateAndTime);
		Button startbtnDate = (Button) findViewById(R.id.startDateBtn);
		startbtnDate.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				new DatePickerDialog(MainActivity.this, d, myCalendar
						.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
						myCalendar.get(Calendar.DAY_OF_MONTH)).show();
			}
		});
		
		Button endbtnDate=(Button)findViewById(R.id.endDateBtn);
		endbtnDate.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				new DatePickerDialog(MainActivity.this, d, myCalendar
						.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
						myCalendar.get(Calendar.DAY_OF_MONTH)).show();
			}
		});
		

		Button startbtnTime = (Button) findViewById(R.id.startTimeBtn);
		startbtnTime.setOnClickListener(new View.OnClickListener() {
			public  void onClick(View v) {
				new TimePickerDialog(MainActivity.this, t, myCalendar
						.get(Calendar.HOUR_OF_DAY), myCalendar
						.get(Calendar.MINUTE), true).show();
			}
		});
		
		Button endbtnTime = (Button) findViewById(R.id.endTimeBtn);
		endbtnTime.setOnClickListener(new View.OnClickListener() {
			public  void onClick(View v) {
				new TimePickerDialog(MainActivity.this, t, myCalendar
						.get(Calendar.HOUR_OF_DAY), myCalendar
						.get(Calendar.MINUTE), true).show();
			}
		});

		updatestartLabel();
		updateendLabel();
	}

	
}
