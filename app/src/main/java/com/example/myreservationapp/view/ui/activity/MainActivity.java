package com.example.myreservationapp.view.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.myreservationapp.R;
import com.example.myreservationapp.model.ReservationDBHelper;
import com.example.myreservationapp.model.data.Reservation;
import com.example.myreservationapp.util.Day;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


import static com.example.myreservationapp.model.ReservationDBHelper.FIRST_NAME_COLUMN;
import static com.example.myreservationapp.model.ReservationDBHelper.LAST_NAME_COLUMN;
import static com.example.myreservationapp.model.ReservationDBHelper.NUMBER_OF_GUESTS_COLUMN;
import static com.example.myreservationapp.model.ReservationDBHelper.NUMBER_OF_NIGHTS_COLUMN;
import static com.example.myreservationapp.model.ReservationDBHelper.NUMBER_OF_ROOM_COLUMN;
import static com.example.myreservationapp.model.ReservationDBHelper.RESERVATION_ID_COLUMN;
import static com.example.myreservationapp.model.ReservationDBHelper.ROOM_NAME_COLUMN;


public class MainActivity extends AppCompatActivity {


    private ReservationDBHelper reservationDBHelper;

    private int reservationID;


    @BindView(R.id.first_name_edittext)
    public EditText firstNameEditText;

    @BindView(R.id.last_name_edittext)
    public EditText lastNameEditText;

    @BindView(R.id.room_name_edittext)
    public EditText roomNameEditText;

    @BindView(R.id.number_of_room_edittext)
    public EditText numberOfRoomEditText;

    @BindView(R.id.number_of_guests_edittext)
    public EditText numberOfGuestsEditText;

    @BindView(R.id.number_of_nights_edittext)
    public EditText numberOfNightsEditText;

    @BindView(R.id.total_price_edittext)
    public EditText totalPriceEditText;

    @BindView(R.id.check_in_time_edittext)
    public EditText checkInTimeEditText;

    @BindView(R.id.check_out_time_edittext)
    public EditText checkOutTimeEditText;

    @BindView(R.id.check_in_date_edittext)
    public EditText checkInDateEditText;

    @BindView(R.id.check_out_date_editText)
    public EditText checkOutDateEditText;

    @OnClick(R.id.add_reservation_button)

    public void onAddReservation(View view) {

        String firstName = firstNameEditText.getText().toString().trim();
        //set mealNameEditText to empty
        firstNameEditText.setText("");

        //Because it is a String have to call the method Double.parseDouble - of casting strings into double
        double totalPrice = Double.parseDouble(totalPriceEditText.getText().toString());
        //set mealPriceEditText to empty
        totalPriceEditText.setText("");

        String lastName = lastNameEditText.getText().toString().trim();
        //set mealTypeEditText to empty
        lastNameEditText.setText("");

        String roomName = roomNameEditText.getText().toString().trim();
        //set mealNameEditText to empty
        roomNameEditText.setText("");

        int numberOfRoom = Integer.parseInt(numberOfRoomEditText.getText().toString());
        //set mealPriceEditText to empty
        numberOfRoomEditText.setText("");

        int numberOfGuests = Integer.parseInt(numberOfGuestsEditText.getText().toString());
        //set mealPriceEditText to empty
        numberOfGuestsEditText.setText("");

        int numberOfNights = Integer.parseInt(numberOfNightsEditText.getText().toString());
        //set mealPriceEditText to empty
        numberOfNightsEditText.setText("");

        String checkInTime = checkInTimeEditText.getText().toString().trim();
        checkInTimeEditText.setText("");

        String checkOutTime = checkOutTimeEditText.getText().toString().trim();
        checkOutTimeEditText.setText("");

        String checkInDate = checkInDateEditText.getText().toString().trim();
        checkInTimeEditText.setText("");

        String checkOutDate = checkOutDateEditText.getText().toString().trim();
        checkOutDateEditText.setText("");

        //java.sql.Time check_out_time,

        //create new reservation objects (add the reservation) and insert it into reservation database and read it when we insert.
        Reservation reservation = new Reservation(reservationID, checkInTime, checkOutTime, checkInDate, checkOutDate);

        //ReservationDBHelper.insertNewReservation(reservation);

        //inserting meals manually
        //ReservationDBHelper.insertNewReservation(reservation);
       // ReservationDBHelper.insertNewReservation(reservation);
        //every time I add the meal read from the database
       // readAllReservations();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Implement the onClick Listeners for radioGroup buttons.
        //Call ButterKnife bind - bind the views
        ButterKnife.bind(this);


        //instantiate -  create new database objects
        reservationDBHelper = new ReservationDBHelper(this);

        //readAllReservations();

// set date here
    }
    //When the app starts it is selecting automatically according to the current day od the week.

//
   // private void readAllReservations()
/**
       private void readAllReservations() {
     //Cursor allReservations = ReservationDBHelper.getAllReservations();
           Cursor allReservations = ReservationDBHelper.readAllReservations;
     //if it's empty then it's still at -1.
     allReservations.move(-1);
     //array list
     //while loop I still have another one keep on looping through this item
     while(allReservations.moveToNext()) {
     int reservationID = allReservations.getInt(allReservations.getColumnIndex(RESERVATION_ID_COLUMN));
     String firstName = allReservations.getString(allReservations.getColumnIndex(FIRST_NAME_COLUMN));
     Day day = Enum.valueOf(Day.class,allReservations.getString(allReservations.getColumnIndex(DAY_OF_WEEK_COLUMN)));
     double totalPrice = allReservations.getDouble(allReservations.getColumnIndex(TOTAL_PRICE_COLUMN));
     String lastName = allReservations.getString(allReservations.getColumnIndex(LAST_NAME_COLUMN));
     int numberOfGuests = allReservations.getInt(allReservations.getColumnIndex(NUMBER_OF_GUESTS_COLUMN));
     int numberOfRoom =  allReservations.getInt(allReservations.getColumnIndex(NUMBER_OF_ROOM_COLUMN));
     int numberOfNights = allReservations.getInt(allReservations.getColumnIndex(NUMBER_OF_NIGHTS_COLUMN));
     String roomName = allReservations.getString(allReservations.getColumnIndex(ROOM_NAME_COLUMN));
     Reservation reservation = new Reservation(reservationID, checkInTime, checkOutTime, checkInDate, checkOutDate);
     Log.d("TAG_X",reservation.toString());
     }
     }


    // Write into the database as well read from the database.
   // private void readAllReservations() {
     //   List<Reservation> reservations = new ArrayList<>();

        //reservations = ReservationDBHelper.getAllReservations();
    //    reservations = ReservationDBHelper.getAllReservations();
    //    reservations.forEach(new Consumer<Reservation>() {
     //       @Override
     //       public void accept(Reservation reservation) {
      //          Log.d("TAG_H", reservation.toString());
    //        }
    //    });
    //}
    //write into database and read into database
    private void readAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        reservations = ReservationDBHelper.getAllReservations();
    }
 */
}