package com.example.mycode.util

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.mycode.databinding.FragmentCountAndNumBinding


class NumberAndAmountFragment : Fragment() {
    lateinit var binding: FragmentCountAndNumBinding
    private lateinit var action: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        action = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            var phoneNumber: String? = null
            val uri: Uri? = it.data?.data
            var cursor = activity?.contentResolver?.query(uri!!, null, null, null, null);
            cursor!!.moveToFirst()
            val phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
             val nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
             var name = cursor.getString(nameIndex)
            phoneNumber = cursor.getString(phoneIndex)


             binding.etNumberLayout.setText(filterStringNum(phoneNumber))

            binding.tvNameContact.text = name





        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountAndNumBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

          binding.tvNameOperation.text = strTitleOperation



        binding.selectContacts.setOnClickListener {
            selectContact()
        }

        binding.btnOkLayout.setOnClickListener {
             clickOk()
        }


    }



    private fun clickOk() {

        var num = binding.etNumberLayout.text.toString()
        var amount = binding.etAmountLayout.text.toString()

        if ((num.length == 11 && amount.toInt() >= 10))
         {
            var i = Intent(Intent.ACTION_CALL)
            i.data = Uri.fromParts("tel", "$codeStart$num*$amount#", null)
            startActivity(i)


        }
        else{
            Toast.makeText(context, "ادخل رقم صحيح و قيمة صحيحة", Toast.LENGTH_SHORT)
                .show()
        }
    }


    private fun selectContact() {
        var intent = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
        action.launch(intent)
    }


    private fun filterStringNum(str1: String): StringBuilder {
        var str = str1
        if (str.startsWith("+2")) {
            str = str.removePrefix("+2")
        }
        var strNum = StringBuilder()
        for (i in str.indices) {
            if (str[i] != ' ') {
                strNum.append(str[i])
            }
        }
        return strNum
    }




    companion object {

        private var instance: NumberAndAmountFragment? = null

        lateinit var strTitleOperation : String
        lateinit var codeStart : String

        fun getInstance(): NumberAndAmountFragment {
            if (instance == null) {
                instance = NumberAndAmountFragment()
            }
            return instance!!
        }


    }

}