package  com.example.movielistapp.main.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results") val results: ArrayList<Movie>
)