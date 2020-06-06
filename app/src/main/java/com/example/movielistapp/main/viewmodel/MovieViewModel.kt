package  com.example.movielistapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movielistapp.main.data.model.MovieRequest
import com.example.movielistapp.main.data.model.MovieResponse
import com.example.movielistapp.main.data.repository.MovieRepository

class MovieViewModel : ViewModel() {

    private lateinit var mutableLiveData: MutableLiveData<MovieResponse>
    private lateinit var repository: MovieRepository

    fun init() {
        repository = MovieRepository().getInstance()
        val params = MovieRequest(Constants.API_KEY, "1")
        mutableLiveData = repository.getMovies(params)
    }

    fun getRepository(): MutableLiveData<MovieResponse> {
        return mutableLiveData
    }
}
