package com.filipau.data.ext

import com.filipau.domain.outcome.Outcome
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

fun <InputType> modifyFlowOutcome(
    data: Flow<InputType>
): Flow<Outcome<InputType>> {
    return data.executeOutcome()
}

fun <InputType> Flow<InputType>.executeOutcome(): Flow<Outcome<InputType>> =
    this.flowOn(Dispatchers.IO)
        .map { list -> Outcome.success(list) }
        .onStart { emit(Outcome.loading(true)) }
        .onCompletion { emit(Outcome.loading(false)) }
        .catch { ex -> emit(Outcome.failure(ex)) }

