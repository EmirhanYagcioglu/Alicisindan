package com.cankutboratuncer.alicisindan.activities.ui.main.forum.forum;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cankutboratuncer.alicisindan.activities.ui.messaging.models.Advertisement;
import com.cankutboratuncer.alicisindan.activities.ui.messaging.models.ChatMessage;
import com.cankutboratuncer.alicisindan.activities.utilities.Constants;
import com.cankutboratuncer.alicisindan.activities.utilities.LocalSave;
import com.cankutboratuncer.alicisindan.databinding.ActivityForumChatBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class ForumChatActivity extends AppCompatActivity {

    ActivityForumChatBinding binding;
    private Advertisement advertisement;
    private List<ChatMessage> chatMessages;
    private ForumChatAdapter forumChatAdapter;
    private LocalSave localSave;
    private FirebaseFirestore database;
    private String conversionId = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForumChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
        init();
        loadReceiverDetails();
        listenMessages();
    }

    private void loadAdvertisementData() {
        advertisement = new Advertisement();
        advertisement.title = "aDLASJDLAKSDJa";
        advertisement.userId = "123";
        advertisement.userName = "aDLASJDLAKSDJa";
        advertisement.id = "Advertisement ID";
        advertisement.location = "aDLASJDLAKSDJa";
        advertisement.price = "123";
        advertisement.token = "123123";
    }

    private void init() {
        localSave = new LocalSave(getApplicationContext());
        chatMessages = new ArrayList<>();
        forumChatAdapter = new ForumChatAdapter(chatMessages, "getBitmapFromEncodedString(advertisement.image)", Constants.KEY_SENDER_ID);
        binding.chatRecyclerView.setAdapter(forumChatAdapter);
        database = FirebaseFirestore.getInstance();
    }

    private void setListeners() {
        //binding.imageBack.setOnClickListener(v -> onBackPressed());
        binding.buttonComment.setOnClickListener(v -> sendMessage());
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void listenMessages() {
        database.collection(Constants.KEY_COLLECTION_CHAT)
                .whereEqualTo(Constants.KEY_SENDER_ID, localSave.getString(Constants.KEY_USER_ID))
                .whereEqualTo(Constants.KEY_RECEIVER_ID, advertisement.id)
                .addSnapshotListener(eventListener);
        database.collection(Constants.KEY_COLLECTION_CHAT)
                .whereEqualTo(Constants.KEY_SENDER_ID, advertisement.id)
                .whereEqualTo(Constants.KEY_RECEIVER_ID, localSave.getString(Constants.KEY_USER_ID))
                .addSnapshotListener(eventListener);
    }

    private String getReadableDateTime(Date date) {
        return new SimpleDateFormat("MMMM dd, yyyy - hh: mm a", Locale.getDefault()).format(date);
    }

    private void addConversion(HashMap<String, Object> conversion) {
        database.collection(Constants.KEY_COLLECTION_CONVERSATIONS).add(conversion).addOnSuccessListener(documentReference -> conversionId = documentReference.getId());
    }

    private void updateConversion(String message) {
        DocumentReference documentReference = database.collection(Constants.KEY_COLLECTION_CONVERSATIONS).document(conversionId);
        documentReference.update(Constants.KEY_LAST_MESSAGE, message, Constants.KEY_TIMESTAMP, new Date());
    }

    private void checkForConversion() {
        if (chatMessages.size() != 0) {
            checkForConversionRemotely(localSave.getString(Constants.KEY_USER_ID), advertisement.id);
            checkForConversionRemotely(advertisement.id, localSave.getString(Constants.KEY_USER_ID));
        }
    }

    private void checkForConversionRemotely(String senderId, String receiverId) {
        database.collection(Constants.KEY_COLLECTION_CONVERSATIONS).whereEqualTo(Constants.KEY_SENDER_ID, senderId).whereEqualTo(Constants.KEY_RECEIVER_ID, receiverId).get().addOnCompleteListener(conversionOnCompleteListener);
    }

    private final OnCompleteListener<QuerySnapshot> conversionOnCompleteListener = task -> {
        if (task.isSuccessful() && task.getResult() != null && task.getResult().getDocuments().size() > 0) {
            DocumentSnapshot documentSnapshot = task.getResult().getDocuments().get(0);
            conversionId = documentSnapshot.getId();
        }
    };

    private void sendMessage() {
        HashMap<String, Object> message = new HashMap<>();
        message.put(Constants.KEY_SENDER_ID, localSave.getString(Constants.KEY_USER_ID));
        message.put(Constants.KEY_RECEIVER_ID, advertisement.id);
//        message.put(Constants.KEY_MESSAGE, binding.messageInputField.getText().toString());
        message.put(Constants.KEY_MESSAGE, "Hello");
        message.put(Constants.KEY_TIMESTAMP, new Date());
        database.collection(Constants.KEY_COLLECTION_CHAT).add(message);

        if (conversionId != null) {
//            updateConversion(binding.messageInputField.getText().toString());
            updateConversion("Hello");
        } else {
            HashMap<String, Object> conversion = new HashMap<>();
            conversion.put(Constants.KEY_SENDER_ID, localSave.getString(Constants.KEY_USER_ID));
            conversion.put(Constants.KEY_SENDER_NAME, localSave.getString(Constants.KEY_USER_NAME));
            conversion.put(Constants.KEY_SENDER_IMAGE, localSave.getString(Constants.KEY_IMAGE));
            conversion.put(Constants.KEY_RECEIVER_ID, advertisement.id);
            conversion.put(Constants.KEY_RECEIVER_NAME, advertisement.title);
            //conversion.put(Constants.KEY_RECEIVER_IMAGE, advertisement.image);
//            conversion.put(Constants.KEY_LAST_MESSAGE, binding.messageInputField.getText().toString());
            conversion.put(Constants.KEY_LAST_MESSAGE, "Hello");
            conversion.put(Constants.KEY_TIMESTAMP, new Date());
            addConversion(conversion);
        }
//        binding.messageInputField.setText(null);
    }


    private final EventListener<QuerySnapshot> eventListener = (value, error) -> {
        if (error != null) {
            return;
        }
        if (value != null) {
            int count = chatMessages.size();
            for (DocumentChange documentChange : value.getDocumentChanges()) {
                if (documentChange.getType() == DocumentChange.Type.ADDED) {
                    ChatMessage chatMessage = new ChatMessage();
                    chatMessage.senderId = documentChange.getDocument().getString(Constants.KEY_SENDER_ID);
                    chatMessage.receiverId = documentChange.getDocument().getString(Constants.KEY_RECEIVER_ID);
                    chatMessage.message = documentChange.getDocument().getString(Constants.KEY_MESSAGE);
                    chatMessage.dateTime = getReadableDateTime(documentChange.getDocument().getDate(Constants.KEY_TIMESTAMP));
                    chatMessage.dateObject = documentChange.getDocument().getDate(Constants.KEY_TIMESTAMP);
                    chatMessages.add(chatMessage);
                }
            }
            Collections.sort(chatMessages, (obj1, obj2) -> obj1.dateObject.compareTo(obj2.dateObject));
            if (count == 0) {
                forumChatAdapter.notifyDataSetChanged();
            } else {
                forumChatAdapter.notifyItemRangeInserted(chatMessages.size(), chatMessages.size());
                binding.chatRecyclerView.smoothScrollToPosition(chatMessages.size() - 1);
            }
            binding.chatRecyclerView.setVisibility(View.VISIBLE);
        }
        binding.progressBar.setVisibility(View.GONE);
        if (conversionId == null) {
            checkForConversion();
        }
    };

    private Bitmap getBitmapFromEncodedString(String encodedImage) {
        if (encodedImage != null) {
            byte[] bytes = Base64.decode(encodedImage, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        } else {
            return null;
        }
    }

    private void loadReceiverDetails() {

        loadAdvertisementData();
//        binding.productCardTitle.setText(advertisement.title);
//        binding.productCardPrice.setText(advertisement.price);
//        binding.productCardLocation.setText(advertisement.location);
//        binding.userCardName.setText(advertisement.userName);
    }

}












