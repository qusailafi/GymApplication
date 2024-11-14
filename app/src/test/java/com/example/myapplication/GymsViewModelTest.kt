package com.example.myapplication
import com.example.gymapplication.presenter.viewmodels.GymsViewModel
import com.example.myapplication.data.local.GymsDao
import com.example.myapplication.data.remote.ApiServices
import com.example.myapplication.data.repoImpl.RepoImpl
import com.example.myapplication.domain.model.GymsResponseItem
import com.example.myapplication.domain.usecase.GymsUseCase
import com.example.myapplication.utils.DummyGym
import com.example.myapplication.utils.Status
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Test

@ExperimentalCoroutinesApi
class GymsViewModelTest {
    val dispacher = StandardTestDispatcher()

    val scope = TestScope(dispacher)

    @Test
    fun checkLoadingState() = scope.runTest {
        val viewModel = getViewModel()
        val state = viewModel.state.status
        assert(
            state == Status.LOADING
        )
    }

    @Test
    fun checkListIsEmpty()=scope.runTest {
        val viewModel = getViewModel()
        val listSize = viewModel.state.data?.size
        assert(
            listSize == 0
        )
    }

    @Test
    fun checkListIsNotEmpty()=scope.runTest {
        val viewModel = getViewModel()
        viewModel.state.data?.addAll(DummyGym.getGymList())
        val listSize = viewModel.state.data?.size
        assert(
            listSize != 0
        )
    }

    private fun getViewModel(): GymsViewModel {
        val gymRepo = RepoImpl(MockApiServices(), GymDaoMock())

        val gymsUseCase = GymsUseCase(gymRepo)
        return GymsViewModel(gymsUseCase, dispacher)

    }

    class MockApiServices : ApiServices {
        override suspend fun getGyms(): List<GymsResponseItem> {
            return DummyGym.getGymList()
        }

    }

    class GymDaoMock : GymsDao {
        val gyms = HashMap<Int, GymsResponseItem>()

        override suspend fun getAllGyms(): List<GymsResponseItem> {
            return gyms.values.toList()

        }

        override suspend fun addAllGyms(allGyms: List<GymsResponseItem>) {
            allGyms.forEach {
                this
                    .gyms[it.id] = it

            }
        }

    }
}