package com.cankutboratuncer.alicisindan.activities.ui.main.forum.category;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import com.cankutboratuncer.alicisindan.activities.utilities.LocalSave;
import com.cankutboratuncer.alicisindan.databinding.ActivityForumAddCategoryBinding;
import com.cankutboratuncer.alicisindan.databinding.ActivityForumEditBinding;
import com.cankutboratuncer.alicisindan.databinding.ActivityPostEditBinding;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ForumEditActivity extends AppCompatActivity {

    private ActivityForumEditBinding binding;
    private String encodedImage;
    private LocalSave localSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForumEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        binding.subTitle.setText(category);
        binding.image.setClipToOutline(true);
        localSave = new LocalSave(getApplicationContext());
        setListeners();
    }


    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private String encodeImage(Bitmap bitmap) {
        int previewWidth = 150;
        int previewHeight = bitmap.getHeight() * previewWidth / bitmap.getWidth();
        Bitmap previewBitmap = Bitmap.createScaledBitmap(bitmap, previewWidth, previewHeight, false);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        previewBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    private final ActivityResultLauncher<Intent> pickImage = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    if (result.getData() != null) {
                        Uri imageUri = result.getData().getData();
                        try {
                            InputStream inputStream = getContentResolver().openInputStream(imageUri);
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            binding.image.setImageBitmap(bitmap);
                            encodedImage = encodeImage(bitmap);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
    );

    private void setListeners() {

//        binding.buttonPost.setOnClickListener(v -> {
//            if (isValidSignUpDetails()) {
//                signUp();
//            }
//        });
        binding.image.setOnClickListener(v -> {
            listenerFunction();
        });
        binding.change.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), ForumAddCategoryActivity.class));
            finish();
        });
    }

    private void listenerFunction(){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        pickImage.launch(intent);
    }

//    private Boolean isValidPostDetails() {
//        if (encodedImage == null) {
//            showToast("Select profile image");
//            return false;
//        } else if (binding.inputName.getText().toString().trim().isEmpty()) {
//            showToast("Enter Name");
//            return false;
//        } else if (binding.inputEmail.getText().toString().trim().isEmpty()) {
//            showToast("Enter Email");
//            return false;
//        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.getText().toString()).matches()) {
//            showToast("Error invalid email");
//            return false;
//        } else if (binding.inputPassword.getText().toString().trim().isEmpty()) {
//            showToast("Enter password");
//            return false;
//        } else if (binding.inputConfirmPassword.getText().toString().trim().isEmpty()) {
//            showToast("Confirm your password");
//            return false;
//        } else if (!binding.inputPassword.getText().toString().equals(binding.inputConfirmPassword.getText().toString())) {
//            showToast("Password & confirm password are not matching");
//            return false;
//        } else {
//            return true;
//        }
//    }

}