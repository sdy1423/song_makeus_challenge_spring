package com.example.makeuschallenge.src.main.chatting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.makeuschallenge.R;
import com.example.makeuschallenge.src.BaseActivity;
import com.google.android.gms.common.internal.Constants;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Manager;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class ChattingActivity extends BaseActivity {

    private Socket mSocket;
//    RecyclerView messagesView;
    Button mBtnSubmit;
    EditText mEdtMessage;
    TextView mTvShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        mBtnSubmit=findViewById(R.id.chatting_btn_submit);
        mEdtMessage=findViewById(R.id.chatting_edt_message);
        mTvShow=findViewById(R.id.chatting_tv_show);

        try {
            mSocket = IO.socket("http://13.125.20.10:3000/room");
            mSocket.connect();

            mSocket.on(Socket.EVENT_CONNECT, (Object... objects) -> {
                mSocket.emit("createRoom","방이름이름");
            }).on("recMsg", new Emitter.Listener() {
                @Override
                public void call(Object... objects) {
                    JsonParser jsonParsers = new JsonParser();
                    JsonObject jsonObject = (JsonObject) jsonParsers.parse(objects[0] + "");
                    ChattingActivity.this.runOnUiThread(() -> {
                        showCustomToast( jsonObject.get("comment").getAsString());
                    });
                }
            });


            Log.e("LOG", String.valueOf(mSocket.connected()));

//            mSocket.on(Socket.EVENT_CONNECT, (Object... objects) -> {
////                JsonObject preJsonObject = new JsonObject();
////                preJsonObject.addProperty("roomName", "myroom");
////                JSONObject jsonObject = null;
////                try {
////                    jsonObject = new JSONObject(preJsonObject.toString());
////                } catch (JSONException e) {
////                    e.printStackTrace();
////                }
//                mSocket.emit("createRoom","방이름이름");
//            }).on("recMsg", new Emitter.Listener() {
//                @Override
//                public void call(Object... objects) {
//                    JsonParser jsonParsers = new JsonParser();
//                    JsonObject jsonObject = (JsonObject) jsonParsers.parse(objects[0] + "");
//                    ChattingActivity.this.runOnUiThread(() -> {
////                        mTvShow.setText(tvMain.getText().toString() + jsonObject.get("comment").getAsString());
//                        showCustomToast( jsonObject.get("comment").getAsString());
//                    });
//                }
//            });
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

//        mSocket.on(Socket.EVENT_CONNECT, onConnect);
//        mSocket.on("chat-message", onMessageReceived);

        //방만들기 test
        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                JsonObject preJsonObject = new JsonObject();
//                preJsonObject.addProperty("createRoom","상주세요");
//                JSONObject jsonObject = null;
//                try {
//                    jsonObject = new JSONObject(preJsonObject.toString());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                mSocket.emit("createRoom","상주세요");
            }


        });
    }

//    // Socket서버에 connect 된 후, 서버로부터 전달받은 'Socket.EVENT_CONNECT' Event 처리.
//    private Emitter.Listener onConnect = new Emitter.Listener() {
//        @Override
//        public void call(Object... args) {
//            // your code...
//        }
//    };
//    // 서버로부터 전달받은 'chat-message' Event 처리.
//    private Emitter.Listener onMessageReceived = new Emitter.Listener() {
//        @Override
//        public void call(Object... args) {
//            // 전달받은 데이터는 아래와 같이 추출할 수 있습니다.
//            JSONObject receivedData = (JSONObject) args[0];
//            // your code...
//        }
//    };
}
//    // 서버로 이벤트를 전송하는 부분에 적절히 추가하시면 될 것 같아요.
//    JSONObject data = new JSONObject();
//try {
//        data.put("key1", "value1");
//        data.put("key2", "value2");
//        mSocket.emit('event-name', data);
//        } catch(JSONException e) {
//        e.printStackTrace();
//        }