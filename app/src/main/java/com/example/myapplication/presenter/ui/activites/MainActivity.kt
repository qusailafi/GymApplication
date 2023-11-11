package com.example.myapplication.presenter.ui.activites
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
 import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
 import androidx.hilt.navigation.compose.hiltViewModel
  import com.example.myapplication.presenter.ui.theme.GymApplicationTheme
import com.example.gymapplication.presenter.viewmodels.GymsViewModel
import com.example.myapplication.presenter.ui.gym_screen.GymScreen
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GymList()
                }
            }
        }
    }


    @Composable
    fun GymList() {
        val vm: GymsViewModel = hiltViewModel()
        GymScreen(vm,this)

    }

}