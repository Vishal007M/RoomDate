package com.cyclushub.roomdate

import androidx.room.TypeConverter
import java.util.Date

class Convertors {

    @TypeConverter
    fun fromDateToLong(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun fromLongToDate(long: Long): Date {
        return  Date(long)
    }

}