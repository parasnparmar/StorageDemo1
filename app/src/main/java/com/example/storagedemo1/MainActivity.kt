package com.example.storagedemo1

import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

       var externalStorageState =  Environment.getExternalStorageState()
        if (externalStorageState.equals(Environment.MEDIA_MOUNTED)){
            Log.d("Tag","Media Mounted Storage")
        }
        if(externalStorageState.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            Log.d("Tag","Media Mounted Read Only Storage")
        }
        if(externalStorageState.equals(Environment.MEDIA_UNMOUNTED)){
            Log.d("Tag","Media Unmounted Storage")
        }

        var rootDir = Environment.getRootDirectory()
        Log.d("Tag Root","Name: ${rootDir.name} -- Path: ${rootDir.path} -- FreeSpace: ${rootDir.freeSpace} -- TotalSpace: ${rootDir.totalSpace}")
        Log.d("Tag Root","absoulte path: ${rootDir.absolutePath} -- conoical path: ${rootDir.canonicalPath}")

        var publicStorageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
        Log.d("Tag Public Storage","name: ${publicStorageDir.name} -- TotalSpace: ${publicStorageDir.totalSpace} -- FreeSpace: ${publicStorageDir.freeSpace}")
        Log.d("Tag Public Storage","Path: ${publicStorageDir.path} -- AbsoultePath: ${publicStorageDir.absolutePath} -- ConanicalPath: ${publicStorageDir.canonicalPath}")

        var moviesStrorageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)
        Log.d("Tag Movie","name: ${moviesStrorageDir.name} -- TotalSpace: ${moviesStrorageDir.totalSpace} -- FreeSpace: ${moviesStrorageDir.freeSpace}")
        Log.d("Tag Movie","Path: ${moviesStrorageDir.path} -- AbsolutePath: ${moviesStrorageDir.absolutePath} -- ConicolPath: ${moviesStrorageDir.canonicalPath}")

        var DCIMStorageDir = getExternalFilesDir(Environment.DIRECTORY_DCIM)
        if (DCIMStorageDir != null) {                   //written type is nullable so we need to surround it wiht if
            Log.d("Tag DCIM", " Name: ${DCIMStorageDir.name} -- TotalSpace ${DCIMStorageDir.totalSpace} FreeSpace ${DCIMStorageDir.freeSpace}")
            Log.d("Tag DCIM","Path: ${DCIMStorageDir.path} -- AbsolutePath: ${DCIMStorageDir.absolutePath} -- ConicolPath: ${DCIMStorageDir.canonicalPath}")
        }

        var dataDir = Environment.getDataDirectory()
        Log.d("Tag dataDir", " Name: ${dataDir.name} -- TotalSpace ${dataDir.totalSpace} FreeSpace ${dataDir.freeSpace}")
        Log.d("Tag dataDir","Path: ${dataDir.path} -- AbsolutePath: ${dataDir.absolutePath} -- ConicolPath: ${dataDir.canonicalPath}")

        var fileOutputStream : FileOutputStream = openFileOutput("text_file1",AppCompatActivity.MODE_PRIVATE)
        fileOutputStream.write("Hello Android".toByteArray())
        fileOutputStream.write("This is First File Created!!!!".toByteArray())
        fileOutputStream.close()

        var fileInputStream : FileInputStream = openFileInput("text_file1")
        var count = 0
        var data  = ByteArray(1024*1)
        count = fileInputStream.read(data)
        Log.d("Tag File Data","Data: $count")

        while (count != -1){
            Log.d("Tag", String(data,0,count))
            count = fileInputStream.read(data)
        }
        fileInputStream.close()
}
}