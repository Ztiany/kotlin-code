package core.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

/**
 * builders
 */
suspend fun main() {
    //flowExample()
    //flowOfExample()
    asFlowExample()
}

suspend fun asFlowExample() {
    (1..10).asFlow().collect {
        println(it)
    }
}

suspend fun flowOfExample() {
    flowOf(1, 2, 3, 4).collect {
            println(it)
    }
}

suspend fun flowExample() {
    flow {
        for (i in 0..10) {
            emit(i)
        }
    }.collect {
        println(it)
    }
}
