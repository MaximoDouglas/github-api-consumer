package com.maximo.douglas.githubconsumer.testutils

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

open class CoroutineContextProvider {

    open val Main: CoroutineContext by lazy { Dispatchers.Main }
    open val IO: CoroutineContext by lazy { Dispatchers.IO }

}