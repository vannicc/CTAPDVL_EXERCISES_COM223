package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var textViewProfileName: TextView
    private lateinit var imageViewProfilePic: ImageView
    private lateinit var buttonEditProfile: Button
    private lateinit var imageViewPostNow: ImageView
    private lateinit var imageViewPost: ImageView

    // Request codes for image selection
    private val PICK_PROFILE_IMAGE_REQUEST = 1
    private val PICK_POST_IMAGE_REQUEST = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile) // Make sure this is your correct layout file name

        // Initialize views
        textViewProfileName = findViewById(R.id.textViewProfileName)
        imageViewProfilePic = findViewById(R.id.imageViewProfilePic)
        buttonEditProfile = findViewById(R.id.buttonEditProfile)
        imageViewPostNow = findViewById(R.id.imageViewPostNow)
        imageViewPost = findViewById(R.id.imageViewPost)

        // Get data from Intent
        val userName = intent.getStringExtra("textViewUserName")

        // Set it to TextView
        textViewProfileName.text = userName

        // Set click listener for the edit profile button
        buttonEditProfile.setOnClickListener {
            openGalleryForProfile()
        }

        // Set click listener for the post now image view
        imageViewPostNow.setOnClickListener {
            openGalleryForPost()
        }
    }

    // Function to open the gallery for profile image
    private fun openGalleryForProfile() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_PROFILE_IMAGE_REQUEST)
    }

    // Function to open the gallery for post image
    private fun openGalleryForPost() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_POST_IMAGE_REQUEST)
    }

    // Handle the result of the image selection
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            val imageUri: Uri = data.data!!

            when (requestCode) {
                PICK_PROFILE_IMAGE_REQUEST -> {
                    // Update profile image
                    imageViewProfilePic.setImageURI(imageUri)
                }
                PICK_POST_IMAGE_REQUEST -> {
                    // Update post image
                    imageViewPost.setImageURI(imageUri)
                }
            }
        }
    }
}