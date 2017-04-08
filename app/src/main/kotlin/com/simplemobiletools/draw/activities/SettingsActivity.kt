package com.simplemobiletools.draw.activities

import android.os.Bundle
import com.simplemobiletools.commons.extensions.updateTextColors
import com.simplemobiletools.draw.Config
import com.simplemobiletools.draw.R
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : SimpleActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }

    override fun onResume() {
        super.onResume()

        setupCustomizeColors()
        setupBrushSize()
        updateTextColors(settings_holder)
    }

    private fun setupCustomizeColors() {
        settings_customize_colors_holder.setOnClickListener {
            startCustomizationActivity()
        }
    }

    private fun setupBrushSize() {
        settings_show_brush_size.isChecked = Config.newInstance(this).showBrushSizeEnabled
        settings_show_brush_size_holder.setOnClickListener {
            settings_show_brush_size.toggle()
            Config.newInstance(this).showBrushSizeEnabled = settings_show_brush_size.isChecked
        }
    }
}
