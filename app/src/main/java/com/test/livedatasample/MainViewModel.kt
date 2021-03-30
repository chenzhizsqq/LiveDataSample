package com.test.livedatasample

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    //MutableLiveData   可变实时数据
    //在这里定义一个变量text，说明这个变量可以在给定义了setLifecycleOwner后的ViewModel的Activity使用。
    private var text: MutableLiveData<String>? = null

    //这里，就给activity_main.xml的android:text="@{viewModel.text}"添加了相应的函数。
    //只需要写上LiveData<String> getText()就可以了。不用在像之前的写上view.findViewById(R.id.***)的样式。
    //要用上MutableLiveData与xml页面的viewModel.text对应。就一定要用上LiveData<String> getText()。
    fun getText(): LiveData<String> {

        //而且getText()函数中，一定下加上if (text == null) {text = new MutableLiveData<>();}这种如果变量没有了，就要再创建变量。
        //其实它的作用就是怕次变量已经给Android清除掉了，让变量再创建。
        //我也确实多次试过某变量总是找不到的经历，也猜想到是被android系统自己清除掉了。
        if (text == null) {
            text = MutableLiveData()
        }
        return text!!
    }

    //而这里就是给activity_main.xml的android:onClick="@{viewModel::onClick}"添加了对应的函数。
    fun onClick(view: View?) {
        text!!.value = "time: " + System.currentTimeMillis()
    }
}