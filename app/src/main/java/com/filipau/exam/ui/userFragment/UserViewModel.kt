package com.filipau.exam.ui.userFragment

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.filipau.data.room.UserEntity
import com.filipau.domain.dto.room.RoomUserDto
import com.filipau.domain.dto.user.UserDto
import com.filipau.domain.outcome.Outcome
import com.filipau.domain.repository.DatabaseUserRepository
import com.filipau.domain.usecase.impl.GetUsersUseCase
import com.filipau.exam.base.mvvm.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.Flow
import org.koin.core.logger.KOIN_TAG

class UserViewModel(
    savedStateHandle: SavedStateHandle,
    private val mGetUsersUseCase: GetUsersUseCase,
    private val mDatabaseUserRepository: DatabaseUserRepository,

    ) : BaseViewModel(savedStateHandle) {

    fun getNewsFlow(id: String): Flow<Outcome<UserDto>> =
        mGetUsersUseCase.setParams(id).execute()

    fun saveToDBfromApi(listUserDtoFromApi: UserDto) {
        Flowable.just(listUserDtoFromApi)
            .map { item ->
                mDatabaseUserRepository.add( RoomUserDto(
                            item.id,
                            item.name,
                            item.username,
                            item.email,
                            item.website,
                            item.phone,
                            item.address.city
                        )
                )
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                Log.d(KOIN_TAG, "Saved to DB")
            }, {
                Log.d(KOIN_TAG, it.message.toString())
            })
    }

}