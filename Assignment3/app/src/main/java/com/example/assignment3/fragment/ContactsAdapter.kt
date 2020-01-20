package com.example.assignment3.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment3.R
import com.example.assignment3.models.Contact

class ContactsAdapter(mContactList: ArrayList<Contact>?) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
    private var mContactList: ArrayList<Contact>? = mContactList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return if (null == mContactList) 0
        else mContactList!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtName.text = mContactList!![position].name.last + " "+ mContactList!![position].name.first
        holder.txtNum.text = mContactList!![position].cell
    }


    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName: TextView = itemView.findViewById(R.id.txtName)
        var txtNum: TextView = itemView.findViewById(R.id.txtNum)

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_contact, parent, false)
                return ViewHolder(view)
            }
        }
    }
}