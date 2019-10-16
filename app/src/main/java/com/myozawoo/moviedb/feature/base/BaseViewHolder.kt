package com.myozawoo.moviedb.feature.base

import android.view.View
import android.widget.Toast


open class BaseViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {

    fun showToast(message: String) {
        if (message != "") Toast.makeText(itemView.context, message, Toast.LENGTH_SHORT).show()
    }

}