package com.srv.secftp.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

// Transfer files between the server and the client
class FileTransferService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        // Return null as this is a started service
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Handle file transfer logic here
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        // Clean up resources if needed
    }
}
