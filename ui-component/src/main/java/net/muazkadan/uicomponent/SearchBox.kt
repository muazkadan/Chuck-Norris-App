package net.muazkadan.uicomponent

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.view.isVisible
import net.muazkadan.uicomponent.databinding.ViewSearchBoxBinding

/**
 * @author muaz
 * Created on 6/15/2022.
 */
class SearchBox @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding: ViewSearchBoxBinding by lazy {
        ViewSearchBoxBinding.inflate(LayoutInflater.from(context), this, true)
    }

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CNSearchBox,
            0, 0
        ).apply {
            try {
                binding.etSearch.hint = getString(R.styleable.CNSearchBox_et_hint)
            } finally {
                recycle()
            }
        }
    }

    var text: String = ""
        set(value) {
            field = value
            binding.etSearch.apply {
                setText(field)
                binding.ivCancel.isVisible = value.isNotBlank()
                binding.btnSearch.isVisible = value.isNotBlank()
            }
        }
        get() = binding.etSearch.text.toString()

    init {
        setOnCancelClickListener()
    }

    private fun setOnCancelClickListener() {
        binding.ivCancel.setOnClickListener { text = "" }
    }

    fun setOnBackClickListener(callBack: () -> Unit) {
        binding.ivSearch.setOnClickListener {
            callBack()
        }
    }

    fun setTextWatcher() {
        binding.etSearch.addTextChangedListener(textWatcher)
    }

    fun edittextRequestFocus() =
        binding.etSearch.requestFocus()

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
        override fun afterTextChanged(s: Editable?) = Unit
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val newText = s?.toString().orEmpty()
            binding.ivCancel.isVisible = newText.isNotBlank()
            binding.btnSearch.isVisible = newText.isNotBlank()
        }
    }
}
