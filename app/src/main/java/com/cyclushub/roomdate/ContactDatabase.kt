package com.cyclushub.roomdate

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Contact::class], version = 1)
@TypeConverters(Convertors::class)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object{
        @Volatile
        private var INSTANSE: ContactDatabase? = null

        fun getDatabase(context: Context): ContactDatabase {
            if (INSTANSE == null) {
                synchronized(ContactDatabase::class.java) {
                    INSTANSE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "contact_database").build()
                }

            }
            return INSTANSE!!
        }
    }

}