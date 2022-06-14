package net.muazkadan.uicomponent

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import androidx.appcompat.widget.AppCompatEditText
import com.google.android.material.textfield.TextInputEditText

/**
 * @author muaz
 * Created on 6/14/2022.
 */
class CNEditText : AppCompatEditText {
    @JvmOverloads constructor(context: Context) : super(context)
    @JvmOverloads constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    @JvmOverloads constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )

    override fun onKeyPreIme(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            clearFocus()
        }
        return super.onKeyPreIme(keyCode, event)
    }
}