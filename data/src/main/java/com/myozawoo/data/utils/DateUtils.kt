package com.myozawoo.data.utils

import java.text.SimpleDateFormat
import java.util.*

class DateUtils{

    fun convertDate(value: String): String{
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = sdf.parse(value)
        return SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(date).toString()
    }

}