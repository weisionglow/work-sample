package com.example.myapplication.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.LayoutInflater
import androidx.annotation.NonNull
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R

class DialogUtil(val context: Context?) {

    private var alertDialog: AlertDialog? = null
    private var builder: AlertDialog.Builder = AlertDialog.Builder(context)

    fun show(
        title: String? = null,
        message: String?,
        positiveFun: ((DialogInterface) -> Unit?)? = null
    ) {
        if (!(context as Activity).isFinishing) {
            if (alertDialog != null && alertDialog?.isShowing == true) {
                alertDialog?.dismiss()
            }
            val builder = AlertDialog.Builder(context, R.style.ThemeOverlay_AppCompat_Dialog_Alert)

            if (title != null)
                builder.setTitle(title)

            if (message != null && message.isNotEmpty())
                builder.setMessage(message)
            else
                builder.setMessage("")

            builder.setCancelable(false)
            builder.setPositiveButton(android.R.string.yes) { dialog, _ ->
                if (positiveFun != null)
                    positiveFun.invoke(dialog)
                else
                    dialog.dismiss()
            }
            alertDialog = builder.create()
            alertDialog?.show()
        }
    }

    fun showCustomDialog(
        title: String? = null,
        message: String? = null,
        positiveText: String? = null,
        positiveFun: ((DialogInterface) -> Unit?)? = null,
        negativeText: String? = null,
        negativeFun: ((DialogInterface) -> Unit?)? = null
    ) {
        if (title != null)
            builder.setTitle(title)

        if (message != null)
            builder.setMessage(message)

        builder.setCancelable(true)

        if (positiveFun != null) {
            builder.setPositiveButton(positiveText ?: "Yes") { dialog, _ ->
                positiveFun.invoke(dialog)
            }
        }
        if (negativeFun != null) {
            builder.setNegativeButton(negativeText ?: "No") { dialog, _ ->
                negativeFun.invoke(dialog)
            }
        }

//        builder.setNeutralButton("Maybe") { dialog, which ->
//            Toast.makeText(
//                applicationContext,
//                "Maybe", Toast.LENGTH_SHORT
//            ).show()
//        }
        builder.show()
    }
}