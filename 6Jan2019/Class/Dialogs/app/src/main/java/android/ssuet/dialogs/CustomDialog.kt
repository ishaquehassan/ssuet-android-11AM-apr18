package android.ssuet.dialogs

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.View
import kotlinx.android.synthetic.main.custom_dialog_view.*

class CustomDialog(var context: Activity) :Dialog(context){

    init {
        setContentView(R.layout.custom_dialog_view)

        val display = DisplayMetrics()

        context.windowManager.defaultDisplay.getMetrics(display)

        window.setBackgroundDrawable(ColorDrawable(android.R.color.transparent))
        window.setGravity(Gravity.BOTTOM)
        window.attributes.windowAnimations = R.style.dialog_animation
        main_layout.layoutParams.width = display.widthPixels

        dismiss.setOnClickListener {
            dismiss()
        }

    }



}