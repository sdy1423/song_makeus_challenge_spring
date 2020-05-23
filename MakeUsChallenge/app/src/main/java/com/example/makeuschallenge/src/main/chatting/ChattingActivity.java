package com.example.makeuschallenge.src.main.chatting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.makeuschallenge.R;
import com.example.makeuschallenge.src.BaseActivity;
import com.example.makeuschallenge.src.login.LoginActivity;
import com.google.android.gms.common.internal.Constants;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Arrays;

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
//    MyClientTask myClientTask;

    ListView listView;
    ChattingAdapter chattingAdapter;

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
                mSocket.emit("joinRoom","방이름이름");
            }).on("sendMsgFromServer", new Emitter.Listener() {
                @Override
                public void call(Object... objects) {
//                    JsonParser jsonParsers = new JsonParser();
//                    JsonObject jsonObject = (JsonObject) jsonParsers.parse(objects[0] + "");
                    Log.e("tag",""+ Arrays.toString(objects));
//                    runOnUiThread(()->{
//                        tvMain.setText(tvMain.getText().toString()+jsonObject.get("comment").getAsString());
//                    });
                }
            });

//            mSocket.on(Socket.EVENT_CONNECT, onConnect);
//            mSocket.on("chat-message", onMessageReceived);


            Log.e("LOG", String.valueOf(mSocket.connected()));

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


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
                mSocket.emit("sendMsgFromClient","dkdkdkdkdkdk");
            }
        });



//        myClientTask = new MyClientTask(mEditTextAddress.getText().toString(), Integer.parseInt(mEditTextPort.getText().toString()), messageText.getText().toString());
//        myClientTask.execute();


        ///////////////////////////////////
        //TODO oncreate
        chattingAdapter = new ChattingAdapter(this.getApplicationContext(),R.layout.chatting_message);
        listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(chattingAdapter);
        listView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL); // 이게 필수

        chattingAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(chattingAdapter.getCount()-1);
            }
        });

        //TODO Selected



    }


    // Socket서버에 connect 된 후, 서버로부터 전달받은 'Socket.EVENT_CONNECT' Event 처리.
    private Emitter.Listener onConnect = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            // your code...
        }
    };
    // 서버로부터 전달받은 'chat-message' Event 처리.
    private Emitter.Listener onMessageReceived = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            // 전달받은 데이터는 아래와 같이 추출할 수 있습니다.
            JSONObject receivedData = (JSONObject) args[0];
            Log.e("message",receivedData.toString());
            // your code...
        }
    };
//
//
//    public class MyClientTask extends AsyncTask<Void, Void, Void> {
//        String dstAddress;
//        int dstPort;
//        String response = "";
//        String myMessage = "";
//        //constructor
//        MyClientTask(String addr, int port, String message) {
//            dstAddress = addr;
//            dstPort = port;
//            myMessage = message;
//        }
//        @Override
//        protected Void doInBackground(Void... arg0) {
//            Socket socket = null;
//            myMessage = myMessage.toString();
//            try {
//                socket = new Socket(dstAddress, dstPort);
//                //송신
//                OutputStream out = socket.getOutputStream();
//                out.write(myMessage.getBytes());
//                Log.d("로그", "메세지 전송");
//                //수신
//                CharArrayWriter output = new CharArrayWriter(1024);
//                byteArrayOutputStream = new ByteArrayOutputStream(1024);
//                byte[] buffer = new byte[1024];
//                int bytesRead;
//                InputStream inputStream = socket.getInputStream();
//                InputStream is = new BufferedInputStream(socket.getInputStream());
//                BufferedOutputStream os = new BufferedOutputStream(socket.getOutputStream());
//                /*
//                 * notice:
//                 * inputStream.read() will block if no data return
//                 */
//                while ((bytesRead = inputStream.read(buffer)) != -1) {
//                    byteArrayOutputStream.write(buffer, 0, bytesRead);
//                    Message msg = mHandler.obtainMessage();
//                    Bundle data = new Bundle();
//                    /*if (byteArrayOutputStream.toString("UTF-8").length() == 4) {
//                        byteArrayOutputStream.reset();
//                    }*/
//                    data.putString("data", byteArrayOutputStream.toString("UTF-8"));
////                    Log.d("로그", "값 = " + data);
//                    msg.setData(data);
//                    mHandler.sendMessage(msg);
//                    response = "서버의 응답: " + response;
//                }
////
//                response = "카운트 종료";
//            } catch (UnknownHostException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//                Log.d("TAG", e + "");
//                response = "UnknownHostException: " + e.toString();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//                Log.d("TAG", e + "");
//                response = "IOException: " + e.toString();
//            } finally {
//                if (socket != null) {
//                    socket.close();
//                }
//            }
//            return null;
//        }
//        @Override
//        protected void onPostExecute(Void result) {
//            mRecieveText.setText(response);
//            super.onPostExecute(result);
//        }
//    }


}
