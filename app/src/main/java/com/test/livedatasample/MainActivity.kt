package com.test.livedatasample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.test.livedatasample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //新建一个关于LiveData的类
    private val viewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //下面的ActivityMainBinding，就是activity_main.xml的对应类。这个Android固定的格式
        //如果要互相绑定好，这里就需要用上下面的格式。例如activity_main.xml就等于ActivityMainBinding
        //其实就是ActivityMain + Binding，这个官方固定的
        var binding: ActivityMainBinding? = null


        //在这里就是说明了这个binding是对应着R.layout.activity_main，那么就可以在R.layout.activity_main中使用
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //setLifecycleOwner     设置生命周期所有者
        //在这里一定要用LifecycleOwner设定，才能够说明用上了LiveData
        binding.lifecycleOwner = this

        //在这里一定要用setViewModel设定，才能够说明对应了MainViewModel
        binding.viewModel = viewModel
    }
}