package educa.iesam.karamon.electroniccity.core.cache

import android.content.Context
import android.content.SharedPreferences
import educa.iesam.karamon.electroniccity.R
import educa.iesam.karamon.electroniccity.time.SuperHeroeAppTime

interface SuperHeroeAppCache {
    fun updateTime(keyUpdateTime: String)
    fun isExpired(keyIsExpired: String, timeToLive: Long): Boolean

    class SuperHeroeTimeToLive(
        private val context: Context,
        private val updateTime: SuperHeroeAppTime
    ) : SuperHeroeAppCache {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            context.getString(R.string.app_cache), Context.MODE_PRIVATE
        )

        override fun updateTime(keyUpdateTime: String) {
            sharedPreferences.edit().apply {
                putLong(keyUpdateTime, updateTime.currentTime())
                apply()
            }
        }

        override fun isExpired(
            keyIsExpired: String,
            timeToLive: Long
        ): Boolean {
            val timeSaved = sharedPreferences.getLong(keyIsExpired, -1)
            return (updateTime.currentTime() - timeSaved) >= timeToLive
        }

    }
}