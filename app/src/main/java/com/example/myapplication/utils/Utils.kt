package com.example.myapplication.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

class Utils {

    companion object{
        fun shareToFaceBook(context: Context,text:String){
            try {
                val intent1 = Intent()
                intent1.setClassName(
                    "com.facebook.katana",
                    "com.facebook.katana.activity.composer.ImplicitShareIntentHandler"
                )
                intent1.action = "android.intent.action.SEND"
                intent1.type = "text/plain"
                intent1.putExtra("android.intent.extra.TEXT", text)
                context.   startActivity(intent1)
            } catch (e: Exception) {
                val sharerUrl =
                    "https://www.facebook.com/sharer/sharer.php?u=${text}"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl))
                context.  startActivity(intent)
            }
        }
    }
}