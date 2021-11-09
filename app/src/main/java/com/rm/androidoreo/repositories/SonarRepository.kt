package com.rm.androidoreo.repositories

import com.rm.androidoreo.repositories.entities.HiltDemo
import javax.inject.Inject

class HiltDemoRepository @Inject constructor() {
    fun getHiltDemo() = HiltDemo("foo", "Hello, Dave")
}
