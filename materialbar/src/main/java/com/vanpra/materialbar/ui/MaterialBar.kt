package com.vanpra.materialbar.ui

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.vanpra.materialbar.R
import kotlinx.android.synthetic.main.material_bar_layout.view.*


class MaterialBarError(message: String) : Exception(message)

class MaterialBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleRes) {

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.material_bar_layout, this, true)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.MaterialBar, 0, 0
            )

            val text = typedArray.getText(R.styleable.MaterialBar_title)
            val rightIconDrawable = typedArray.getDrawable(R.styleable.MaterialBar_right_icon)
            val leftIconDrawable = typedArray.getDrawable(R.styleable.MaterialBar_left_icon)

            if (rightIconDrawable != null) {
                rightIcon.setImageDrawable(rightIconDrawable)
                rightIcon.visibility = View.VISIBLE
            }

            if (leftIconDrawable != null) {
                leftIcon.setImageDrawable(leftIconDrawable)
                leftIcon.visibility = View.VISIBLE
            }

            title.text = text

            typedArray.recycle()
        }
    }

    fun setRightIconListener(listener: () -> Unit) {
        rightIcon.setOnClickListener {
            listener()
        }
    }

    fun setLeftIconListener(listener: () -> Unit) {
        leftIcon.setOnClickListener {
            listener()
        }
    }

    fun setRightIcon(icon: Int) {
        val drawable = context.getDrawable(icon)
        rightIcon.setImageDrawable(drawable)
        rightIcon.visibility = View.VISIBLE
    }

    fun setLeftIcon(icon: Int) {
        val drawable = context.getDrawable(icon)
        leftIcon.setImageDrawable(drawable)
        leftIcon.visibility = View.VISIBLE
    }

    fun setTitle(text:String) {
        title.text = text
    }

    fun setBarClickListener(listener: () -> Unit) {
        materialBar.setOnClickListener {
            listener()
        }
    }
}