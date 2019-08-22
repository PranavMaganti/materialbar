package com.vanpra.materialbar.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.vanpra.materialbar.R
import kotlinx.android.synthetic.main.material_bar_layout.view.*
import kotlin.properties.Delegates


class MaterialBarError(message: String) : Exception(message)

class MaterialBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleRes) {

    var rightIcon: Int? = null
        set(value) {
            field = value
            val drawable = context.getDrawable(value!!)
            right_icon.setImageDrawable(drawable)
            right_icon.visibility = View.VISIBLE
        }

    var leftIcon: Int? = null
        set(value) {
            field = value
            val drawable = context.getDrawable(value!!)
            left_icon.setImageDrawable(drawable)
            left_icon.visibility = View.VISIBLE
        }

    var title: String = "Material Bar"
        set(value) {
            field = value
            titleTxt.text = value
        }

    var rightIconListener: (() -> Unit) = {}
        set(value) {
            field = value
            right_icon.setOnClickListener {
                value()
            }
        }

    var leftIconListener: (() -> Unit) = {}
        set(value) {
            field = value
            left_icon.setOnClickListener {
                value()
            }
        }

    var barClickListener: (() -> Unit) = {}
        set(value) {
            field = value
            materialBar.setOnClickListener {
                value()
            }
        }

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
                right_icon.setImageDrawable(rightIconDrawable)
                right_icon.visibility = View.VISIBLE
            }

            if (leftIconDrawable != null) {
                left_icon.setImageDrawable(leftIconDrawable)
                left_icon.visibility = View.VISIBLE
            }

            titleTxt.text = text

            typedArray.recycle()
        }
    }
}