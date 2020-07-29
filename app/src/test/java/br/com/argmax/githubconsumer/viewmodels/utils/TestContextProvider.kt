package br.com.argmax.githubconsumer.viewmodels.utils

import br.com.argmax.githubconsumer.utils.CoroutineContextProvider
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class TestContextProvider : CoroutineContextProvider() {

    override val Main: CoroutineContext = Dispatchers.Unconfined
    override val IO: CoroutineContext = Dispatchers.Unconfined

}