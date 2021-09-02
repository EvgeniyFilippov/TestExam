package com.filipau.domain.usecase

import com.filipau.domain.outcome.Outcome
import kotlinx.coroutines.flow.Flow
import java.io.Serializable

abstract class UseCaseOutcomeFlow<Params : Any, Result> : Serializable {

    private var mParams: Params? = null

    protected abstract fun buildOutcomeFlow(params: Params?): Flow<Outcome<Result>>

    abstract val mIsParamsRequired: Boolean

    fun setParams(params: Params): UseCaseOutcomeFlow<Params, Result> {
        mParams = params
        return this
    }

    fun execute(): Flow<Outcome<Result>> {
        require(!(mIsParamsRequired && mParams == null)) { "Params are required" }
        return buildOutcomeFlow(mParams)
    }

}