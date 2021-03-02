package com.example.myreservationapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myreservationapp.model.data.Booking;
import com.example.myreservationapp.model.data.Guest;
import com.example.myreservationapp.model.data.Invoice;
import com.example.myreservationapp.model.data.Reservation;
import com.example.myreservationapp.model.data.Room;
import com.example.myreservationapp.util.Day;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationDBHelper extends SQLiteOpenHelper {

    //database name
    public static final String DATABASE_NAME = "reservation.db";
    //version must be greater than zero.
    public static int DATABASE_VERSION = 1;

    //table nameS
    public static final String TABlE_RESERVATION = "reservations";
    public static final String TABlE_GUEST = "guests";
    public static final String TABlE_ROOM = "rooms";
    public static final String TABlE_INVOICE = "invoices";
    public static final String TABlE_BOOKING = "bookings";

    //column names for reservation table - all strings
    public static final String RESERVATION_ID_COLUMN = "re_id";
    public static final String CHECK_IN_TIME_COLUMN = "check_in_time";
    public static final String CHECK_OUT_TIME_COLUMN = "check_out_time";
    public static final String CHECK_IN_DATE_COLUMN = "check_in_date";
    public static final String CHECK_OUT_DATE_COLUMN = "check_out_date";

    //column names for guest table - all strings
    public static final String GUEST_ID_COLUMN = "gu_id";
    public static final String TITLE_COLUMN = "title_of_guest";
    public static final String FIRST_NAME_COLUMN = "first_name_of_guest";
    public static final String LAST_NAME_COLUMN = "last_name_of_guest";
    public static final String PHONE_NUMBER_COLUMN = "phone_number_of_guest";
    public static final String NUMBER_OF_GUESTS_COLUMN = "number_of_guests";

    //column names for room table - all strings
    public static final String ROOM_ID_COLUMN = "ro_id";
    public static final String ROOM_NAME_COLUMN = "room_name";
    public static final String NUMBER_OF_ROOM_COLUMN = "number_of_room";
    public static final String PRICE_COLUMN = "price";

    //column names for invoice table - all strings
    public static final String INVOICE_ID_COLUMN = "in_id";
    public static final String BALANCE_DUE_COLUMN = "balance";
    public static final String DATE_COLUMN = "date";

    //column names for booking table - all strings
    public static final String BOOKING_ID_COLUMN = "bo_id";
    public static final String NUMBER_OF_NIGHTS_COLUMN = "number_of_nights";


    public ReservationDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //create table for meals with MEAL_ID as the primary key. Add spaces between data data types.
        String createCommandForReservation = "CREATE TABLE " + TABlE_RESERVATION + " (" +
                RESERVATION_ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CHECK_IN_TIME_COLUMN + " TIME, " +
                CHECK_OUT_TIME_COLUMN + " TIME, " +
                CHECK_IN_DATE_COLUMN + " DATE, " +
                CHECK_OUT_DATE_COLUMN + " DATE)";

        String createCommandForGuest = "CREATE TABLE " + TABlE_GUEST + " (" +
                GUEST_ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TITLE_COLUMN + " TEXT, " +
                FIRST_NAME_COLUMN + " TEXT, " +
                LAST_NAME_COLUMN + " TEXT, " +
                PHONE_NUMBER_COLUMN + " TEXT, " +
                NUMBER_OF_GUESTS_COLUMN + " INTEGER)";

        String createCommandForRoom = "CREATE TABLE " + TABlE_ROOM + " (" +
                ROOM_ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ROOM_NAME_COLUMN + " TEXT, " +
                NUMBER_OF_ROOM_COLUMN + " INTEGER, " +
                PRICE_COLUMN + " REAL)";

        //create table for meals with MEAL_ID as the primary key. Add spaces between data data types.
        String createCommandForInvoice = "CREATE TABLE " + TABlE_INVOICE + " (" +
                INVOICE_ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                BALANCE_DUE_COLUMN  + " REAL, " +
                DATE_COLUMN + " DATE, " +
                GUEST_ID_COLUMN + " INTEGER FOREIGN KEY AUTOINCREMENT, " +
                BOOKING_ID_COLUMN + " INTEGER FOREIGN KEY AUTOINCREMENT)";


        String createCommandForBooking = "CREATE TABLE " + TABlE_BOOKING + " (" +
                BOOKING_ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NUMBER_OF_NIGHTS_COLUMN + " INTEGER, " +
                ROOM_ID_COLUMN + " INTEGER FOREIGN KEY AUTOINCREMENT, " +
                GUEST_ID_COLUMN + " INTEGER FOREIGN KEY AUTOINCREMENT)";


        //run the create command by calling sqLiteDatabase.execSQL
        sqLiteDatabase.execSQL(createCommandForReservation); //Table created in the reservation database.
        sqLiteDatabase.execSQL(createCommandForGuest);
        sqLiteDatabase.execSQL(createCommandForRoom);
        sqLiteDatabase.execSQL(createCommandForInvoice);
        sqLiteDatabase.execSQL(createCommandForBooking);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String upgradeCommandForReservation = "DROP TABLE IF EXISTS " + TABlE_RESERVATION;
        sqLiteDatabase.execSQL(upgradeCommandForReservation);
        String upgradeCommandForGuest = "DROP TABLE IF EXISTS " + TABlE_GUEST;
        sqLiteDatabase.execSQL(upgradeCommandForGuest);
        String upgradeCommandForRoom = "DROP TABLE IF EXISTS " + TABlE_ROOM;
        sqLiteDatabase.execSQL(upgradeCommandForRoom);
        String upgradeCommandForInvoice = "DROP TABLE IF EXISTS " + TABlE_INVOICE;
        sqLiteDatabase.execSQL(upgradeCommandForReservation);
        String upgradeCommandForBooking = "DROP TABLE IF EXISTS " + TABlE_BOOKING;
        sqLiteDatabase.execSQL(upgradeCommandForBooking);
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
        values.put(CHECK_IN_TIME_COLUMN, reservation.getCheck_in_time());
        values.put(CHECK_OUT_TIME_COLUMN, reservation.getCheck_out_time());
        values.put(CHECK_IN_DATE_COLUMN, reservation.getCheck_in_date());
        values.put(CHECK_OUT_DATE_COLUMN, reservation.getCheck_out_date());

        //getWritableDatabase() is a SQLite database
        // values have been inserted into the database
        getWritableDatabase().insert(TABlE_RESERVATION, null, values);

    }

    public void insertNewRoom(Room room) {
        // String insert = "INSERT INTO ..." + reservation.getFirstNameOfGuest()
        //key (column names) value pairs
        ContentValues values = new ContentValues();
        values.put(ROOM_NAME_COLUMN, room.getRoomName());
        values.put(NUMBER_OF_ROOM_COLUMN, room.getNumberOfRoom());
        values.put(PRICE_COLUMN, room.getPrice());

        getWritableDatabase().insert(TABlE_ROOM, null, values);

    }

    public void insertNewGuest(Guest guest) {
        // String insert = "INSERT INTO ..." + reservation.getFirstNameOfGuest()
        //key (column names) value pairs
        ContentValues values = new ContentValues();
        values.put(TITLE_COLUMN, guest.getTitle());
        values.put(FIRST_NAME_COLUMN, guest.getFirstNameOfGuest());
        values.put(LAST_NAME_COLUMN, guest.getLastNameOfGuest());
        values.put(PHONE_NUMBER_COLUMN, guest.getPhoneNumber());
        values.put(NUMBER_OF_GUESTS_COLUMN, guest.getNumberOfGuests());

        getWritableDatabase().insert(TABlE_GUEST, null, values);

    }


    public void insertNewInvoice(Invoice invoice) {
        // String insert = "INSERT INTO ..." + reservation.getFirstNameOfGuest()
        //key (column names) value pairs
        ContentValues values = new ContentValues();
        values.put(BALANCE_DUE_COLUMN, invoice.getBalance_due());
        values.put(DATE_COLUMN, invoice.getDate());

        getWritableDatabase().insert(TABlE_INVOICE, null, values);

    }

    public void insertNewBooking(Booking booking) {
        // String insert = "INSERT INTO ..." + reservation.getFirstNameOfGuest()
        //key (column names) value pairs
        ContentValues values = new ContentValues();
        values.put(NUMBER_OF_NIGHTS_COLUMN, booking.getNumberOfNights());

        getWritableDatabase().insert(TABlE_BOOKING, null, values);

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
        String getAll = "SELECT * FROM " + TABlE_RESERVATION;
        Cursor allReservations = getReadableDatabase().rawQuery(getAll, null);
        List<Reservation> reservationsList = new ArrayList<>();
        //Reading the data
        while(allReservations.moveToNext()) {
            int reservationID = allReservations.getInt(allReservations.getColumnIndex(RESERVATION_ID_COLUMN));
            Time checkInTime = Time.valueOf(allReservations.getString(allReservations.getColumnIndex(ROOM_NAME_COLUMN)));
            Time checkOutTime = Time.valueOf(allReservations.getString(allReservations.getColumnIndex(CHECK_OUT_TIME_COLUMN)));
            String checkInDate = allReservations.getString(allReservations.getColumnIndex(CHECK_IN_DATE_COLUMN));
            String checkOutDate = allReservations.getString(allReservations.getColumnIndex(CHECK_OUT_DATE_COLUMN));

            Reservation reservation = new Reservation(reservationID, checkInTime, checkOutTime, checkInDate, checkOutDate);
            //Log.d("TAG_X",reservation.toString());
            //add reservation to the reservations array list
            reservationsList.add(reservation);
        }
        //close the cursor
        allReservations.close();
        //database helper returning reservations list
        return reservationsList;
    }

    public List<Guest> getAllGuests() {
        String getAll = "SELECT * FROM " + TABlE_GUEST;
        Cursor allGuests = getReadableDatabase().rawQuery(getAll, null);
        List<Guest> guestsList = new ArrayList<>();
        //Reading the data
        while(allGuests.moveToNext()) {
            int guestID = allGuests.getInt(allGuests.getColumnIndex(GUEST_ID_COLUMN));
            String guestTitle = allGuests.getString(allGuests.getColumnIndex(TITLE_COLUMN));
            String firstName = allGuests.getString(allGuests.getColumnIndex(FIRST_NAME_COLUMN));
            String lastName = allGuests.getString(allGuests.getColumnIndex(LAST_NAME_COLUMN));
            int noOfGuests = allGuests.getInt(allGuests.getColumnIndex(NUMBER_OF_GUESTS_COLUMN));
            String phoneNumber = allGuests.getString(allGuests.getColumnIndex(PHONE_NUMBER_COLUMN));

            Guest guest = new Guest(guestID, guestTitle, firstName, lastName, noOfGuests, phoneNumber);
            guestsList.add(guest);

        }
        //close the cursor
        allGuests.close();
        //database helper returning guests list
        return guestsList;
    }

    private int room_id;
    private String roomName;
    private int numberOfRoom;
    private double price;

    public List<Room> getAllRooms() {
        String getAll = "SELECT * FROM " + TABlE_ROOM;
        Cursor allRooms = getReadableDatabase().rawQuery(getAll, null);
        List<Room> roomsList = new ArrayList<>();
        //Reading the data
        while(allRooms.moveToNext()) {
            int roomID = allRooms.getInt(allRooms.getColumnIndex(GUEST_ID_COLUMN));
            String roomName = allRooms.getString(allRooms.getColumnIndex(ROOM_NAME_COLUMN));
            int numberOfRoom = allRooms.getInt(allRooms.getColumnIndex(NUMBER_OF_ROOM_COLUMN));
            double price = allRooms.getDouble(allRooms.getColumnIndex(PRICE_COLUMN));

            Room room = new Room(roomID, roomName, numberOfRoom, price);
            roomsList.add(room);

        }
        //close the cursor
        allRooms.close();
        //database helper returning guests list
        return roomsList;
    }

   /** public List<Reservation> getAllReservations() {
        String getAll = "SELECT * FROM " + TABlE_RESERVATION;
        Cursor allReservations = getReadableDatabase().rawQuery(getAll, null);
        List<Reservation> reservationsList = new ArrayList<>();
        //Reading the data
        while(allReservations.moveToNext()) {
            int reservationID = allReservations.getInt(allReservations.getColumnIndex(RESERVATION_ID_COLUMN));
            Time checkInTime = Time.valueOf(allReservations.getString(allReservations.getColumnIndex(ROOM_NAME_COLUMN)));
            Time checkOutTime = Time.valueOf(allReservations.getString(allReservations.getColumnIndex(CHECK_OUT_TIME_COLUMN)));
            Date checkInDate = allReservations.getString(allReservations.getString(allReservations.getColumnIndex(CHECK_IN_DATE_COLUMN));
            Date checkOutDate = allReservations.getString(allReservations.getString(allReservations.getColumnIndex(CHECK_OUT_DATE_COLUMN));


            String firstName = allReservations.getString(allReservations.getColumnIndex(FIRST_NAME_COLUMN));
            String lastName = allReservations.getString(allReservations.getColumnIndex(FIRST_NAME_COLUMN));
            Day day = Enum.valueOf(Day.class, allReservations.getString(allReservations.getColumnIndex(DAY_OF_WEEK_COLUMN)));
            String roomName = allReservations.getString(allReservations.getColumnIndex(ROOM_NAME_COLUMN));
            int numberOfRoom = allReservations.getInt(allReservations.getColumnIndex(NUMBER_OF_ROOM_COLUMN));
            int numberOfGuests = allReservations.getInt(allReservations.getColumnIndex(NUMBER_OF_GUESTS_COLUMN));
            int numberOfNights = allReservations.getInt(allReservations.getColumnIndex(NUMBER_OF_NIGHTS_COLUMN));
            double totalPrice = allReservations.getDouble(allReservations.getColumnIndex(TOTAL_PRICE_COLUMN));

            Reservation reservation = new Reservation(reservationID, checkInTime, checkOutTime, checkInDate, checkOutDate);
            //Log.d("TAG_X",reservation.toString());
            //add reservation to the reservations array list
            reservationsList.add(reservation);
        }
        //close the cursor
        allReservations.close();
        //database helper returning reservations list
        return reservationsList;
    }
*/

}
