package com.maximo.douglas.githubconsumer.viewmodels.utils

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class TestContextProvider : com.maximo.douglas.commons.utils.CoroutineContextProvider() {

    override val Main: CoroutineContext = Dispatchers.Unconfined
    override val IO: CoroutineContext = Dispatchers.Unconfined

}