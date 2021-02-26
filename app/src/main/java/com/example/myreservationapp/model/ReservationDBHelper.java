package com.example.myreservationapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myreservationapp.model.data.Reservation;
import com.example.myreservationapp.util.Day;

import java.util.ArrayList;
import java.util.List;

public class ReservationDBHelper extends SQLiteOpenHelper {

    //database name
    public static final String DATABASE_NAME = "reservation.db";
    //version must be greater than zero.
    public static int DATABASE_VERSION = 1;

    //database table name
    public static final String TABlE_NAME = "reservations";

    //column names for reservation table - all strings
    public static final String RESERVATION_ID_COLUMN = "reservation.db";
    public static final String DAY_OF_WEEK_COLUMN = "day_of_week";
    public static final String FIRST_NAME_COLUMN = "first_name_of_guest";
    public static final String LAST_NAME_COLUMN = "last_name_of_guest";
    public static final String ROOM_NAME_COLUMN = "room_name";
    public static final String NUMBER_OF_ROOM_COLUMN = "number_of_room";
    public static final String NUMBER_OF_GUESTS_COLUMN = "number_of_guests";
    public static final String NUMBER_OF_NIGHTS_COLUMN = "number_of_nights";
    public static final String TOTAL_PRICE_COLUMN = "total_price";

    public ReservationDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //create table for meals with MEAL_ID as the primary key. Add spaces between data data types.
        String createCommand = "CREATE TABLE " + TABlE_NAME + " (" +
                RESERVATION_ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DAY_OF_WEEK_COLUMN + " TEXT, " +
                FIRST_NAME_COLUMN + " TEXT, " +
                LAST_NAME_COLUMN + " TEXT, " +
                ROOM_NAME_COLUMN + " TEXT, " +
                NUMBER_OF_ROOM_COLUMN + " TEXT, " +
                NUMBER_OF_GUESTS_COLUMN + " INTEGER, " +
                NUMBER_OF_NIGHTS_COLUMN + " INTEGER, " +
                TOTAL_PRICE_COLUMN + " REAL);";
        //run the create command by calling sqLiteDatabase.execSQL
        sqLiteDatabase.execSQL(createCommand); //Table created in the meal database.
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String upgradeCommand = "DROP TABLE IF EXISTS " + TABlE_NAME;
        sqLiteDatabase.execSQL(upgradeCommand);
        DATABASE_VERSION++;
        onCreate(sqLiteDatabase);
    }

    //when the methods has the same exact name but different parameters is called Overload.
    //modify the methods
    //public void insertNewMeals(String day, String name, double price) {}

    //only modify Reservation class
    public void insertNewReservation(Reservation reservation) {
        // String insert = "INSERT INTO ..." + reservation.getFirstNameOfGuest()
        //key (column names) value pairs
        ContentValues values = new ContentValues();
        values.put(DAY_OF_WEEK_COLUMN, reservation.getDay().name());
        values.put(FIRST_NAME_COLUMN, reservation.getFirstNameOfGuest());
        values.put(LAST_NAME_COLUMN, reservation.getLastNameOfGuest());
        values.put(ROOM_NAME_COLUMN, reservation.getRoomName());


        values.put(NUMBER_OF_ROOM_COLUMN, reservation.getNumberOfRoom());
        values.put(NUMBER_OF_GUESTS_COLUMN, reservation.getNumberOfGuests());
        values.put(NUMBER_OF_NIGHTS_COLUMN, reservation.getNumberOfNights());
        values.put(TOTAL_PRICE_COLUMN, reservation.getPrice());

        //getWritableDatabase() is a SQLite database
        // values have been inserted into the database
        getWritableDatabase().insert(TABlE_NAME, null, values);

    }

    /**   public Cursor getAllReservations() {
     //Command select all
     String getAll = "SELECT * FROM " + TABlE_NAME;
     //return statement the null gets everything
     return getReadableDatabase().rawQuery(getAll, null);

     //public Cursor getAllReservations(Day day) {
     //Command select all
     // String getAll = "SELECT * FROM " + TABlE_NAME + " WHERE " + DAY_OF_WEEK_COLUMN + " = " + day.name();
     // return getReadableDatabase().rawQuery(getAll, new String[] {DAY_OF_WEEK_COLUMN, MEAL_ID_COLUMN});
     }
     */
    //Read from the database - returns a cursor object
    //Convert cursor into a list of object, easy to use for all other developers.
    public List<Reservation> getAllReservations() {
        String getAll = "SELECT * FROM " + TABlE_NAME;
        Cursor allReservations = getReadableDatabase().rawQuery(getAll, null);
        List<Reservation> reservationsList = new ArrayList<>();
        //Reading the data
        while(allReservations.moveToNext()) {
            int reservationID = allReservations.getInt(allReservations.getColumnIndex(RESERVATION_ID_COLUMN));
            String firstName = allReservations.getString(allReservations.getColumnIndex(FIRST_NAME_COLUMN));
            String lastName = allReservations.getString(allReservations.getColumnIndex(FIRST_NAME_COLUMN));
            Day day = Enum.valueOf(Day.class, allReservations.getString(allReservations.getColumnIndex(DAY_OF_WEEK_COLUMN)));
            String roomName = allReservations.getString(allReservations.getColumnIndex(ROOM_NAME_COLUMN));
            int numberOfRoom = allReservations.getInt(allReservations.getColumnIndex(NUMBER_OF_ROOM_COLUMN));
            int numberOfGuests = allReservations.getInt(allReservations.getColumnIndex(NUMBER_OF_GUESTS_COLUMN));
            int numberOfNights = allReservations.getInt(allReservations.getColumnIndex(NUMBER_OF_NIGHTS_COLUMN));
            double totalPrice = allReservations.getDouble(allReservations.getColumnIndex(TOTAL_PRICE_COLUMN));
            Reservation reservation = new Reservation(reservationID, firstName, lastName, day, numberOfGuests, numberOfRoom, roomName, numberOfNights, totalPrice);
            //Log.d("TAG_X",reservation.toString());
            //add reservation to the reservations array list
            reservationsList.add(reservation);
        }
        //close the cursor
        allReservations.close();
        //return meal list
        return reservationsList;
    }
}
