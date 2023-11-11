package com.example.myapplication.presenter.ui.gym_screen
import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
  import com.example.myapplication.presenter.ui.loader_screen.CircularLoader
import com.example.myapplication.presenter.ui.message_screen.MessageText
import com.example.gymapplication.presenter.viewmodels.GymsViewModel
import com.example.myapplication.utils.Status

@Composable
fun GymScreen(vm: GymsViewModel,context: Context) {
    var gymState = vm.state
    when (gymState.status) {
        Status.SUCCESS -> {

             LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                contentPadding = PaddingValues(8.dp)
            ) {
                item {
                    Text(text = "Gym Application")
                }
                items(gymState?.data!!) { gym ->
                    GymItem(gym = gym,context)
                }

            }
        }
        Status.NETWORK_ERROR -> {
            if (gymState.data.isNullOrEmpty()){
                MessageText( "List is Empty please connect to the internet")

            }else{
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    contentPadding = PaddingValues(8.dp)
                ) {
                    item {
                        Text(text = "Gym Application")
                    }
                    items(gymState?.data!!) { gym ->
                        GymItem(gym = gym,context)
                    }

                }

            }
        }
        Status.LOADING -> {
            CircularLoader()
        }
        Status.ERROR -> {
            if (gymState.data!!.isNullOrEmpty())
            MessageText(gymState.message.toString())
            else{
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    contentPadding = PaddingValues(8.dp)
                ) {
                    item {
                        Text(text = gymState.message.toString())
                    }
                    items(gymState?.data!!) { gym ->
                        GymItem(gym = gym,context)
                    }

                }
            }
        }
    }


}
