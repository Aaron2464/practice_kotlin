package com.example.assignment3.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment3.R
import com.example.assignment3.databinding.FragmentContactsBinding
import com.example.assignment3.models.Contact
import com.example.assignment3.models.ContactList
import com.example.assignment3.network.ContactClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContactsFragment : Fragment() {
    private var mContactList: ArrayList<Contact>? = null
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentContactsBinding>(
            inflater, R.layout.fragment_contacts, container, false
        )
        recyclerView = binding.recyclerView
        binding.recyclerView.adapter = ContactsAdapter(mContactList)
        binding.recyclerView.setHasFixedSize(true)
//        val contactsViewModel = ViewModelProviders.of(this).get(ContactsViewModel!!::class.java)
//        binding.contactsViewModel= contactsViewModel
//        contactsViewModel.navigateToSleepTracker.observe(this, Observer {
//            if(it == true){
//                this.findNavController().navigate(.actionSleepQualityFragmentToSleepTrackerFragment())
//                sleepQualityViewModel.doneNavigating()
//            }
//        })
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val call: Call<ContactList> = ContactClient.getContacts(10)
        call.enqueue(object : Callback<ContactList> {
            override fun onResponse(call: Call<ContactList>, response: Response<ContactList>) {
                if (response.isSuccessful) {
                    mContactList = response.body()?.contactList
                    recyclerView.adapter = ContactsAdapter(mContactList)
                    (recyclerView.adapter as ContactsAdapter).notifyDataSetChanged()
                    for (contact in mContactList!!) {

                    }
                }
            }

            override fun onFailure(call: Call<ContactList>, t: Throwable) {
                Log.d("TAG", "t: " + t.message)
            }
        })
    }

}