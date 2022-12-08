package eni.testskotlin.demofragments.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import eni.testskotlin.R
import eni.testskotlin.databinding.ActivityTestFragmentsBinding

class TestFragmentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityTestFragmentsBinding>(this, R.layout.activity_test_fragments)
    }
}