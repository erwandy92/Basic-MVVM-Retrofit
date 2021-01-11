package com.erwandy.framework.basic_mvvm_retrofit.data.repository

import com.erwandy.framework.basic_mvvm_retrofit.data.model.UserData
import java.util.concurrent.Executors

class InfoRepository {
    fun loadInfo(task: OnTaskFinish) {
        Executors.newSingleThreadExecutor().submit {
            val userData = UserData()
            userData.userName = "jake"
            userData.userAge = 30
            Thread.sleep(3000)
            task.onFinish(userData)
        }
    }
}
interface OnTaskFinish {
    fun onFinish(data: UserData)
}
