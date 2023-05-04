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
import com.cankutboratuncer.alicisindan.databinding.ActivityPostEditBinding;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ForumEditActivity extends AppCompatActivity {

    private ActivityForumAddCategoryBinding binding;
    private String encodedImage;
    private LocalSave localSave;
    private int imageRow;
    private int imageCol;
    private AppCompatImageButton[][] imageButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForumAddCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        localSave = new LocalSave(getApplicationContext());
        initImageButton();
        setListeners();
    }

    private void initImageButton(){
        imageCol = 0;
        imageRow = 0;
        imageButtons = new AppCompatImageButton[3][3];
        imageButtons[0] = new AppCompatImageButton[]{binding.imagesRow11, binding.imagesRow12, binding.imagesRow13};
        imageButtons[1] = new AppCompatImageButton[]{binding.imagesRow21, binding.imagesRow22, binding.imagesRow23};
        imageButtons[2] = new AppCompatImageButton[]{binding.imagesRow31, binding.imagesRow32, binding.imagesRow33};
    }

    private void updateImageRowCol(){
        imageCol ++;
        imageRow += imageCol == 3 ? 1 : 0;
        imageCol = imageCol == 3 ? 0 : imageCol;
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
                            imageButtons[imageRow][imageCol].setImageBitmap(bitmap);
                            updateImageRowCol();
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
        binding.imagesRow11.setOnClickListener(v -> {
            listenerFunction();
        });
        binding.imagesRow12.setOnClickListener(v -> {
            listenerFunction();
        });
        binding.imagesRow13.setOnClickListener(v -> {
            listenerFunction();
        });
        binding.imagesRow21.setOnClickListener(v -> {
            listenerFunction();
        });
        binding.imagesRow22.setOnClickListener(v -> {
            listenerFunction();
        });
        binding.imagesRow23.setOnClickListener(v -> {
            listenerFunction();
        });
        binding.imagesRow31.setOnClickListener(v -> {
            listenerFunction();
        });
        binding.imagesRow32.setOnClickListener(v -> {
            listenerFunction();
        });
        binding.imagesRow33.setOnClickListener(v -> {
            listenerFunction();
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